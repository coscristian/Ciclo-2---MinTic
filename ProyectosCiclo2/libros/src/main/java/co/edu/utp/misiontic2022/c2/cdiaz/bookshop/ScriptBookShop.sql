CREATE TABLE libro(
	isbn varchar(50) not null,	
	id int,
	titulo varchar(50),	
	anio_pub int,
	constraint pk_isbn primary key (isbn),
	constraint fk_id foreign key (id) references stock(id)
);

CREATE TABLE stock(
	id int,
	cant_existente int,
	constraint pk_id primary key (id)
);

CREATE TABLE venta(
	fecha_hora date,
	libro_vendido varchar(50),
	num_unidades_vendidas int,
	constraint pk_fechah primary key (fecha_hora)
);

CREATE TABLE libro_venta(
	isbn2 varchar(50),
	fecha_hora2 date,
	constraint fk_isbn2 foreign key (isbn2) references libro(isbn),
	constraint fk_fechah2 foreign key (fecha_hora2) references venta(fecha_hora)
);

DROP TABLE libro;
DROP TABLE stock;
DROP TABLE venta;



