-- Trabajando con varias tablas
drop table if exists libros;
drop table if exists editoriales;

create table libros(
	codigo_lib integer,
	titulo varchar(50),
	autor varchar(50),
	precio float,
	codigoeditorial integer,
	constraint pk_cod primary key(codigo_lib),
	constraint fk_cod_ed foreign key (codigoeditorial) references editoriales(codigo_ed)
);

create table editoriales(
	codigo_ed integer,
	nombre varchar(50),
	constraint pk_cod primary key(codigo_ed)
);

-- Insertando nombre de editoriales
insert into editoriales(nombre) values ('Planeta');
insert into editoriales(nombre) values ('Emece');
insert into editoriales(nombre) values ('Siglo XXI');
insert into editoriales(nombre) values ('Ediciones de la U');

-- Insertando libros
insert into libros (titulo, autor, codigoeditorial, precio)
values ('El aleph', 'Borges', 2, 34);

insert into libros (titulo, autor, codigoeditorial, precio)
values ('Antologia poetica', 'Borges', 1, 39.50);

 insert into libros (titulo, autor, codigoeditorial, precio)
  values('Java en 10 minutos', 'Mario Molina', 1, 50.50);

insert into libros (titulo, autor, codigoeditorial, precio)
values ('Alicia en el país de las maravillas', 'Lewis Carroll', 2, 19.90);

insert into libros (titulo, autor, codigoeditorial, precio)
values ('Martin Fierro', 'Jose Hernandez', 2, 25.90);

insert into libros (titulo, autor, codigoeditorial, precio)
values ('Martin Fierro', 'Jose Hernandez', 3, 16.80);

insert into libros (titulo, autor, precio)
values ('El Principito', 'Antoine de Saint-Exupéry', 16.80);

select * from libros;

select *
	from libros 
	join editoriales on libros.codigoeditorial = editoriales.codigo_ed;

  select titulo,nombre as Nombre_Editorial
  from editoriales as e
  left join libros as l on codigoeditorial = e.codigo_ed;

drop table libros;
drop table editoriales;

------- Combinación interna (Inner Join) ----------

-- Creación Tablas
create table clientes(
	codigo integer,
	nombre varchar(50),
	domicilio varchar(50),
	ciudad varchar(50),
	codigoprovincia int,
	constraint pk_codigo primary key(codigo),
	constraint fk_codigo_cl foreign key (codigo) references provincias(codigo)
);

create table provincias(
	codigo integer,
	nombre varchar(50),
	constraint pk_codigo primary key(codigo)
);

-- Insertando datos a Tablas
insert into provincias (nombre) values ('Cordoba');
insert into provincias (nombre) values ('Santa Fe');
insert into provincias (nombre) values ('Corrientes');

insert into clientes(nombre, domicilio, ciudad, codigoprovincia)
values ('Lopez Marcos', 'Colon 111', 'Córdoba', 1);

insert into clientes(nombre, domicilio, ciudad, codigoprovincia)
values ('Perez Ana', 'San Martin 222', 'Cruz del Eje', 1);

insert into clientes(nombre, domicilio, ciudad, codigoprovincia)
values ('Garcia Juan', 'Rivadavia 333', 'Villa Maria', 1);

insert into clientes(nombre, domicilio, ciudad, codigoprovincia)
values ('Perez Luis', 'Sarmiento 444', 'Rosario', 2);

insert into clientes(nombre, domicilio, ciudad, codigoprovincia)
values ('Pereyra Lucas', 'San Martin 555', 'Cruz del Eje', 1);

insert into clientes(nombre, domicilio, ciudad, codigoprovincia)
values ('Gomez Ines', 'San Martin 666', 'Santa Fe', 2);

insert into clientes(nombre, domicilio, ciudad, codigoprovincia)
values ('Torres Fabiola', 'Alem 777', 'Ibera', 3);

select c.nombre, domicilio, ciudad, p.nombre as "Provincia"
	from clientes as c 
	join provincias p on c.codigo = p.codigo
	where p.nombre = 'Santa Fe'
	order by p.nombre;

drop table clientes;
drop table provincias;

-- Ejercicio Propuesto PELICULAS Y GENEROS ---
drop table if exists peliculas;
drop table if exists generos;

create table generos(
	codigo_gen integer,
	descripcion varchar(150),
	constraint pk_cod primary key(codigo_gen)
);

create table peliculas(
	codigo_pel integer,
	titulo varchar(50),
	actor varchar(30),
	duracion integer,
	genero integer,
	constraint pk_codpel primary key(codigo_pel)
);

create table peli_gen(
	codigo_pel1 integer,
	codigo_gen1 integer,
	constraint fk_codpel foreign key(codigo_pel1) references peliculas(codigo_pel),
	constraint fk_codgen foreign key(codigo_gen1) references generos(codigo_gen)
);

insert into generos(descripcion) values ('Aventura'); -- 1
insert into generos(descripcion) values ('Romance'); -- 2
insert into generos(descripcion) values ('Acción'); -- 3

insert into peliculas(codigo_pel, titulo, actor, duracion, genero)
 	values(0001, 'Misión Imposible', 'Tom Cruise', 120, 3);
 
 insert into peliculas(codigo_pel, titulo, actor, duracion, genero)
 	values(0002, 'Harry Potter y la piedra filosofal', 'Daniel R.', 180, 1);
 
 insert into peliculas(codigo_pel, titulo, actor, duracion, genero)
 	values(0003, 'Harry Potter y la camara secreta', 'Daniel R.', 190, 1);
 
 insert into peliculas(codigo_pel, titulo, actor, duracion, genero)
 	values(0004, 'Mision Imposible 2', 'Tom Cruise', 120, 3);
 
 insert into peliculas(codigo_pel, titulo, actor, duracion, genero)
 	values(0005, 'Mujer Bonita', 'Richard Gere', 120, 2);
 
 insert into peliculas(codigo_pel, titulo, actor, duracion, genero)
 	values(0006, 'Elsa y Fred', 'China Zorrilla', 110, 2);
 
 -- Imprimir todos los datos de las peliculas inclusive su genero
 select p.codigo_pel as Código, titulo as Titulo, actor as Actor, duracion as "Dur Min", g.descripcion as Género 
	 from peliculas p 
	 join generos g on p.genero = g.codigo_gen; 
	 
	 
drop table if exists peliculas;
drop table if exists generos;















