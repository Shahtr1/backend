select distinct salary from employee order by salary desc limit 1 offset 1;

select MAX(salary) from employee where salary < (select MAX(salary) from employee);

select salary from (
    select salary, RANK() OVER(ORDER BY salary desc) as rank from employees
    ) ranked_salaries where rank = 2; 