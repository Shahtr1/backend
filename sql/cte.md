A CTE is a temporary result set defined with a WITH clause that you can reference just like a table in the main query.

Think of it like giving a name to a subquery to make your SQL cleaner and easier to read — especially for complex joins, aggregations, or recursive queries.

Syntax:

```sql
WITH cte_name AS (
  SELECT ...
  FROM ...
  WHERE ...
)
SELECT *
FROM cte_name
WHERE ...;
```

- `WITH` = **_"let's name this subquery"_**

Example 1: Filter top salaries using a CTE

```sql
WITH HighEarners AS (
  SELECT name, salary
  FROM Employees
  WHERE salary > 5000
)
SELECT *
FROM HighEarners;
```

✅ Example 2: CTE for Aggregation (average salary)

```sql
WITH AvgSalary AS (
  SELECT AVG(salary) AS avg_sal FROM Employees
)
SELECT name, salary
FROM Employees, AvgSalary
WHERE Employees.salary > AvgSalary.avg_sal;
```

Example 3: CTE with JOIN

```sql
WITH BigOrders AS (
  SELECT order_id, customer_id, amount
  FROM Orders
  WHERE amount > 1000
)
SELECT o.order_id, o.amount, c.name
FROM BigOrders o
JOIN Customers c ON o.customer_id = c.customer_id;
```

Example 4:

| id  | region | amount |
| --- | ------ | ------ |
| 1   | East   | 100    |
| 2   | West   | 200    |
| 3   | East   | 300    |
| 4   | West   | 400    |

Without CTE (ugly and repetitive):

```sql
SELECT region, SUM(amount)
FROM (
  SELECT * FROM Sales WHERE amount > 100
) AS temp
GROUP BY region;

```

With CTE (clean and readable):

```sql
WITH FilteredSales AS (
  SELECT * FROM Sales WHERE amount > 100
)
SELECT region, SUM(amount)
FROM FilteredSales
GROUP BY region;
```

## What is a Recursive CTE?

A **recursive CTE** is used when you're working with hierarchical or self-referencing data — like:

- An org chart (manager → employee)
- A file system (folder → subfolder)
- Category trees (parent → child)

It repeats itself to walk through levels of data.

`Employees`

| emp_id | name    | manager_id |
| ------ | ------- | ---------- |
| 1      | Alice   | NULL       |
| 2      | Bob     | 1          |
| 3      | Charlie | 1          |
| 4      | David   | 2          |
| 5      | Eva     | 2          |
| 6      | Frank   | 4          |

This means:

- Alice is the CEO (no manager)
- Bob and Charlie report to Alice
- David and Eva report to Bob
- Frank reports to David

Goal:
Find all subordinates under Alice, even indirectly.

```sql
WITH RECURSIVE OrgChart AS (
  -- Step 1: Anchor Query (Start with the boss)
  SELECT emp_id, name, manager_id
  FROM Employees
  WHERE manager_id IS NULL  -- Alice

  UNION ALL

  -- Step 2: Recursive Part (Find employees who report to the previous level)
  SELECT e.emp_id, e.name, e.manager_id
  FROM Employees e
  JOIN OrgChart o ON e.manager_id = o.emp_id
)
SELECT * FROM OrgChart;
```

What Happens:
🔹 First Iteration (Anchor):
Finds Alice (manager_id = NULL)

🔹 Second Iteration:
Finds employees where manager_id = Alice's emp_id (1) → Bob, Charlie

🔹 Third Iteration:
Finds employees where manager_id = Bob's emp_id (2) → David, Eva

🔹 Fourth Iteration:
Finds employees where manager_id = David's emp_id (4) → Frank

→ And so on, until there are no more matches.
