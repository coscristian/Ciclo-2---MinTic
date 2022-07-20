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
	sum( case when department_id is '2' then salary else 0 end) as "Dept 2",
	sum( case when department_id is '5' then salary else 0 end) as "Dept 5",
	sum( case when department_id is '8' then salary else 0 end) as "Dept 8",
	sum( case when department_id is '9' then salary else 0 end) as "Dept 9",
	sum(salary) as "Total"
from employees
group by job_id;

select job_id
from employees
where department_id = 5;

--- Apuntes clase 10----- NATURAL JOIN

-- Verifica que los campos sean iguales y los compara
select e.last_name, e.salary, d.department_id, l.city 
from employees e
natural join departments d
natural join locations l;

-- Verifica los nombres de columnas dados y enlaza las tablas
-- USING si encuentra un campo repetido, ese se usará como enlace
select e.last_name, e.salary, d.department_id, l.city 
from employees e
join departments d using (department_id)
join locations l using (location_id);

-- Se debe decir de forma explicita el enlace especifico (Campos) con la condicion on
-- SI las columnas a enlazar no tienen el mismo nombre, usar on
select e.last_name, e.salary, d.department_id, l.city 
from employees e
join departments d on (e.department_id = d.department_id)
join locations l on (d.location_id = l.location_id);


-- INNER JOIN = JOIN ON

-- SELFT JOIN: Se hace una relación de mi conmigo (Relacion circular con la misma tabla)
-- Relacion de la tabla consigo misma
select *
from employees e 
join employees m on (e.manager_id = m.employee_id)

-- NonEQUIJOIN: Relación entre tablas cuando la relación de comparación no es igual
-- La forma de hacer el enlace no se hace con =, no es una condicion de igual
-- Sirve para rangos...
-- Es cuando no se utiliza la comparación de igual, se usa y, entre
select e.last_name, e.salary, jg.grade
from employees e 
--join job_grades jg on (e.salary >= jg.lowest_sal and e.salary <= jg.highest_sal)
join job_grades jg on (e.salary BETWEEN jg.lowest_sal and jg.highest_sal);

-- Outer Join
-- Toma no solo los elementos que sean iguales, sino los de una u otra tabla

-- left outer join: Es mas importa la tabla de la izquierda que la de la derecha (Muestra todos los datos de la primera 
-- tabla y los de la segunda que no correspondan los muestra como null)

select e.last_name as employee, m.manager_id as manager 
from employees e 
left outer join employees m on (e.manager_id = m.employee_id)

-- right outer join: Es mas importa la tabla de la derecha que la de la izquierda (Muestra todos los datos de la segunda 
-- tabla y los de la primera que no correspondan los muestra como null)
select e.last_name as employee, m.manager_id as manager 
from employees e 
right outer join employees m on (e.manager_id = m.employee_id)


-- FUll outer join: Muestra todos los datos

-- Cross Join: Sirve para relacionar tablas cuando no hay un campo que relacione las tablas a relacionar
-- Combina todos los datos de ambas tablas totalDatos = cant_tabla1 * cant_tabla2
select grade, region_name
from job_grades jg 
cross join regions r;

-- Ejercicios Basicos
-- Ejercicio 1
select e.last_name, e.department_id, d.department_name 
from employees e
natural join departments d;

--Ejercicio
select e.last_name as Employee, e.employee_id as "Emp #", m.last_name  as Manager, m.employee_id as "Manager #"
from employees e
left outer join employees m on (e.manager_id = m.employee_id)
order by e.employee_id;

-- Ejercicio
-- Selft join combinado con NonEquijoin
select e.first_name, e.hire_date 
from employees e
join employees adam on (adam.first_name = 'Adam' and e.hire_date > adam.hire_date);

select e.first_name, e.hire_date 
from employees e
cross join employees adam on (adam.first_name = 'Adam') 
where e.hire_date > adam.hire_date;

----------------------------------------------------------
-- Subconsultas

select salary
from employees
where first_name = 'Adam';

select first_name, salary
from employees
where salary > (
	select salary 
	from employees
	where first_name = 'Adam'
);

-- Ejercicio complicadito versión subconsultas
select e.first_name, e.hire_date
from employees e 
where e.hire_date > (
	select hire_date 
	from employees
	where first_name = 'Adam'
);

-- Sub consultas multifila
-- In: Agrupar varios elementos(Para comparar una colección de datos)
-- All: Todos los datos que tengo en una lista 
-- Any: Cualquiera de los datos que tengo en una lista
-- Some: Algunos 

-- SQLite no tiene implementado All, any, some

select department_id
from departments d
where location_id = 1700;

select last_name, department_id
from employees e
where ;

-- Subconsultas como tabla

select 1
from employees e 
where salary > 10000;

select department_name 
from departments d;

-- Clausula WITH
-- Se usa para poder reutilizar un bloque SELECT 


-- Ejercicio Subconsultas
select employee_id, last_name, salary 
from employees
where salary > (
	select avg(salary)
	from employees
)
order by 3 asc;

-- Regalos Navidad
-- Union de Conjuntos
-- La cantidad de campos y los tipos de datos deben ser iguales
select employee_id, first_name, last_name, relationship 
from dependents
UNION
select employee_id, first_name, last_name, 'Worker'
from employees;

--Interseccion
select employee_id, last_name
from dependents
intersect
select employee_id, last_name 
from employees;

-- Diferencia
select employee_id, first_name, last_name, relationship 
from dependents
minus
select employee_id, first_name, last_name, 'Worker'
from employees;
-- Terminar todos los ejercicios
-- Proxima clase archivos java, conxion BBDD java usando JDBC o JPA

limit traigame todos los primeros n registros
https://chat.whatsapp.com/H8vc6EBPVBs4myyJYaHVjl
