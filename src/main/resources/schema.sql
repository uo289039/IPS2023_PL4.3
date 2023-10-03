--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
--drop table Carreras;
--create table Carreras (id int primary key not null, inicio date not null, fin date not null, fecha date not null, descr varchar(32), check(inicio<=fin), check(fin<fecha));


delete table Participa;

drop table Competicion;
create table Competicion(id int primary key not null,inicio date not null, fin date not null, fecha date not null, descr varchar(32), 
cuota decimal(4,2), distancia decimal(4,2), check(inicio<=fin), check(fin<fecha));


drop table Participa;
create table Participa(dni_at int not null, id_c int not null, constraint pk_Participa (dni_at,id_c), 
                        constraint FK_Participa_Competicion Foreign Key (id_c) references "Competicion" (id));