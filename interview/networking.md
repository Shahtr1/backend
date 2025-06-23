## Networking Topics

❓ 100 Networking Interview Questions
🌐 HTTP/HTTPS & Web Fundamentals (Q1–Q20)
What happens when you type a URL in the browser?

What is the difference between HTTP and HTTPS?

What are common HTTP methods (GET, POST, PUT, DELETE)?

What are idempotent methods? Why do they matter?

What are HTTP status codes (200, 301, 404, 500)?

What’s the difference between 301 and 302?

What’s a RESTful API?

What is statelessness in HTTP?

What is the purpose of HTTP headers?

How does TLS/SSL encryption work?

What are cookies and sessions?

How do HTTP Keep-Alive and pipelining work?

What’s chunked transfer encoding?

How is caching controlled via HTTP?

What is the purpose of a User-Agent header?

What are ETag and Last-Modified headers?

What are Content-Type and Accept headers used for?

What is a MIME type?

What’s the difference between JSON and XML for APIs?

What is HTTP/2 and what advantages does it offer?

🌍 DNS, IP, Ports, and Sockets (Q21–Q40)
What is DNS and how does it work?

What is the difference between A record, CNAME, and MX record?

What is TTL in DNS?

What are public vs private IPs?

What is a port number and how is it used?

What is a socket?

How does TCP establish a connection (3-way handshake)?

What is the difference between TCP and UDP?

What are ephemeral ports?

How does DNS caching work?

What is reverse DNS lookup?

What is NAT (Network Address Translation)?

How does port forwarding work?

What is a firewall and how does it impact APIs?

What is the OSI model? Where does HTTP fit?

What is the difference between MAC address and IP address?

How does traceroute work?

What is a CDN and how does it reduce latency?

What is DNS poisoning?

What is an SRV record?

🧪 TCP/IP, Load Balancing & Performance (Q41–Q65)
What is MTU and how does it affect performance?

How does TCP ensure reliability?

What is TCP congestion control?

What is Nagle’s algorithm?

What is latency vs bandwidth?

How does load balancing work (round robin, least connections)?

What is sticky session?

What are common Layer 7 load balancers?

How does a reverse proxy differ from a forward proxy?

What are common performance bottlenecks in a web app?

How does packet loss affect TCP vs UDP?

What is TCP slow start?

What is TLS handshake and what’s exchanged?

How do self-signed certificates work?

What is HSTS (HTTP Strict Transport Security)?

How do you scale web sockets?

How do retries impact network performance?

How can you prevent DDoS at network level?

What is connection pooling?

What is ALB vs NLB in AWS?

🔐 Security, Certificates, Encryption (Q66–Q85)
How does HTTPS protect against MITM attacks?

What is symmetric vs asymmetric encryption?

What is RSA? What is it used for?

How are SSL certificates issued and verified?

What is a root certificate?

How does DNS over HTTPS work?

What is a CSRF attack?

What is XSS and how can HTTP headers help prevent it?

What is a secure cookie?

What are CORS headers?

How do HMAC and JWT work?

How to secure APIs exposed over the internet?

How to implement OAuth 2.0 authentication?

What is client-side vs server-side certificate?

How is session hijacking prevented?

How does token expiration work?

What is HTTPS downgrade attack?

What is TLS 1.3 vs TLS 1.2?

What is a man-in-the-middle attack?

What is certificate pinning?

🧠 System & Architecture Applications (Q86–Q100)
What happens to an HTTP request inside a VPC?

How would you secure a public-facing REST API?

How does DNS failover work for high availability?

How do you detect broken connections over TCP?

How would you architect a chat server with WebSockets?

How does rate limiting work at the gateway level?

How do you support international users (geo-routing)?

How do you throttle outbound requests?

How does service discovery work in microservices?

What is a heartbeat signal and why is it needed?

How do you log HTTP request latency?

How would you measure API uptime?

How does load balancer health check work?

What is the difference between polling, long-polling, and WebSocket?

How do proxies cache content?

When would you use HTTP 304?

How do hybrid mobile apps interact with APIs?

How do you secure admin endpoints over the network?

What are the pros/cons of client-side load balancing?

How does network partition affect distributed systems?

💡 Visual Example – TCP Handshake
arduino
Copy
Edit
Client ----------------> Server SYN
Client <---------------- Server SYN-ACK
Client ----------------> Server ACK
Connection Established
