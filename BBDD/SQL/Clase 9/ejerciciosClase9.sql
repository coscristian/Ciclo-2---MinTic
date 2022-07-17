-- Ejercicios básicos
-- Ejercicio 1
select CEIL(max(salary)) as Maximum, CEIL(min(salary)) as Minimum, CEIL(sum(salary)) as Sum, CEIL(avg(salary)) as Average
from employees;

-- Ejercicio 2
select job_id, CEIL(max(salary)) as Maximum, CEIL(min(salary)) as Minimum, CEIL(sum(salary)) as Sum, CEIL(avg(salary)) as Average
from employees
group by job_id;

-- Ejercicio 3
select job_id, count(*) as "People"
from employees
group by job_id;

-- Ejercicio 4
select count(distinct manager_id) as "Number of managers"
from employees;

-- Ejercicio 5
select max(salary) - min(salary) as DIFFERENCE
from employees;

-- Ejercicios avanzados
-- Ejercicio 6
select manager_id, min(salary)
from employees
where manager_id is not null
group by manager_id
having min(salary) > 6000
order by 2 desc;

-- Ejercicio 7
select count(hire_date) as "1995", count(hire_date) as "1996", count(hire_date) as "1997",
count(hire_date) as "1998"
from employees
where substr(hire_date, 1, 4) = '1995'
or substr(hire_date, 1, 4) = '1996'
or substr(hire_date, 1, 4) = '1997' 
or substr(hire_date, 1, 4) = '1998';

-- Ejercicio 7
select 
	count(hire_date) as "TOTAL",
	sum( case when substr(hire_date, 1, 4) is '1995' then 1 else 0 end) as "1995",
	sum( case when substr(hire_date, 1, 4) is '1996' then 1 else 0 end) as "1996",
	sum( case when substr(hire_date, 1, 4) is '1997' then 1 else 0 end) as "1997", 
	sum( case when substr(hire_date, 1, 4) is '1998' then 1 else 0 end) as "1998"
from employees;

select 
	job_id, 
	job_name,
	sum( case when department_id is '2' then salary else 0 end) as "Dept 2",
	sum( case when department_id is '5' then salary else 0 end) as "Dept 5",
	sum( case when department_id is '8' then salary else 0 end) as "Dept 8",
	sum( case when department_id is '9' then salary else 0 end) as "Dept 9",
	sum(salary) as "Total"
from employees
group by job_id, job_name ;

select *
from employees;









