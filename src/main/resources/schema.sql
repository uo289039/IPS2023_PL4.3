--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
--drop table Carreras;
--create table Carreras (id int primary key not null, inicio date not null, fin date not null, fecha date not null, descr varchar(32), check(inicio<=fin), check(fin<fecha));


--delete table Participa;
---delete table Atleta;
--delete table Competicion
--delete table Categoria;

drop table Competicion;
create table Competicion(id int primary key not null,inicio date not null, fin date not null, fecha date not null, descr varchar(32), 
cuota decimal(4,2), distancia decimal(4,2), check(inicio<=fin), check(fin<fecha));

drop table Atleta;
create table Atleta(dni int primary key not null,f_nacimiento date not null, nombre varchar(20) not null, sexo varchar(7) not null,
check(sexo in ('hombre','mujer')))

drop table Participa;
create table Participa(dni_at int not null, id_c int not null, constraint pk_Participa PRIMARY KEY(dni_at,id_c), 
                        constraint FK_Participa_Competicion Foreign Key (id_c) references "Competicion" (id),
                        constraint FK_Participa_Atleta Foreign Key (dni_at) references "Competicion" (dni));

drop table Categoria;
create table Categoria(id_comp int not null,tipo varchar(20) not null, constraint pk_Categoria PRIMARY KEY(id_comp),
constraint FK_Categoria_Competicion Foreign Key (id_comp) references "Competicion" (id),check(tipo in('Montaña','Plano')));