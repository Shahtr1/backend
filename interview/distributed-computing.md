## Distributed Computing

❓ 100 Distributed Systems Interview Questions
⚙️ Concepts & Theory (Q1–Q25)
What is the CAP theorem?

What is the difference between consistency and availability?

What is eventual consistency?

What is quorum in distributed systems?

How do you handle network partitions?

What is a distributed transaction? Why is it difficult?

What’s the difference between 2PC and Saga pattern?

Explain leader election in distributed systems.

What are some strategies for load balancing?

How does hashing help in data partitioning?

What is sharding and when do you need it?

Explain heartbeats and how failure is detected.

What is a distributed cache? How do you maintain consistency?

What is write-ahead logging?

Explain tail latency and how to reduce it.

What is backpressure?

What are idempotent operations?

Why are distributed systems hard to test?

What’s the difference between latency and throughput?

What are retries with exponential backoff?

What is the difference between synchronous and asynchronous communication?

What is data replication? When do you use active-active vs active-passive?

What is eventual vs strong consistency?

What is a consensus algorithm? (e.g., Paxos, Raft)

What is the split-brain problem?

🌐 APIs, Microservices & Comms (Q26–Q45)
Design a RESTful API for a file sharing system.

How does service discovery work in microservices?

What is gRPC and when would you prefer it over REST?

How do you secure microservices communication?

What’s the role of API gateways?

How do you implement service versioning?

How to deal with schema evolution?

What is a contract-first vs code-first API design?

What is the role of OpenAPI/Swagger?

How does circuit breaker pattern work?

What are retries, timeouts, and fallbacks in APIs?

What are sidecars in service mesh (e.g., Istio)?

What is service mesh and what problems does it solve?

How do you monitor service health?

What are golden signals for distributed systems?

How would you log and trace requests across services?

What is distributed tracing?

What is an idempotent API? Give an example.

Why is rate limiting important in public APIs?

How do you achieve global rate limiting in distributed systems?

⚡ Messaging, Queues, and Eventing (Q46–Q65)
What is the difference between a message queue and a pub/sub system?

When would you use Kafka vs SQS?

What is message ordering and why is it difficult?

What is at-least-once vs exactly-once delivery?

How does Kafka ensure durability?

What is Kafka’s partitioning strategy?

What happens when a Kafka consumer dies?

How would you design a retry queue?

What is dead letter queue?

How do you ensure message idempotency?

How to design an event-driven architecture?

Difference between commands and events.

What is event sourcing?

How do you handle duplicate events?

What is a log compaction in Kafka?

What is schema registry?

How does Kafka handle backpressure?

Compare RabbitMQ vs Kafka.

What is a watermark in stream processing?

How would you implement real-time analytics using Kafka?

🛡 Fault Tolerance, Caching, Storage (Q66–Q85)
How do you design for high availability?

What’s the difference between RPO and RTO?

How does replication increase fault tolerance?

What’s the tradeoff of synchronous vs asynchronous replication?

What’s cache invalidation and how do you do it right?

How do you cache data that’s frequently updated?

What is write-through vs write-behind caching?

What are cache eviction policies? (LRU, LFU, etc.)

What are consistency models in caching?

How does CDN caching differ from server-side caching?

How would you handle stale data in cache?

When do you use a distributed lock?

How do you implement a distributed lock?

Why are sticky sessions bad in load balancing?

How does a reverse proxy help with fault tolerance?

What’s the difference between Redis and Memcached?

How to choose between SQL and NoSQL in distributed systems?

When would you use DynamoDB over RDS?

What is quorum-based replication?

What is a tombstone in distributed storage?

🏗 System Design Scenarios (Q86–Q100)
Design a URL shortener (focus on scalability & hashing).

Design a distributed rate limiter.

Design an email queue and delivery system.

Design an API gateway with logging and throttling.

Design a metrics collection system.

Design a distributed logging pipeline.

Design a real-time chat system.

Design a leaderboard with frequent updates.

Design a video streaming service.

Design a distributed file system.

Design a real-time stock ticker.

Design a messaging app like WhatsApp.

Design a newsfeed service (event-driven).

Design a globally available key-value store.

Design an order processing system with Kafka and Sagas.

💡 Architecture Example – Async Order Processor
css
Copy
Edit
Client → API Gateway → Order Service
↓
Kafka
↙ ↘
Payment Service Inventory Service
↓ ↓
Kafka (Order Completed) → Notification Service
