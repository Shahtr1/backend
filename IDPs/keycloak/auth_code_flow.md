# How Keycloak Authentication + JWT + SSO Works in Java Microservices (CQRS + Axon)

## Step 1: User Opens Your Application (Frontend App)

Imagine your user — say a supplier — opens your frontend application:

```arduino
https://supplier-app.com
```

Your frontend is a **public client** (meaning it cannot keep secrets). It’s not responsible for storing passwords — it delegates authentication to Keycloak.

The app shows a “Login” button. When the user clicks it:

The app redirects the user to **Keycloak’s** login endpoint, using the **Authorization Code Flow**.

This is the redirect URL:

```perl
https://keycloak.company.com/auth/realms/supplier-finance/protocol/openid-connect/auth
?response_type=code
&client_id=frontend-app
&redirect_uri=https://supplier-app.com/callback
&scope=openid profile email
&state=abc123
&code_challenge=xyz789
&code_challenge_method=S256
```

| Query Param                  | Meaning                                                |
| ---------------------------- | ------------------------------------------------------ |
| `response_type=code`         | We're using the **Authorization Code Flow**            |
| `client_id=frontend-app`     | The name of the frontend client registered in Keycloak |
| `redirect_uri`               | Where Keycloak will send the user after login          |
| `scope=openid`               | Requests OpenID Connect support (for user identity)    |
| `code_challenge`             | A hashed random value (used in PKCE)                   |
| `code_challenge_method=S256` | Hashing method for the challenge (SHA-256)             |

Result of Step 1:

- User is redirected from your app to `Keycloak’s login` page.
- They now see a secure login form hosted by Keycloak.

## Step 2: Keycloak Login Page & Authentication

Now the user is on Keycloak’s hosted login page. This page is served directly by Keycloak, not your app.

What the User Sees:

A login form asking for:

- Username or Email
- Password

Optionally:

- A “Forgot Password?” link
- A “Register” link (if you enabled self-registration)
- Social logins (like Google, GitHub) — if configured

What Happens Internally When the User Submits the Form:

1.  Keycloak checks the entered credentials against its user database for the realm (e.g., `supplier-finance`).

    - This DB might be internal, LDAP, Active Directory, or even a custom user provider.

2.  If credentials are invalid:

    - Keycloak shows an error on the login page.
    - The user stays on the login screen.

3.  If credentials are valid:

    - Keycloak logs the user in and creates a server-side login session.
    - This session is tracked using a Keycloak session cookie stored in the browser.
      - Cookie name: `KEYCLOAK_SESSION`
      - This is what enables **SSO** later (we'll cover that in Step 9).

4.  Keycloak now prepares to redirect the user back to your application, but it does not send a token yet. It sends a temporary code — we’ll handle that in Step 3.

Security Note:

- Your application never sees the password.
- Login happens entirely within Keycloak, which is the secure identity provider.

Result of Step 2:

- User is successfully authenticated.
- Keycloak has created a session for them.
- The browser is redirected back to your app with an authorization code in the URL.

## Step 3: Authorization Code is Returned to Your Application (Frontend)

After the user logs in successfully, Keycloak redirects the browser back to your frontend app — to the `redirect_uri` you specified earlier.

Reditrect looks like:

```http
https://supplier-app.com/callback?code=abc123&state=xyz456
```

| Parameter      | Meaning                                                      |
| -------------- | ------------------------------------------------------------ |
| `code=abc123`  | The **authorization code** — a short-lived, single-use token |
| `state=xyz456` | A value sent earlier by the app to prevent CSRF attacks      |

Why Not Send the JWT Token Directly?
Because:

1.  `Security`: If someone intercepts the redirect, they can't do anything with this code.
2.  It allows **PKCE** to prove the app is legit.
3.  It separates user login from token issuance.

So now the frontend:

- Has an **authorization code**
- Will use it in the next step to securely get the **JWT** access token

### PKCE (Proof Key for Code Exchange)

- This protects the flow from **interception**.
- The frontend generates a `code_verifier` → hashes it → sends it as `code_challenge`.

  1.  Frontend generates a `code_verifier`:
      When the frontend app starts the login process, it creates a random string like:
      ```plaintext
         code_verifier = "uQx9tm8uB30ZbsYpi1kOka3nY0U"
      ```
      This is stored temporarily in memory (not sent yet).
  2.  Frontend generates a `code_challenge` from that verifier
      It hashes the `code_verifier` using **SHA-256**, and encodes it in Base64:

      ```plaintext
         code_challenge = BASE64URL-ENCODE(SHA256(code_verifier))
      ```

      Example:
      code_challenge = "LzJZyQ...abc"

      This hashed challenge is sent to Keycloak in the redirect URL during the login request:

      ```http
      https://keycloak.company.com/auth/realms/supplier-finance/protocol/openid-connect/auth
      ?response_type=code
      &client_id=frontend-app
      &redirect_uri=...
      &code_challenge=LzJZyQ...abc
      &code_challenge_method=S256
      ```

  3.  User logs in at Keycloak → Keycloak redirects back
      Once login succeeds, Keycloak **does not give the token yet**. It instead gives a temporary code (like a claim ticket).

      ```http
      https://supplier-app.com/callback?code=abc123
      ```

      This `code` is only useful if you can prove you know the original `code_verifier`.

  4.  Frontend exchanges the code for a token
      Now the frontend sends a secure POST request to Keycloak’s `/token` endpoint:

      ```http
      POST /token

      Content-Type: application/x-www-form-urlencoded

      grant_type=authorization_code
      code=abc123
      client_id=frontend-app
      redirect_uri=https://supplier-app.com/callback
      code_verifier=uQx9tm8uB30ZbsYpi1kOka3nY0U ← 🔑 original one
      ```

  What Keycloak does here:

  - It takes the `code_verifier`, hashes it using SHA-256
  - Compares it to the original `code_challenge` it got in Step 2
  - If they match → ✅ authentication is verified and secure
  - Keycloak issues the access token (JWT) and optional refresh token

  Why is PKCE Important?
  Without PKCE:

  - An attacker could intercept the code (in Step 3) and use it to get a token themselves.

  With PKCE:

  - The attacker doesn’t have the code_verifier, so the token exchange will fail.

  It proves: **“Yes, I’m the same app that started this login request.”**

## Step 4: Frontend Exchanges Authorization Code for Access Token (JWT)

Response from Keycloak
If everything is valid, Keycloak responds with:

```json
{
  "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
  "expires_in": 300,
  "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "token_type": "Bearer",
  "id_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

Token Breakdown:

1.  Access Token (JWT)

- This is the main token.
- It contains your user identity, roles, issuer, expiration, etc.
- It’s what your frontend will attach to every API call.

2.  Refresh Token

- Used to get a new access token when it expires (instead of logging in again).
- Should be stored securely and only used if needed.

3.  ID Token

- Only used if you're displaying identity info in the frontend.
- Often used for displaying the user’s name or avatar.

Security Note:

- This step MUST happen over **HTTPS**
- The `code_verifier` prevents attacks even if someone hijacks the code

Result of Step 4:

- Your frontend app now has a **valid Access Token (JWT)**
- It will now send this token to your backend microservices to prove the user’s identity

## Step 5: What’s Inside a JWT Token?

When your frontend gets the Access Token from Keycloak, it looks like a long string:

```text
eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.
eyJzdWIiOiJ1c2VyLTEyMyIsInByZWZlcnJlZF91c2VybmFtZSI6ImNsYXkiLCJyb2xlcyI6WyJTVVBQTElFUiJdLCJleHAiOjE3MjM0NTg0MDAsImlhdCI6MTcyMzQ1NTAwMCwiaXNzIjoiaHR0cHM6Ly9rZXljbG9hay5jb20vcmVhbG1zL3N1cHBsaWVyLWZpbmFuY2UifQ.
signatureHere
```

That’s a **JWT**: a **JSON Web Token**. It’s just a Base64-encoded, signed JSON object — like a digital ID card.

What Happens When You Decode It?
You can paste it into https://jwt.io and see 3 parts:

1. Header

```json
{
  "alg": "RS256",
  "typ": "JWT"
}
```

| Field | Meaning                                                 |
| ----- | ------------------------------------------------------- |
| `alg` | Signing algorithm used (e.g., RS256 = RSA with SHA-256) |
| `typ` | Token type (JWT)                                        |

2. Payload (Claims)

This is the actual user information. Example:

```json
{
  "sub": "user-123",
  "preferred_username": "clay",
  "email": "clay@example.com",
  "realm_access": {
    "roles": ["SUPPLIER"]
  },
  "iat": 1723455000,
  "exp": 1723458600,
  "iss": "https://keycloak.company.com/realms/supplier-finance",
  "aud": "frontend-app"
}
```

| Field                | Meaning                                                  |
| -------------------- | -------------------------------------------------------- |
| `sub`                | Subject = unique ID of the user                          |
| `preferred_username` | Username to display                                      |
| `email`              | User’s email address                                     |
| `realm_access.roles` | List of user’s assigned roles                            |
| `iat`                | Issued At (UNIX timestamp)                               |
| `exp`                | Expiration time                                          |
| `iss`                | Issuer = which Keycloak realm issued the token           |
| `aud`                | Audience = which client (app) this token is intended for |

3. Signature

The third part is a **cryptographic signature**, created with Keycloak’s private key.

- Your microservices use Keycloak’s public key to verify that:
  - This token is valid
  - It hasn’t been modified

What Makes JWT Powerful?

- It’s stateless: contains all the info needed — no database lookup
- It’s signed: can’t be tampered with
- It contains roles → so your backend can easily enforce access control

Where This Fits in Your Flow
From now on, your frontend will send this token with every request to the backend:

```http
Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6...
```

And your backend will:

1.  Decode it
2.  Verify it
3.  Read roles and user ID from it

Result of Step 5:

- You now understand exactly what’s inside a JWT
- It’s a signed, self-contained identity card
- Your backend will use it to authenticate and authorize users

## Step 6: Frontend Sends JWT to Backend (Microservices)

Now that your frontend has the **Access Token (JWT)** from Keycloak, it needs to send it to your backend microservices to:

- Prove the user is authenticated
- Allow or deny access based on their roles

Every API Request from Frontend Looks Like This:

```http
GET /api/invoices/123
Host: api.supplier-app.com
Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...
```

The Authorization header uses the "**Bearer**" scheme, meaning:
“This is the token that proves who I am — trust it.”

What Happens on the Backend (Microservice)?

Each microservice is configured as a resource server in Spring Boot. That means it knows how to:

- Accept a JWT token
- Verify that it's valid
- Extract user info (subject, roles, etc.)
- Reject unauthorized or expired tokens

Spring Boot Configuration (in your microservice)

```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://keycloak.company.com/realms/supplier-finance
```

This tells Spring Security:

- “Go fetch the public key from Keycloak”
- “Use it to validate every incoming JWT token”

When a request comes in with a token, Spring Security will:

1.  Decode the JWT
2.  Check:
    - Signature: is it valid?
    - Expiration: is it still valid?
    - Issuer: was it issued by the right Keycloak realm?
3.  Convert the `roles` from the JWT into Spring Security authorities

So you don’t need to write your own token parser — it’s all handled for you.

Now You Can Secure Methods with Roles

```java
@PreAuthorize("hasRole('SUPPLIER')")
@PostMapping("/invoices")
public ResponseEntity<Void> createInvoice(...) {
    commandGateway.send(new CreateInvoiceCommand(...));
    return ResponseEntity.ok().build();
}
```

Result of Step 6:

- Your frontend is sending the JWT on every request
- Your microservices validate the token automatically
- You can now protect your APIs based on roles from the token

## Step 7: Backend Validates the JWT (Spring Boot Resource Server + Keycloak)

This step is all about how your backend microservices (e.g., `invoice-command-service`, `invoice-query-service`) **trust and verify** the JWT that the frontend sends.

At this point, your microservice acts like a customs officer:

- It inspects every token (passport)
- It checks its authenticity, validity, and permissions

```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://keycloak.company.com/realms/supplier-finance
```

### Internally, Spring Does:

1.  Downloads the **JWKS (JSON Web Key Set)** from:

```ruby
https://keycloak.company.com/realms/supplier-finance/protocol/openid-connect/certs
```

This JWKS contains the **public keys** used to verify the signature of tokens.

2. Validates the token:

- Is the JWT well-formed?
- Was it signed using the correct key?
- Has it expired?
- Does `iss` match the issuer URI?
- Does the token have the correct audience (`aud`)?

3. Extracts the user info (claims) from the token:

```json
{
  "preferred_username": "clay",
  "realm_access": {
    "roles": ["SUPPLIER", "USER"]
  },
  "sub": "user-123",
  "exp": 1723459200
}
```

These claims are turned into a `JwtAuthenticationToken` object that Spring uses in the current **security context**.

4. Applies method-level security:

```java
@PreAuthorize("hasRole('SUPPLIER')")
```

How Roles Are Mapped
By default, Keycloak puts roles under:

```json
"realm_access": {
  "roles": ["SUPPLIER", "FINANCIER"]
}
```

Spring needs to be told to **treat those as authorities**.

Optionally, you can define a custom `JwtAuthenticationConverter` in your config to read them properly:

```java
@Bean
public JwtAuthenticationConverter jwtAuthenticationConverter() {
    JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
    converter.setAuthoritiesClaimName("realm_access.roles");
    converter.setAuthorityPrefix("ROLE_");

    JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
    jwtConverter.setJwtGrantedAuthoritiesConverter(converter);
    return jwtConverter;
}
```

This makes sure SUPPLIER from the token becomes `ROLE_SUPPLIER` in Spring Security.

Result of Step 7:

- Your microservice verifies every token
- It checks validity, issuer, expiration, signature, and roles
- It securely determines if a user can perform the action based on the token content

## Step 8: Handling Token Expiration and Refresh Tokens

JWT access tokens — like the one issued by Keycloak — are short-lived by design.

| Token Type             | Purpose                        | Lifetime                               |
| ---------------------- | ------------------------------ | -------------------------------------- |
| **Access Token** (JWT) | Used for API calls             | ⏳ 5–15 minutes                        |
| **Refresh Token**      | Used to get a new access token | 🔁 30 minutes to several hours or days |

You can configure both durations in the Keycloak admin panel under:
`Realm → Clients → frontend-app → Settings → Access Token Lifespan`

How the Refresh Flow Works
Let’s say:

- The `Access Token` expires after 5 minutes
- But the user is still active in your frontend app

Instead of forcing them to log in again, the frontend can use the `Refresh Token` to get a new Access Token `without user interaction`.

POST Request to Keycloak (from the frontend or backend):

```http
POST https://keycloak.company.com/auth/realms/supplier-finance/protocol/openid-connect/token
Content-Type: application/x-www-form-urlencoded

grant_type=refresh_token
&client_id=frontend-app
&refresh_token=eyJhbGciOiJIUzI1NiIsInR5cCI6...
```

Response from Keycloak:

```json
{
  "access_token": "new JWT token here",
  "refresh_token": "new refresh token",
  "expires_in": 300
}
```

Keycloak usually gives a **new refresh token** as well — this is called refresh token rotation, and it's a good security practice.

What Happens if Both Tokens Expire?
Then the user is **no longer authenticated** and must:

- Be redirected to Keycloak login page again
- Start the Authorization Code Flow from scratch

## Step 9: Single Sign-On (SSO) in Keycloak

What Is SSO?

A user logs in once, and then they can access multiple applications without logging in again — as long as those apps trust the same identity provider (Keycloak in this case).

How Does SSO Work in Keycloak

Let’s say your system has 3 apps:

- `https://supplier-app.com`
- `https://admin-dashboard.com`
- `https://reporting-tool.com`

All of them are registered as `clients in the same Keycloak realm`.

What Happens When a User Logs into One App?

Scenario:

1.  User logs into supplier-app.com
2.  Keycloak authenticates them and creates a **login session**
3.  Keycloak sets a **secure browser cookie** (e.g., `KEYCLOAK_SESSION`) for its domain
4.  The browser keeps this cookie for the duration of the session

Now the User Opens Another App:

They go to:

```plaintext
https://admin-dashboard.com
```

What happens?

- That app also redirects to Keycloak for login.
- But Keycloak sees the existing session cookie in the browser.
- So Keycloak doesn’t show the login form again.
- It immediately redirects back to the app with a new authorization code.
- The app then gets a new access token.

🔄 The user never sees a second login screen. That’s the SSO effect.

Where Is the Session Stored?

- The session is stored server-side in Keycloak (not in your app).
- It's tracked by a cookie scoped to the Keycloak domain.
- The browser sends that cookie on every redirect to Keycloak.

Bonus: Global Logout
You can provide a "Logout Everywhere" feature by calling:

```http
GET /protocol/openid-connect/logout
```

Result of Step 10:

- Users authenticate once, use many apps without interruption
- Centralized identity and access control via Keycloak
- Great UX, reduced password fatigue, and improved security
