CREATE TABLE produtos(
    id BIGINT NOT NULL auto_increment,
    nome VARCHAR(200) NOT NULL,
    descricao VARCHAR(300) NOT NULL,
    preco DOUBLE PRECISION NOT NULL,

    PRIMARY KEY(id) 
); 