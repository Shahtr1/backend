-- Write a SQL query using RANK(), ROW_NUMBER(), and DENSE_RANK() to show how they behave differently.
-- | id | name    | salary |
-- | -- | ------- | ------ |
-- | 1  | Alice   | 5000   |
-- | 2  | Bob     | 6000   |
-- | 3  | Charlie | 6000   |
-- | 4  | David   | 4000   |

-- Rank employees by salary (highest first)
SELECT
  name,
  salary,
  RANK() OVER (ORDER BY salary DESC) AS rank_value,
  DENSE_RANK() OVER (ORDER BY salary DESC) AS dense_rank_value,
  ROW_NUMBER() OVER (ORDER BY salary DESC) AS row_number_value
FROM salaries;

-- | name    | salary | RANK | DENSE_RANK  | ROW_NUMBER  |
-- | ------- | ------ | ---- | ----------- | ----------- |
-- | Bob     | 6000   | 1    | 1           | 1           |
-- | Charlie | 6000   | 1    | 1           | 2           |
-- | Alice   | 5000   | 3    | 2           | 3           |
-- | David   | 4000   | 4    | 3           | 4           |
