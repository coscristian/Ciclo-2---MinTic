select *
from employees;

-- Ejercicios básicos
-- Ejercicio 4
select employee_id, last_name, job_id, hire_date as STARTDATE 
from employees;

-- Ejercicio 5
select distinct job_id
from employees;

-- Ejercicios avanzados
-- Ejercicio 6
select employee_id as "EMP #", last_name as Employee, job_id as Job, hire_date "Hire Date"
from employees;

-- Ejercicio 7
select last_name || ', ' || job_id as "Employee and Title"
from employees;

-- Ejercicio 8
select employee_id, first_name , last_name, email, phone_number, hire_date, job_id, salary, manager_id,
department_id, comission_pct, employee_id || ', ' || first_name || ', ' || last_name || ', ' || email 
|| ', ' || COALESCE(phone_number, 0) || ', ' || hire_date || ', ' || job_id || ', ' || salary || ', ' || COALESCE(manager_id, 0) 
|| ', ' || department_id || ', ' || COALESCE(comission_pct, 0) as THE_OUTPUT
from employees;

-- Ejercicios SELECT 
-- Ejercicios básicos

-- Ejercicio 9
select last_name, salary 
from employees
where salary > 12000;

-- Ejercicio 10
select last_name, department_id 
from employees
where employee_id = 176;

-- Ejercicio 11
select last_name, salary 
from employees
where salary not between 5000
and 12000;

-- Ejercicio 12
select last_name, job_id, hire_date
from employees
where last_name in ('Matos', 'Taylor')
order by hire_date asc;

-- Ejercicio 13
select first_name, last_name, department_id 
from employees
where department_id in (2, 5)
order by first_name asc;

-- Ejercicio 14
select last_name as Employee, salary as "Monthly Salary" 
from employees
where salary between 5000 and 12000
and department_id in (2, 5);

-- Ejercicio 15
select last_name, hire_date 
from employees
where hire_date like '1994%';

-- Ejercicio 16
select last_name, job_id 
from employees
where manager_id is null;

-- Ejercicio 17
select last_name, salary, comission_pct 
from employees
where comission_pct is not null
order by 2 desc, 3;

-- Ejercicios avanzados
-- Ejercicio 18
select first_name, last_name 
from employees
where first_name like '__a%';

-- Ejercicio 19
select last_name
from employees
where last_name like '%a%'
and last_name like '%e%';

alter table employees add column job_name varchar(50);
-- Ejercicio 20
select last_name, job_name, salary, job_name
from employees
where job_name in ('salesRepresentative','stock clerk')
and salary not in ('2500','3500', '7000');

-- Ejercicio 21
select last_name, salary, comission_pct 
from employees
where comission_pct = 2;

-- Ejercicios adicionales
-- Ejercicio 1
select employee_id, last_name, salary, salary + salary * 15 /100 as "New Salary"
from employees;

-- Ejercicio 2
select employee_id, last_name, salary, salary - salary + salary * 15 /100 as "Increase", salary + salary * 15 /100 as "New Salary"
from employees;

-- Ejercicio 4
select last_name, CEIL((JULIANDAY('now') - JULIANDAY(hire_date)) * 0.032854) as MONTHS_WORKED, hire_date 
from employees
order by MONTHS_WORKED;

-- Ejercicio 5
select last_name || ' gana ' || salary || ' mensualmente, pero quiere ' || (3*salary) as "Dream Salaries"  
from employees;

-- Ejercicio 6
select last_name, hire_date,
		'Lunes ' || substr(date(hire_date, '+6 Months', 'weekday 1'), 9,10) ||
		' de ' ||
				case substr(date(hire_date, '+6 Months', 'weekday 1'), 6,2)
					when '01'
						then 'Enero'
					when '02'
						then 'Febrero'
					when '03'
						then 'Marzo'
					when '04'
						then 'Abril'
					when '05'
						then 'Mayo'
					when '06'
						then 'Junio'
					when '07'
						then 'Julio'
					when '08'
						then 'Agosto'
					when '09'
						then 'Septiembre'
					when '10'
						then 'Octubre'
					when '11'
						then 'Noviembre'
					when '12'
						then 'Diciembre'
					else 'Mes '
				end
		|| ' de ' || substr(date(hire_date, '+6 Months', 'weekday 1'), 1,4)
		as REVIEW
from employees;

-- Otra forma ejercicio 6
select last_name, hire_date,
PRINTF()
		'Lunes ' || substr(date(hire_date, '+6 Months', 'weekday 1'), 9,10) ||
		' de ' ||
				case substr(date(hire_date, '+6 Months', 'weekday 1'), 6,2)
					when '01'
						then 'Enero'
					when '02'
						then 'Febrero'
					when '03'
						then 'Marzo'
					when '04'
						then 'Abril'
					when '05'
						then 'Mayo'
					when '06'
						then 'Junio'
					when '07'
						then 'Julio'
					when '08'
						then 'Agosto'
					when '09'
						then 'Septiembre'
					when '10'
						then 'Octubre'
					when '11'
						then 'Noviembre'
					when '12'
						then 'Diciembre'
					else 'Mes '
				end
		|| ' de ' || substr(date(hire_date, '+6 Months', 'weekday 1'), 1,4)
		as REVIEW
from employees;

-- Ejercicio 7
select last_name, hire_date,
	case strftime("%w",hire_date)
		when '0' then '7'
		else strftime("%w",hire_date)
	end
from employees
order by 3;

select last_name, hire_date,
	case strftime("%w",hire_date)
		when '1' then substr('1Lunes', 1)
		when '2' then substr('2Martes', 1)
		when '3' then substr('3Miercoles', 1)
		when '4' then substr('4Jueves', 1)
		when '5' then substr('5Viernes', 1)
		when '6' then substr('6Sabado', 1)
		when '0' then substr('7Domingo', 1)
	end as "DAY"
from employees
order by 3;

-- Ejercicio 8
select last_name, case when comission_pct is null then 'Sin comisión' else comission_pct end as COMM
from employees;

-- Ejercicios avanzados
--Ejercicio 9
select last_name, printf("$%.10f", salary) as SALARY
from employees;

-- Ejercicio 10
select substr(last_name, 1, 8), salary  as EMPLOYEES_AND_THEIR_SALARIES
from employees;

-- Ejercicio 11
select last_name, CEIL((JULIANDAY('now') - JULIANDAY(hire_date)) / 7) as TENURE  
from employees
where department_id = '9'
order by 2 desc;

-- Ejercicio 12
select job_id, job_name, grade 
from employees
where job_id is not null;

select * from employees;
alter table employees add column grade;
