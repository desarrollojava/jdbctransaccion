drop table if exists persona;
create table persona(
idPersona identity primary key,
nombres varchar(20) not null,
apellidos varchar(20) not null,
direccionDomicilio varchar(20) not null
);