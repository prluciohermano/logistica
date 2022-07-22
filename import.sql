CREATE TABLE pessoa (
id bigint,
nome VARCHAR(100),
cpf VARCHAR(11),
rg VARCHAR(20),
sexo VARCHAR(10),
cep VARCHAR(10),
rua VARCHAR(60),
numero VARCHAR(10),
bairro VARCHAR(60),
comp VARCHAR(150),
cidade VARCHAR(60),
uf VARCHAR(4),

primary key (id)
);

CREATE TABLE produto (
id bigint,
descricao VARCHAR(100),
preco_unitario NUMERIC(20,2),

primary key (id)
);

CREATE TABLE pedido (
id bigint,
pessoa_id bigint REFERENCES PESSOA (id),
data_pedido TIMESTAMP,
status VARCHAR(20),
total NUMERIC(20,2),

primary key (id)
);

CREATE TABLE item_pedido (
ID bigint,
pedido_id bigint REFERENCES pedido (id),
produto_id bigint REFERENCES produto (id),
quantidade bigint,

primary key (id)
);

CREATE TABLE usuario (
id bigint,
username VARCHAR(50),
password VARCHAR(180),
admin boolean,
departamento_id bigint REFERENCES departamento (id),

primary key (id)
);

CREATE TABLE departamento (
id bigint,
tipo_dep VARCHAR(20),

primary key (id)
);