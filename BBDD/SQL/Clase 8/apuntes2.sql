-- Apuntes clase 8

-- Fechas y cadenas con comillas simples

-- Ejercicio1
select employee_id, last_name, job_id, hire_date as STARTDATE
from employees;

-- Ejercicio2
select distinct job_id
from employees;

-- Ejercicio3
select employee_id as "EMP#", last_name as "Employee", job_id as "Job", hire_date as "Hire Date"
from employees;

-- Ejercicio4
select last_name || ', ' || job_id as "Employee and Title"
from employees;

-- Ejercicio5


-- Limitando filas usando WHERE
select * 
from employees
where department_id = 9;

select * 
from employees
where last_name = 'Whalen';

select * 
from employees
where hire_date = '1994-06-07';

select last_name, salary
from employees
where salary BETWEEN 2500 and 3500;

select last_name, department_id
from employees
where department_id in (1, 5, 10);

select first_name, last_name, department_id, salary 
from employees
where first_name like 'sh%';

select first_name, last_name, department_id, salary 
from employees
where first_name like '_a%'; -- Reemplazo el primer caracter no importa cual sea, busca los que tengan una o en su segundo caracter

select last_name, salary, comission_pct
from employees
where comission_pct is not null; -- Empleados en donde su porcentaje de comisión no sea null

select last_name, salary, comission_pct
from employees
where comission_pct is null; -- Empleados en donde su porcentaje de comisión  sea null

-- Operadores logicos AND, OR, NOT 


-- Ejercicios Parte 2
-- Ejercicio 1
select last_name, salary
from employees
where salary > 12000;

-- Ejercicio 2
select last_name, department_id
from employees
where employee_id  = 176;

-- Ejercicio 3
SELECT last_name, salary
from employees
where salary not between 5000 and 12000

-- Ejercicio 4
select last_name, employee_id, hire_date
from employees
where last_name = 'Matos'
or last_name = 'Taylor'
order by hire_date asc;

select last_name, department_id
from employees
where department_id = 2
or department_id = 5
order by first_name ASC;

select last_name, department_id
from employees
where department_id in(2, 5) -- department_id se encuentre en el conjunto de los dos valores
order by first_name ASC;

-- Ejercicios avanzados
select last_name
from employees
where first_name like '___a';

select last_name
from employees
where last_name like '%a%'
and last_name like '%e%';


-- Hora y fecha
select date('now');

-- ultimo dia del mes
select date('now', 'start of month', '+1 month', '-1 day');

-- Ejercicios 1 parte 3
select employee_id, last_name, salary, round(salary * 1.155, 0) as "New Salary"
from employees;

select employee_id, last_name, salary, round(salary * 1.155, 0) as "New Salary",
round(salary * 1.155, 0) - salary as "Increase"
from employees;

-- Forma 1
select last_name, substr(last_name,1,1) || LOWER(substr(last_name, 2)) as Apellido, LENGTH (last_name) as Longitud
from employees
where first_name like 'J%'
or first_name like 'A%'
or first_name like 'M%'
order by last_name;

-- Forma 2
select last_name, substr(last_name,1,1) || LOWER(substr(last_name, 2)) as Apellido, LENGTH (last_name) as Longitud
from employees
where substr(first_name,1,1) in ('J','A','M')
order by 1; -- Columna 1

--Ejercicio 5
select last_name, salary, last_name || ' gana ' || CEIL(salary) || ' mensualmente ' || ', pero quiere ' || CEIL(3*salary) || '.'
as "Dream Salaries"
from employees;

select * from employees;

--update employees set last_name = upper(last_name), first_name = UPPER(first_name); 
update employees set last_name = lower(last_name), first_name = lower(first_name); 
update employees set last_name = substr(upper(last_name),1,1), first_name = substr(upper(first_name),1,1); 