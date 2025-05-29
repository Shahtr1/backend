Imagine a classroom of students and you want to rank them by their marks:

| Name  | Marks |
| ----- | ----- |
| Alice | 95    |
| Bob   | 90    |
| Carol | 90    |
| David | 85    |

You want to assign ranks based on marks.

```sql
SELECT
  name,
  salary,
  RANK() OVER (ORDER BY salary DESC) AS rank_value,
  DENSE_RANK() OVER (ORDER BY salary DESC) AS dense_rank_value,
  ROW_NUMBER() OVER (ORDER BY salary DESC) AS row_number_value
FROM salaries;
```

What happens?

- SQL looks at all rows in the table.
- It orders them by `Marks DESC` (highest first).
- It starts assigning ranks from top to bottom.

| Name  | Marks | RANK |                            |
| ----- | ----- | ---- | -------------------------- |
| Alice | 95    | 1    |                            |
| Bob   | 90    | 2    |                            |
| Carol | 90    | 2    | ← same marks, same rank    |
| David | 85    | 4    | ← skips 3 (because of tie) |

## So What Does OVER Do?

The `OVER(...)` part is like saying:

- **_"Hey SQL, apply this function (`RANK`) over a set of rows — and here’s how you should look at them."_**

You can tell it:

- **_“Look at all rows, ordered by marks.”_** → `OVER (ORDER BY Marks DESC)`

- **_“Look at only rows in the same class.”_** → `OVER (PARTITION BY Class)`

Think of `OVER` as choosing which rows to compare with.

## A Real-World Analogy

Let’s say you're in a coding competition.

Everyone submits their solution, and now the organizer wants to rank people:

- You could rank globally → compare all users → `OVER (ORDER BY score DESC)`
- Or rank per region → compare only people from your region → `OVER (PARTITION BY region ORDER BY score DESC)`

The `OVER` clause tells SQL who to compare each row against when applying a function like `RANK`, `AVG`, or `ROW_NUMBER`.

## `RANK()`, `DENSE_RANK()` and `ROW_NUMBER()`

```sql
SELECT
  name,
  salary,
  RANK() OVER (ORDER BY salary DESC) AS rank_value,
  DENSE_RANK() OVER (ORDER BY salary DESC) AS dense_rank_value,
  ROW_NUMBER() OVER (ORDER BY salary DESC) AS row_number_value
FROM salaries;
```

Let’s now explore what each one does — and the key difference in how they treat ties (duplicate salary values).

1. `RANK()` — Skips Ranks on Ties

This function assigns the same rank to tied rows, but skips the next rank(s).

Think of it like Olympic medals:

- If two people tie for 2nd place, the next person is ranked 4th (no 3rd place).

| name    | salary | RANK() |           |
| ------- | ------ | ------ | --------- |
| Alice   | 10000  | 1      |           |
| Bob     | 9000   | 2      |           |
| Charlie | 9000   | 2      |           |
| David   | 8000   | 4      | ← Skips 3 |
| Eve     | 7000   | 5      |           |

2. `DENSE_RANK()` — No Gaps in Ranks
   Like `RANK()`, but doesn't skip any rank numbers, even with ties.

Think of classroom positions:

- Two students tie for 2nd, next student is 3rd (not 4th).

| name    | salary | DENSE_RANK() |           |
| ------- | ------ | ------------ | --------- |
| Alice   | 10000  | 1            |           |
| Bob     | 9000   | 2            |           |
| Charlie | 9000   | 2            |           |
| David   | 8000   | 3            | ← No gap! |
| Eve     | 7000   | 4            |           |

3. `ROW_NUMBER()` — Unique Row Numbers, No Ties

This function simply numbers each row uniquely in the order specified — even if salaries are the same.

- Think of it like row indexes — always sequential.

| name    | salary | ROW_NUMBER() |                              |
| ------- | ------ | ------------ | ---------------------------- |
| Alice   | 10000  | 1            |                              |
| Bob     | 9000   | 2            |                              |
| Charlie | 9000   | 3            | ← Even though salary is tied |
| David   | 8000   | 4            |                              |
| Eve     | 7000   | 5            |                              |
