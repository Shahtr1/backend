| emp_id | name    | department | salary |
| ------ | ------- | ---------- | ------ |
| 1      | Alice   | HR         | 5000   |
| 2      | Bob     | HR         | 6000   |
| 3      | Charlie | Sales      | 5500   |
| 4      | David   | Sales      | 7000   |
| 5      | Eva     | Sales      | 5000   |

`GROUP BY`:

Used to aggregate rows into groups.

The result set returns one row per group.

```sql
SELECT department, COUNT(*) AS emp_count
FROM Employees
GROUP BY department;
```

Result:

| department | emp_count |
| ---------- | --------- |
| HR         | 2         |
| Sales      | 3         |

`PARTITION BY`:

Used with window functions (like `RANK()`, `SUM()`, etc.).

It does not collapse rows — instead, it creates "**groups within rows**" for function calculations.

### Question: Rank employees within their department by salary (highest first)

```sql
    select name, department, salary, RANK() OVER(PARTITION BY department order by salary desc) dept_rank from employees
```

| name    | department | salary | dept_rank |
| ------- | ---------- | ------ | --------- |
| Bob     | HR         | 6000   | 1         |
| Alice   | HR         | 5000   | 2         |
| David   | Sales      | 7000   | 1         |
| Charlie | Sales      | 5500   | 2         |
| Eva     | Sales      | 5000   | 3         |
