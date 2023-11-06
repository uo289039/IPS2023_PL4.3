--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
--drop table Carreras;
--create table Carreras (id int primary key not null, inicio date not null, fin date not null, fecha date not null, descr varchar(32), check(inicio<=fin), check(fin<fecha));


--delete table Participa;
--delete table Atleta;
--delete table Competicion
--delete table Categoria;

drop table if exists Competicion;
create table Competicion(id int primary key not null, nombre_c varchar(20) not null,inicio date not null, fin date not null, fecha date not null, descr varchar(32), 
cuota decimal(4,2), distancia decimal(4,2), tipo varchar(20) not null, nPlazas int not null, iban_c varchar(40) unique,
check(tipo in('Montaña','Ruta')),
check(inicio<=fin),check(fin<fecha));

drop table if exists Atleta;
create table Atleta(dni int primary key not null,f_nacimiento date not null, nombre varchar(20) not null,
sexo varchar(7) not null,inscripcion date not null, formaPago varchar(15) not null, correoE varchar(15) not null,
poblacion varchar(25) not null, telefono varchar(12) not null, pais varchar(30) not null, categoria varchar(30) not null,
check(sexo in ('hombre','mujer')), check(formaPago in ('transferencia','tarjeta','')));

drop table if exists Participa;
create table Participa(correoElec varchar(15) not null, id_c int not null, estadoI varchar(15) not null,dorsal INTEGER unique,
						constraint pk_Participa PRIMARY KEY(correoElec,id_c), 
                        constraint FK_Participa_Competicion Foreign Key (id_c) references "Competicion" (id),
                        constraint FK_Participa_Atleta Foreign Key (correoElec) references "Atleta" (correoE),
                        check(estadoI in ('No Inscrito','Preinscrito','Inscrito')));
                       

drop table if exists PagosTransferencia;
create table PagosTransferencia(nombre_Completo varchar(40) not null, correoElec varchar(25) not null, iban varchar(35) not null,
                        dni int not null, importe decimal(4,2),
                        constraint pk_PagosTransferencia PRIMARY KEY(iban,correoElec), 
                        constraint FK_Competicion_PagosTransferencia Foreign Key (iban) references "Competicion" (iban_c), 
                        constraint FK_PagosTransferencia_Atleta Foreign Key (correoElec) references "Atleta" (correoE));
                       
                       
drop table if exists DatosAtleta;
create table DatosAtleta(nombre varchar(40) not null,nombre_c varchar(40) not null,
categoria varchar(40) not null, inscripcion date not null, cuota decimal(4,2) not null, id_c int not null, correoE varchar(15) not null,
constraint FK_DatosAtleta_Participa Foreign Key (id_c) references "Participa" (id_c),
constraint FK_DatosAtleta_Participa Foreign Key (correoE) references "Participa" (correoElec));


drop table if exists DatosInscripciones;
create table DatosInscripciones(nombre_c varchar(40) not null,
estadoI varchar(40) not null, fecha_cambio_estado date not null, correoE varchar(15) not null,
constraint FK_DatosAtleta_Participa Foreign Key (correoE) references "Participa" (correoElec));

drop table if exists Tiempo;
create table Tiempo(id_c int, dorsal int, tiempo varchar(6),
                    constraint fk_tiempos_participa foreign key (dorsal, id_c) references "Participa" (dorsal, id_c));
