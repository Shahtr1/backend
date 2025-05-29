`UNION` vs `UNION ALL`

Both are used to combine results from two or more `SELECT` queries.

`UNION`

- Removes duplicates from the final result.
- Does an implicit `DISTINCT`.
- Slower because it has to compare rows for duplicates.

```sql
SELECT name FROM Customers
UNION
SELECT name FROM Employees;
```

`UNION ALL`

- Keeps all rows, including duplicates.
- Faster — no extra work to eliminate duplicates.

```sql
SELECT name FROM Customers
UNION ALL
SELECT name FROM Employees;
```

If "Alice" appears in both tables, it shows twice.
