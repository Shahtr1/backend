## Databases

Crucial for Designing Backend Systems at Amazon

❓ 100 Database Interview Questions
📘 SQL Basics & Queries (Q1–Q25)
Difference between INNER JOIN, LEFT JOIN, RIGHT JOIN.

Write a query to find second highest salary.

How does indexing work in SQL?

When do you use a HAVING clause?

Difference between WHERE and HAVING.

What is a correlated subquery?

Write a query to find duplicate rows.

How to find employees with more than 2 direct reports?

Use window functions: RANK(), ROW_NUMBER(), DENSE_RANK().

What is a common table expression (CTE)?

Difference between GROUP BY and PARTITION BY.

Write a query to pivot table data.

What is the difference between UNION and UNION ALL?

Optimize a query with LIKE '%abc%'.

Explain query execution plan (EXPLAIN).

Write a recursive SQL query.

Write SQL to delete duplicates from a table.

Use CASE WHEN in a SELECT.

What is NULL-safe comparison?

How to write UPSERT in SQL?

What are aggregate functions?

How does IN vs EXISTS differ in performance?

What is an anti-join?

What is the default isolation level in SQL?

Write a query to get department-wise top 3 salaries.

📊 Schema Design & Normalization (Q26–Q40)
What is 1NF, 2NF, 3NF?

What is denormalization? When is it useful?

Design schema for a library system.

Design schema for an e-commerce cart.

What is a surrogate key vs natural key?

What are foreign keys and constraints?

How would you store hierarchical data?

What are pros/cons of composite keys?

When would you use indexing?

Difference between clustered and non-clustered index.

What’s a covering index?

What is a materialized view?

How do foreign keys impact performance?

What is a star schema vs snowflake schema?

What’s the cost of over-normalization?

🔧 Transactions & Locking (Q41–Q55)
What is a transaction?

What are ACID properties?

What is the difference between COMMIT and ROLLBACK?

What is the isolation level in databases?

What is a dirty read?

What is a phantom read?

How do shared and exclusive locks work?

What causes deadlocks in DB transactions?

What is optimistic vs pessimistic locking?

How to ensure transaction idempotency?

What’s the role of WAL (Write Ahead Log)?

What is MVCC (Multiversion Concurrency Control)?

When would you use SERIALIZABLE isolation?

How do databases handle rollbacks internally?

How are savepoints used in transactions?

🧠 Stored Procedures & Performance (Q56–Q70)
Write a stored procedure to compute factorial.

How do you loop in a stored procedure?

What’s the difference between procedure and function?

Use IF/ELSE inside a stored procedure.

How to call a procedure from Java?

What’s the performance cost of a stored proc vs raw query?

When would you use triggers?

How do you debug stored procedures?

What is a cursor and when should you avoid it?

Write a procedure to validate email format.

How to return multiple result sets?

Use OUT parameters in stored procedures.

Stored procedure vs prepared statement?

Best practices for writing stored procedures.

How to prevent SQL injection?

🌩️ NoSQL & DynamoDB (Q71–Q85)
What is NoSQL and when to use it?

Compare document vs key-value vs column-family DBs.

How does DynamoDB achieve high availability?

What is eventual consistency in DynamoDB?

How is data partitioned in DynamoDB?

What is a hot partition?

How does DynamoDB handle secondary indexes?

What is a Global Secondary Index (GSI)?

When should you denormalize in NoSQL?

What is TTL in DynamoDB?

Explain partition key vs sort key.

What is DynamoDB Streams?

Use case for DynamoDB + Lambda?

How to batch write in DynamoDB?

How to optimize for read/write units?

⚙️ Real-World Design Scenarios (Q86–Q100)
Design a database for ride-sharing app (Uber).

Design schema for Amazon product catalog.

Design schema for user roles and permissions.

Design data store for real-time chat app.

Design a scalable logging schema.

Store versioned documents (e.g., Google Docs).

How to archive old data efficiently?

How to shard MySQL database?

How to do blue/green DB deployments?

How do you implement audit logs?

How to store multi-language content?

How to scale reads without affecting writes?

Design an analytics-friendly data warehouse.

Best practices for schema evolution.

How to migrate relational DB to NoSQL?

💡 SQL Example – Top N per Group
sql
Copy
Edit
SELECT name, department, salary
FROM (
SELECT name, department, salary,
ROW_NUMBER() OVER (PARTITION BY department ORDER BY salary DESC) AS rn
FROM employees
) AS ranked
WHERE rn <= 3;
