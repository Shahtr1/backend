-- window function
DELETE from users where id not in (select MIN(id) from users group by email);

-- This query may fail in some databases like MySQL with:

-- “You can't modify a table and select from the same table in a subquery”

-- so use CTE below

-- CTE
with duplicates as(
    select id, ROW_NUMBER() OVER(PARTITION BY email order by id) as rown_num from users
)
DELETE from users
where id in (select id from duplicates where rown_num > 1);