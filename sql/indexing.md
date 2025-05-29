An index in SQL is like the index in a book — it helps you find data faster without scanning the whole table.

## How It Works:

An index is created on one or more columns in a table. Internally, it's often implemented as a **B-Tree** or **Hash Table** structure.

When you run a query like this:

```sql
SELECT * FROM Employee WHERE emp_id = 123;
```

Without an index: SQL must scan every row (a full table scan).
With an index on `emp_id`: SQL jumps directly to the row, similar to how you’d use a book index to jump to a page.

## Benefits:

- Faster **SELECTs** with WHERE, JOIN, ORDER BY, and GROUP BY.
- Great for columns that are frequently queried or sorted.

## Drawbacks:

- Slower **INSERTs**/**UPDATEs**/**DELETEs** because the index also needs to be updated.
- Takes extra disk space.

```sql
CREATE INDEX idx_emp_name ON Employee(name);
```
