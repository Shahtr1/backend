## Problem with `LIKE '%abc%'`

When you use:

```sql
WHERE column LIKE '%abc%'
```

This is called a **leading wildcard search**, and it’s slow because:

- SQL can’t use **indexes** effectively — it has to scan every row.
- It behaves like a **full table scan**.

Optimization Techniques:

1. Avoid leading wildcard

If possible, change to:

```sql
WHERE column LIKE 'abc%'
```

This allows SQL to use indexes if one exists on column.

2. Use **Full-Text Search (FTS)**

MySQL:

```sql
SELECT * FROM table
WHERE MATCH(column) AGAINST('abc' IN NATURAL LANGUAGE MODE);
```

Table: `Products`

| product_id | name              |
| ---------- | ----------------- |
| 1          | Wireless Mouse    |
| 2          | Wired Keyboard    |
| 3          | Bluetooth Speaker |
| 4          | Wireless Charger  |
| 5          | USB-C Cable       |

Write a SQL query to find all products whose names contain the word '**wireless**' (case-insensitive).

Then, suggest one way to make this query faster if this table grows to millions of rows.

```sql
SELECT product_id
FROM Products
WHERE LOWER(name) LIKE '%wireless%';
```

Full-Text Index (MySQL):

- Creates a search-optimized index file behind the scenes.

```sql
ALTER TABLE Products ADD FULLTEXT(name);
SELECT product_id
FROM Products
WHERE MATCH(name) AGAINST('wireless');
```
