A correlated subquery is a subquery that uses values from the outer query.
It runs once for each row in the outer query.

Table: `Employee`

| id  | name    | salary | dept_id |
| --- | ------- | ------ | ------- |
| 1   | Alice   | 5000   | 10      |
| 2   | Bob     | 6000   | 10      |
| 3   | Charlie | 7000   | 20      |
| 4   | David   | 4000   | 20      |

Goal: Find employees who earn more than the average salary in their department.

```sql
select e1.name, e1.salary from employee e1 where e1.salary >
    (select AVG(e2.salary) from employee e2 where e1.dept_id = e2.dept_id )
```
