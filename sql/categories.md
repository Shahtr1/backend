SQL is divided into several major categories based on what kind of operation you're doing:

1. DDL – Data Definition Language

DDL commands define or change the structure of your database: tables, columns, indexes, etc.

| Command    | What It Does                                             |
| ---------- | -------------------------------------------------------- |
| `CREATE`   | Creates tables, databases, indexes                       |
| `ALTER`    | Modifies existing tables (add columns, rename, etc.)     |
| `DROP`     | Deletes tables, databases, or columns                    |
| `RENAME`   | Changes the name of a table or column                    |
| `TRUNCATE` | Deletes **all rows** from a table (faster than `DELETE`) |

2. DML – Data Manipulation Language

DML is for modifying the data inside tables, not the table structure.

| Command  | What It Does          |
| -------- | --------------------- |
| `SELECT` | Fetches data          |
| `INSERT` | Adds new rows         |
| `UPDATE` | Changes existing rows |
| `DELETE` | Deletes specific rows |

3. DCL – Data Control Language

DCL is for access control and permissions.

| Command  | What It Does                        |
| -------- | ----------------------------------- |
| `GRANT`  | Gives permissions (e.g., to a user) |
| `REVOKE` | Removes permissions                 |

```sql
GRANT SELECT, INSERT ON users TO analyst_user;
```

4. TCL – Transaction Control Language

TCL manages transactions — groups of operations that should be treated as one atomic unit.

| Command                        | What It Does                         |
| ------------------------------ | ------------------------------------ |
| `BEGIN` or `START TRANSACTION` | Starts a transaction                 |
| `COMMIT`                       | Saves changes                        |
| `ROLLBACK`                     | Undoes changes if something fails    |
| `SAVEPOINT`                    | Creates checkpoints in a transaction |

```sql
START TRANSACTION;

UPDATE accounts SET balance = balance - 100 WHERE id = 1;
UPDATE accounts SET balance = balance + 100 WHERE id = 2;

COMMIT; -- apply both or none
```

- What’s the difference between `DROP TABLE` and `TRUNCATE TABLE`?

`DROP` deletes the table structure and all data. `TRUNCATE` deletes all rows but keeps the table structure.

- What is the difference between DELETE and TRUNCATE?

`DELETE` can remove specific rows and supports WHERE, but `TRUNCATE` deletes all rows quickly and can't be rolled back in some databases.
