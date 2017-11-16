create table usuario (
    id bigint not null,
    nome varchar(250) not null,
    email varchar(250) not null,
    telefone varchar(20) not null,
    constraint pk_usuario primary key (id)
);
create sequence seq_usuario;
