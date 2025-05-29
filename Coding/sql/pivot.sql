-- Write a SQL query to pivot table data.

-- Assume this table of monthly sales:

-- Sales

-- | month | category | amount |
-- | ----- | -------- | ------ |
-- | Jan   | Books    | 100    |
-- | Jan   | Toys     | 150    |
-- | Feb   | Books    | 120    |
-- | Feb   | Toys     | 180    |

-- Write a query that pivots the data to show one row per month and one column per category, like this:

-- | month | Books | Toys |
-- | ----- | ----- | ---- |
-- | Jan   | 100   | 150  |
-- | Feb   | 120   | 180  |

SELECT
  month,
  SUM(CASE WHEN category = 'Books' THEN amount ELSE 0 END) AS Books,
  SUM(CASE WHEN category = 'Toys' THEN amount ELSE 0 END) AS Toys
FROM Sales
GROUP BY month
ORDER BY month;
