--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:


delete from Participa;
delete from Atleta;
delete from Categoria;
delete from Competicion;
delete from PagosTransferencia;


insert into Competicion(id,nombre_c,inicio,fin,fecha,descr,cuota,distancia, id_cat,nPlazas) values 
	(100,'San Silvestre','2016-10-05','2016-10-25','2016-11-09','finalizada',50.0,5,1,40),
	(101,'Media Maraton','2016-10-05','2016-10-25','2016-11-10','en fase 3',50.5,5,2,30),
	(102,'Vuelta Ciclista','2016-11-05','2016-11-09','2016-11-20','en fase 2',50.0,5,3,50),
	(103,'Carrera Solidaria','2016-11-10','2016-11-15','2016-11-21','en fase 1',50.0,5,5,33),
	(104,'Subida al Cristo','2016-11-11','2016-11-15','2016-11-22','antes inscripcion',50.0,5,4,42);

insert into Atleta(dni,f_nacimiento,nombre,sexo,inscripcion,formaPago,correoE) values
(1,'2004-11-03','Alexander','hombre','2016-10-10','transferencia','alex@gmail.com'),
(3,'2004-1-04','Marta','mujer','2016-10-09','tarjeta','marta@gmail.com'),
(7,'2002-12-09','Hunter','hombre','2016-11-01','transferencia','hunter@gmail.com'),
(2,'2003-01-12','Emilie','mujer','2016-10-10','tarjeta','emilie@gmail.com'),
(9,'2000-10-11','Alexa','mujer','2016-10-12','tarjeta','alexa@gmail.com');

insert into Participa(correoElec,id_c,estadoI) values 
('alex@gmail.com',100,'Inscrito'),('emilie@gmail.com',103,'Inscrito'),
('alexa@gmail.com',100,'Preinscrito'),('hunter@gmail.com',102,'Inscrito'),('marta@gmail.com',101,'Preinscrito');

insert into Categoria(id_categoria,tipo) values(1,'montaña'),(2,'ruta'),(3,'montaña'),(4,'ruta'),(5,'montaña');

insert into DatosAtleta(nombre,nombre_c,categoria,inscripcion,cuota,id_c,correoE) values('Alexander','San Silvestre','ruta','2016-10-05',50.0,100,'alex@gmail.com'),
('Alexa','San Silvestre','ruta','2016-10-15',50.0,100,'alexa@gmail.com'),('Emilie','Carrera Solidaria','rura','2016-10-08',50.0,103,'emilie@gmail.com');

insert into DatosInscripciones (nombre_c, estadoI, fecha_cambio_estado, correoE) values
('San Silvestre','Inscrito','2016-10-10','alex@gmail.com'),
('San Silvestre','Preinscrito','2016-10-12','alexa@gmail.com')
,('Carrera Solidaria','Inscrito','2016-10-10','emilie@gmail.com'),
('Media Maraton','Preinscrito','2016-10-09','marta@gmail.com'), ('Vuelta Ciclista','Inscrito','2016-11-01','hunter@gmail.com');
