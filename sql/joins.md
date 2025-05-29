`Employees`

| emp_id | name    | dept_id |
| ------ | ------- | ------- |
| 1      | Alice   | 10      |
| 2      | Bob     | 20      |
| 3      | Charlie | NULL    |
| 4      | David   | 30      |

`Departments`

| dept_id | dept_name   |
| ------- | ----------- |
| 10      | HR          |
| 20      | Engineering |
| 40      | Marketing   |

## INNER JOIN

Returns only the rows that have matching values in both tables.

```sql
select e.name, d.dept_name from employees e inner join departments d on d.dept_id=e.dept_id
```

**Result**:

| name  | dept_name   |
| ----- | ----------- |
| Alice | HR          |
| Bob   | Engineering |

## LEFT JOIN (or LEFT OUTER JOIN)

Returns all rows from the left table (Employees), even if there's no match in the right table (Departments).

```sql
select e.name, d.dept_name from employees e left join departments d on d.dept_id=e.dept_id
```

**Result**:

| name    | dept_name   |
| ------- | ----------- |
| Alice   | HR          |
| Bob     | Engineering |
| Charlie | NULL        |
| David   | NULL        |

## RIGHT JOIN (or RIGHT OUTER JOIN)

Returns all rows from the right table (Departments), even if there's no match in the left table (Employees).

```sql
select e.name, d.dept_name from employees e right join departments d on d.dept_id=e.dept_id
```

**Result**:

| name  | dept_name   |
| ----- | ----------- |
| Alice | HR          |
| Bob   | Engineering |
| Null  | Marketing   |
