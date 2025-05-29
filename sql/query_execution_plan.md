## What is a Query Execution Plan?

A query execution plan (aka EXPLAIN plan) shows how the database will execute your SQL query — step by step.

What It Shows:

- Which indexes will (or won’t) be used
- Whether it will do a **full table scan**
- The join strategy (nested loop, hash join, etc.)
- The order of operations (which table first, then second, etc.)
- Estimated cost or rows processed

```sql
EXPLAIN SELECT * FROM Employees WHERE salary > 5000;
```

| id  | select_type | table     | type  | key     | rows | Extra       |
| --- | ----------- | --------- | ----- | ------- | ---- | ----------- |
| 1   | SIMPLE      | Employees | range | idx_sal | 500  | Using where |

- It will use the `idx_sal` index.
- It expects to scan 500 rows.
- Type `range` means index range scan — faster than full scan.

Why It’s Useful:

- Helps you debug slow queries
- Tells you if indexes are being used or ignored
- Guides you to add or optimize indexes, rewrite joins, etc.
