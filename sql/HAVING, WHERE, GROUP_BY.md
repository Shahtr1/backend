`HAVING` vs `WHERE` in SQL

Both are used to filter rows, but they are used at different stages in a query.

`WHERE`:

- Filters rows before grouping.
- Used with raw columns.

`HAVING`:

- Filters groups after the `GROUP BY` is applied.
- Used with aggregate functions (like `COUNT`, `SUM`, `AVG`).

`Sales`

| id  | region | amount |
| --- | ------ | ------ |
| 1   | East   | 100    |
| 2   | East   | 200    |
| 3   | West   | 150    |
| 4   | West   | 300    |
| 5   | South  | 50     |

❌ Wrong (using `WHERE` with aggregation — this won't work):

```sql
SELECT region, SUM(amount)
FROM Sales
WHERE SUM(amount) > 200  -- ❌ ERROR
GROUP BY region;
```

✅ Correct (using `HAVING`):

```sql
SELECT region, SUM(amount) AS total
FROM Sales
GROUP BY region
HAVING SUM(amount) > 200;
```

`Result`:

| region | total |
| ------ | ----- |
| East   | 300   |
| West   | 450   |

- Use `WHERE` to filter before grouping.
- Use `HAVING` to filter after grouping with aggregates.
