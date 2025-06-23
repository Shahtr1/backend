## Keycloak Core Concepts (1–30)

What is Keycloak?

What is a Realm in Keycloak?

What is a Client in Keycloak?

What is the difference between public and confidential clients?

What are Realm Roles vs Client Roles?

What is a user federation?

How does Keycloak support LDAP?

What is the default authentication flow in Keycloak?

What is the Keycloak Admin Console?

How do you export/import realms?

What is a protocol mapper in Keycloak?

How does Keycloak implement OAuth2?

What is a client scope?

How do you configure CORS in Keycloak?

What is the difference between Direct Access Grant and Authorization Code flow?

How does Keycloak handle refresh tokens?

How do you implement Single Sign-On with Keycloak?

What are offline tokens?

How do you enable multi-factor authentication (MFA)?

What is the Keycloak theme system?

How do you customize login pages in Keycloak?

How can you write a custom authenticator SPI?

What are Keycloak's supported identity protocols?

What is the difference between identity brokering and user federation?

How can you configure social login in Keycloak?

How does the "First Broker Login" flow work?

How does logout work in a federated IdP setup?

How does Keycloak handle session expiration?

How do you secure a Spring Boot app with Keycloak?

What is a trusted host in Keycloak?

🔐 OAuth 2.0 & OpenID Connect (31–60)
What is OAuth 2.0?

What are the main roles in OAuth 2.0?

What is the Authorization Code Flow?

What is the Implicit Flow and why is it discouraged?

What is a refresh token?

What is a resource owner in OAuth?

What is the role of the resource server?

What is the client credentials flow used for?

What are the major security concerns in OAuth 2.0?

What is token introspection?

How does PKCE enhance OAuth security?

What is the purpose of scopes in OAuth?

What is an access token vs an ID token?

How do you revoke an access token?

What is OpenID Connect (OIDC)?

How does OIDC extend OAuth 2.0?

What is a nonce in OIDC?

What claims are included in an ID token?

What is the userinfo endpoint?

How do you implement login with Google using OAuth?

What is the state parameter used for in OAuth?

What are best practices for storing OAuth tokens?

How do you secure a native app with OAuth?

What are the differences between OAuth 1.0 and 2.0?

What is token chaining?

How do you validate JWT access tokens?

What is an authorization server?

What are dynamically registered clients?

How does OAuth work in mobile apps?

What are JWTs and how do they fit in OAuth/OIDC?

🧩 SAML & Identity Federation (61–80)
What is SAML?

What are the core components of SAML?

How does SAML differ from OAuth2?

What is a SAML Assertion?

What are the major use cases for SAML?

What is an Identity Provider (IdP) in SAML?

What is a Service Provider (SP) in SAML?

How is a SAML request initiated?

What is Single Logout (SLO) in SAML?

How is encryption handled in SAML?

What is metadata exchange in SAML?

What are attributes in SAML assertions?

How do you set up SAML IdP with Keycloak?

How can you troubleshoot SAML issues in Keycloak?

What is artifact binding in SAML?

What is the difference between POST and Redirect bindings?

How does Just-In-Time (JIT) user provisioning work in SAML?

How does SAML handle session expiration?

What tools can you use to debug SAML assertions?

What is RelayState in SAML?

🌐 Other Identity Providers (IdPs) (81–100)
What is an Identity Provider (IdP)?

What are some examples of popular IdPs?

How do you integrate Azure AD with Keycloak?

How do you configure Okta as an OIDC IdP in Keycloak?

What is the difference between OIDC and SAML IdPs?

What is SCIM and how is it used with IdPs?

How do you configure Active Directory as a user federation source?

How do you manage trust between IdPs and SPs?

What is WS-Federation?

How do you support passwordless login with an IdP?

How can you achieve centralized authentication with multiple apps?

How does account linking work in federated login?

What is step-up authentication?

How do you use Google Workspace as an IdP?

What are identity pools and how are they used?

How do you sync users across multiple IdPs?

What are IdP-initiated vs SP-initiated login flows?

How do you configure identity brokering in Keycloak?

What’s the role of federation metadata in enterprise IdP integrations?

How do you test IdP integrations locally?
