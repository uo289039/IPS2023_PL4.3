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
create table Competicion(id int primary key not null, nombre_c varchar(20) not null, fecha date not null, descr varchar(32), 
distancia decimal(4,2), tipo varchar(20) not null, nPlazas int not null, cancelacion varcchar(5) not null,
devolucion int not null, fechaCanc date, 
check(tipo in('Montaña','Ruta')),
check(cancelacion in('Si','No'))); --iban_c varchar(40) unique, 

drop table if exists Atleta;
create table Atleta(dni int primary key not null,f_nacimiento date not null, nombre varchar(20) not null,
sexo varchar(7) not null,inscripcion date not null, formaPago varchar(15) not null, correoE varchar(15) not null,
poblacion varchar(25) not null, telefono varchar(12) not null, pais varchar(30) not null, iban varchar(40) unique,
check(sexo in ('hombre','mujer')), check(formaPago in ('transferencia','tarjeta','')));

drop table if exists Participa;
create table Participa(correoElec varchar(15) not null, id_c int not null, estadoI varchar(15) not null,dorsal INTEGER, tiempo varchar(6),
ritmo decimal(4,2), completado varchar(15) not null,
						constraint pk_Participa PRIMARY KEY(correoElec,id_c), 
                        constraint FK_Participa_Competicion Foreign Key (id_c) references "Competicion" (id),
                        constraint FK_Participa_Atleta Foreign Key (correoElec) references "Atleta" (correoE),
                        constraint UK_Participa_dorsal_id_c UNIQUE (dorsal,id_c),
                        check(estadoI in ('No Inscrito','Preinscrito','Inscrito','Participado')),
                        check(completado in('No terminada','Terminada')));

                       

drop table if exists PagosTransferencia;
create table PagosTransferencia(nombre_Completo varchar(40) not null, correoElec varchar(25) not null, iban varchar(35) not null,
                        dni int not null, importe decimal(4,2), id_c int not null,
                        constraint pk_PagosTransferencia PRIMARY KEY(iban,correoElec), 
                        constraint FK_PagosTransferencia_Participa Foreign Key (correoElec,id_c) references "Participa" (correoE,id_c));
                       
                       



drop table if exists DatosInscripciones;
create table DatosInscripciones(nombre_c varchar(40) not null,
estadoI varchar(40) not null, fecha_cambio_estado date not null, correoE varchar(15) not null,
constraint FK_DatosAtleta_Participa Foreign Key (correoE) references "Participa" (correoElec));



drop table if exists TiempoParcial;
create table TiempoParcial(nombre varchar(40) not null, tiempo varchar(15),
id_c int not null, dorsal int not null,
constraint FK_TiempoParcial_Participa Foreign Key (id_c,dorsal) references "Participa" (id_c,dorsal)
);

drop table if exists Categoria;
drop table if exists CategoriaCompeticion;
create table CategoriaCompeticion(id_c int not null, nombre_cat varchar(30) not null, edadMin int not null, edadMax int not null, genero varchar(15),
                    constraint fk_Categoria_competicion foreign key (id_c) references "Competicion" (id));

drop table if exists Plazo;
create table Plazo(id_c int not null, descr varchar(30) not null, fechaIni varchar(20) not null, fechaFin varchar(20) not null, cuota decimal(4,2) not null,
                    constraint fk_Plazo_Competicion foreign key (id_c) references "Competicion" (id));


