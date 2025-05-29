```sql
SELECT * FROM employees;
SELECT name, salary FROM employees;
SELECT * FROM employees WHERE department = 'HR';


INSERT INTO employees (name, department, salary)
VALUES ('Alice', 'Engineering', 8000);

UPDATE employees
SET salary = 9000
WHERE name = 'Alice';

DELETE FROM employees
WHERE name = 'Alice';

-- Drop (Delete) a Column
ALTER TABLE employees
DROP COLUMN hire_date;

-- MySQL - Rename a Column
ALTER TABLE employees
CHANGE COLUMN old_name new_name VARCHAR(100);

-- PostgreSQL - Rename a Column
ALTER TABLE employees
RENAME COLUMN old_name TO new_name;


-- Change Data Type of a Column
ALTER TABLE employees
MODIFY salary FLOAT;

-- Rename a Table
RENAME TABLE employees TO staff;

-- Delete a Table
DROP TABLE employees;

-- Add Primary key
ALTER TABLE employees
ADD PRIMARY KEY (id);

-- Add Unique Constraint
ALTER TABLE employees
ADD CONSTRAINT unique_name UNIQUE (name);

DESCRIBE employees; -- MYSQL

-- Auto-Increment
CREATE TABLE employees (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  salary DECIMAL(10, 2)
);

```

- What's the difference between `PRIMARY KEY` and `UNIQUE` constraints?

Both enforce uniqueness, but a `PRIMARY KEY` cannot be `NULL`, while `UNIQUE` can allow `NULLs` (but only one in most DBs). Also, each table can have only one `PRIMARY KEY`, but multiple `UNIQUE` constraints.

- What happens if you `DROP` a table that is referenced by a foreign key in another table?

It will throw an error unless you first drop the foreign key constraint, or use ON `DELETE CASCADE` depending on DBMS.

- Give an example of a race condition in SQL and how you'd prevent it.
  Two transactions trying to deduct from the same bank balance. Prevent using `SERIALIZABLE` isolation level or explicit `LOCK`.
