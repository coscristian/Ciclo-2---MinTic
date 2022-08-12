CREATE TABLE Adicional(
    id INTEGER PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio INTEGER NOT NULL,
    CONSTRAINT Adicional_nombre_UQ UNIQUE(nombre)
);

CREATE TABLE Mesa(
    id INTEGER PRIMARY KEY,
    numero VARCHAR(10) NOT NULL,
    CONSTRAINT Mesa_numero_UQ UNIQUE(numero)
);

CREATE TABLE PedidoAdicional(
    id_pedido INTEGER,
    id_adicional INTEGER,
    CONSTRAINT PedidoAdicional_id_pedido_PK PRIMARY KEY (id_pedido, id_adicional),
    CONSTRAINT PedidoAdicional_id_pedido_FK FOREIGN KEY (id_pedido) REFERENCES Pedido(id),
    CONSTRAINT PedidoAdicional_id_adicional_FK FOREIGN KEY (id_adicional) REFERENCES Adicional(id)
);

CREATE TABLE Pedido(
    id INTEGER,
    cliente VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    id_mesa INTEGER NOT NULL,
    CONSTRAINT Pedido_id_mesa_FK FOREIGN KEY (id_mesa) REFERENCES Mesa(id),
    CONSTRAINT id_pedido_id_mesa_PK PRIMARY KEY (id, id_mesa)
);

CREATE TABLE Corrientazo(
    id_pedido INTEGER PRIMARY KEY,
    precio INTEGER,
    id_sopa INTEGER NOT NULL,
    id_principio INTEGER NOT NULL,
    id_carne INTEGER NOT NULL,
    id_ensalada INTEGER,
    id_jugo INTEGER NOT NULL,
    CONSTRAINT Corrientazo_id_pedido_FK FOREIGN KEY (id_pedido) REFERENCES Pedido(id),
    CONSTRAINT Corrientazo_id_sopa_FK FOREIGN KEY (id_sopa) REFERENCES OpcionSopa(id),
    CONSTRAINT Corrientazo_id_principio_FK FOREIGN KEY (id_principio) REFERENCES OpcionPrincipio(id),
    CONSTRAINT Corrientazo_id_carne_FK FOREIGN KEY (id_carne) REFERENCES OpcionCarne(id),
    CONSTRAINT Corrientazo_id_ensalada_FK FOREIGN KEY (id_ensalada) REFERENCES OpcionEnsalada(id),
    CONSTRAINT Corrientazo_id_jugo_FK FOREIGN KEY (id_jugo) REFERENCES OpcionJugo(id)
);

CREATE TABLE OpcionSopa(
    id INTEGER PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE OpcionPrincipio(
    id INTEGER PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE OpcionCarne(
    id INTEGER PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE OpcionEnsalada(
    id INTEGER PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE OpcionJugo(
    id INTEGER PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

INSERT INTO MESA (id, numero) VALUES ('1', 1);