CREATE Database escuela
use escuela

-- Tabla carrera
create table carrera(
	clave_c int,
	nom_c varchar(50),
	durac_c float,
	constraint pk_cc primary key(clave_c)  -- Indicando la llave primaria
)

-- Tabla materia
create table materia(
	clave_m int,
	nom_m varchar(50),
	cred_m float,
	constraint pk_cm primary key(clave_m)
)

-- Tabla profesor
create table profesor(
	clave_p int,
	nom_p varchar(150),
	dir_p varchar(200),
	tel_p bigint,
	hor_p datetime,
	constraint pk_cp primary key (clave_p)
)

-- Tabla alumno (Con una clave foranea)
create table alumno(
	mat_alu int,
	nom_alu varchar(150),
	edad_alu int,
	sem_alu int,
	gen_alu varchar(10),
	clave_c1 int,
	constraint pk_calu primary key (mat_alu),  -- Clave primaria
	constraint fk_fc1 foreign key (clave_c1) references carrera (clave_c) -- Clave foranea
)

-- Alumno-Profesor 
create table alu_pro(
	mat_alu1 int,
	clave_p1 int,
	constraint fk_falu1 foreign key (mat_alu1) references alumno(mat_alu),
	constraint fk_fpro1 foreign key (clave_p1) references profesor(clave_p)
)

-- Materia-alumno 
create table mat_alu(
	clave_m1 int,
	mat_alu2 int,
	constraint fk_fcm foreign key (clave_m1) references materia (clave_m),
	constraint fk_fma foreign key (mat_alu2) references alumno (mat_alu)
)

-- Materia-profesor 
create table mat_pro(
	clave_m2 int,
	clave_p2 int,
	constraint fk_fm2 foreign key (clave_m2) references materia (clave_m),
	constraint fk_fp2 foreign key (clave_p2) references profesor(clave_p)
)


/* Insert */
/* Insertando carreras*/
insert into carrera values (1, 'Derecho', 3)
insert into carrera values (2, 'Ingeniería en Sistemas', 4)
insert into carrera values (3, 'Diseño', 3)

/* Insertanto materias */
insert into materia values (1, 'Matemáticas', 25)
insert into materia values (2, 'Español', 15)
insert into materia values (3, 'Dibujo', 15)
insert into materia values (4, 'Programación', 20)

/* Insertando profesores */
insert into profesor values (1, 'Laura Rosas', 'Calle Azul', 56789, '7:00')
insert into profesor values (2, 'Roberto Diaz', 'Calle Rosa', 47589, '8:00')

/* Insertando alumnos */
-- Ana estudia Derecho
insert into alumno values (1, 'Ana', 18, 6, 'Mujer', 1)
-- Sergio estudia Ingeniería de Sistemas
insert into alumno values (2, 'Sergio', 19, 7, 'Hombre', 2)
-- Julieta estudia Diseño
insert into alumno values (3, 'Julieta', 20, 6, 'Mujer', 3)

/* Relacion entre alumnos y profesores */
-- A Ana le da clases el profesor Roberto Diaz con clave 2
insert into alu_pro values (1, 2)
-- A Sergio le da clases el profesor Roberto Diaz con clave 2
insert into alu_pro values (2,2)
-- A Julieta le da clases el profesor Roberto Diaz con clave 2
insert into alu_pro values (3,2)

/* Relación entre alumnos y materias */
-- Ana toma la clase Matematicas
insert into mat_alu values (1, 1)
-- Sergio toma la clase de Programación
insert into mat_alu values (4, 2)
-- Julieta toma la clase de Dibujo
insert into mat_alu values (3, 3)
-- Ana toma la clase de Programación
insert into mat_alu values (4, 1)

/* Relación entre materias y profesores */
insert into mat_pro values(2, 2)

select nom_alu, edad_alu, sem_alu, nom_c, nom_p, nom_m
from alumno inner join carrera on alumno.clave_c1 = carrera.clave_c
inner join alu_pro on alu_pro.mat_alu1 = alumno.mat_alu
inner join profesor on alu_pro.clave_p1 = profesor.clave_p 
inner join mat_alu on mat_alu.mat_alu2 = alumno.mat_alu
inner join materia on mat_alu.clave_m1 = materia.clave_m
order by 1

/* Borrado de tablas */
DROP TABLE carrera;
DROP TABLE materia;
DROP TABLE profesor;
DROP TABLE alumno;
DROP TABLE alu_pro;
DROP TABLE mat_alu;
DROP TABLE mat_pro;







