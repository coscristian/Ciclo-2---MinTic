-- Trabajando con varias tablas
drop table if exists libros;
drop table if exists editoriales;

create table libros(
	codigo integer,
	titulo varchar(50),
	autor varchar(50),
	precio float,
	codigo_editorial integer,
	constraint pk_cod_lib primary key (codigo),
	--constraint fk_cod_ed foreign key (codigo_editorial) references editorial(codigo)
);

create table editoriales(
	codigo integer ,
	nombre varchar(50),
	--constraint pk_cod_ed primary key (codigo)
);

-- Insertando nombre de editoriales
insert into editoriales(nombre) values ('Planeta');
insert into editoriales(nombre) values ('Emece');
insert into editoriales(nombre) values ('Siglo XXI');

-- Insertando libros
insert into libros (titulo, autor, precio, codigo_editorial)
values ('El aleph', 'Borges', 2, 34);

insert into libros (titulo, autor, precio, codigo_editorial)
values ('Antologia poetica', 'Borges', 1, 39.50);

insert into libros (titulo, autor, precio, codigo_editorial)
values ('Alicia en el país de las maravillas', 'Lewis Carroll', 2, 19.90);

insert into libros (titulo, autor, precio, codigo_editorial)
values ('Martin Fierro', 'Jose Hernandez', 2, 25.90);

insert into libros (titulo, autor, precio, codigo_editorial)
values ('Martin Fierro', 'Jose Hernandez', 3, 16.80);

select *
from libros 
join editoriales on libros.codigo_editorial = editoriales.codigo;

drop table libros;



