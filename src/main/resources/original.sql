CREATE TABLE pessoa (
id LONG PRIMARY KEY AUTO_INCREMENT,
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
uf VARCHAR(4)
);

CREATE TABLE produto (
id LONG PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(100),
preco_unitario NUMERIC(20,2)
);

CREATE TABLE pedido (
id LONG PRIMARY KEY AUTO_INCREMENT,
pessoa_id LONG REFERENCES PESSOA (id),
data_pedido TIMESTAMP,
status VARCHAR(20),
total NUMERIC(20,2)
);

CREATE TABLE item_pedido (
ID LONG PRIMARY KEY AUTO_INCREMENT,
pedido_id LONG REFERENCES pedido (id),
produto_id LONG REFERENCES produto (id),
quantidade LONG
);

CREATE TABLE usuario (
id LONG PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(50),
password VARCHAR(180),
admin boolean,
departamento_id LONG REFERENCES departamento (id)
);

CREATE TABLE departamento (
id LONG PRIMARY KEY AUTO_INCREMENT,
tipo_dep VARCHAR(20)
);