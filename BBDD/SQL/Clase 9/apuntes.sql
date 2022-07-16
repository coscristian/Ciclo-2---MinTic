-- Funciones multifila

select min(hire_date), max(hire_date)
from employees;

-- Dice la cantidad de empleados del id de departamente 5
select count(*)
from employees
where department_id = 5;

-- Dice la cantidad de empleados del departamento 8 que tienen comisión
select count(comission_pct)
from employees
where department_id = 8;

-- Cantidad de departamentos diferentes
select count(distinct department_id)
from employees;

-- Cantidad de empleados del dep 1
select count(*)
from employees
where department_id = 1;

-- Promedio del salario de los empleados por departamento 
select department_id, avg(salary)
from employees
group by department_id;

-- Suma de salario de cada departamento con su respectivo trabajo
select department_id, job_id, count(*) as cantidadPersonas, sum(salary)
from employees
group by department_id, job_id;

-- Cantidad de apellidos por departamento
select department_id, COUNT(last_name) 
from employees
group by department_id;

-- Promedio de salario por departamento mayor a 8000
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) > 8000;

-- Maximo salario mayor a 10000 por departamento
select department_id, max(salary)
from employees
group by department_id 
having max(salary) > 10000;

-- Trabajos que tengan un salario total(suma de salario de cada empleado) mayor a 13000 que no sean stock clerk ni salesManager
select job_id, job_name, sum(salary)
from employees
where job_name <> 'stock clerk'
and job_name not like '%salesManager%'
group by job_id, job_name 
having sum(salary) > 13000
order by job_id;

select *
from employees;