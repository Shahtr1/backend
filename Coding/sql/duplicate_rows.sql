select email, COUNT(*) from users group by email having COUNT(*) > 1;


-- full rows
select * from users where email in 
    (select email from users group by email having COUNT(*) > 1);

