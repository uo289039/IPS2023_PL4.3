--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:


delete from Participa;
delete from Atleta;
delete from Competicion;
delete from PagosTransferencia;


insert into Competicion(id,nombre_c,inicio,fin,fecha,descr,cuota,distancia,tipo,nPlazas,iban_c) values 
	(100,'San Silvestre','2016-10-05','2016-10-25','2016-11-09','finalizada',50.0,5,'Montaña',40,'ES12 1234 5678 9098 7545 6787'),
	(101,'Media Maraton','2016-10-05','2016-10-25','2016-11-10','en fase 3',50.5,5,'Ruta',30,'ES65 6787 6567 1112 2222 3482'),
	(102,'Vuelta Ciclista','2016-11-05','2016-11-09','2016-11-20','en fase 2',50.0,5,'Montaña',50,'ES61 4799 0517 7651 2972 3002'),
	(103,'Carrera Solidaria','2016-11-10','2016-11-15','2016-11-21','en fase 1',50.0,5,'Montaña',33,'ES21 4059 0197 7333 9419 9129'),
	(104,'Subida al Cristo','2016-11-11','2016-11-15','2016-11-22','antes inscripcion',50.0,5,'Ruta',42,'ES54 4782 9123 0102 9860 0535');

insert into Atleta(dni,f_nacimiento,nombre,sexo,inscripcion,formaPago,correoE,poblacion,telefono,pais) values
(1,'2004-11-03','Alexander','hombre','2016-10-10','transferencia','alex@gmail.com','Gijon','624 123 893', 'España'),
(3,'2004-01-04','Marta','mujer','2016-10-09','tarjeta','marta@gmail.com','Aviles','623 198 813', 'España'),
(7,'2002-12-09','Hunter','hombre','2016-11-01','transferencia','hunter@gmail.com','Madrid','612 122 803', 'España'),
(2,'2003-01-12','Emilie','mujer','2016-10-10','tarjeta','emilie@gmail.com','Oviedo','656 197 891', 'España'),
(9,'2000-10-11','Alexa','mujer','2016-10-12','tarjeta','alexa@gmail.com','Barcelona','655 185 821', 'España'),
(10,'2001-11-03','Manolo','hombre','2016-10-10','transferencia','manolin@gmail.com','Ibias','624 123 894', 'España'),
(11,'2001-11-03','Mariluz','mujer','2016-10-10','transferencia','mariluz@gmail.com','Degaña','624 123 895', 'España');

insert into Participa(correoElec,id_c,estadoI,estadoActual) values 
('alex@gmail.com',100,'Inscrito','Sub23-Masculino'),('emilie@gmail.com',103,'Inscrito','Sub23-Femenino'),
('alexa@gmail.com',100,'Preinscrito','Sub23-Femenino'),('hunter@gmail.com',102,'Inscrito','Sub23-Masculino'),('marta@gmail.com',101,'Preinscrito','Sub23-Femenino'),
('manolin@gmail.com',100,'Inscrito','Sub23-Masculino'), ('mariluz@gmail.com',100,'Inscrito','Sub23-Femenino');

insert into DatosAtleta(nombre,nombre_c,categoria,inscripcion,cuota,id_c,correoE) values('Alexander','San Silvestre','ruta','2016-10-05',50.0,100,'alex@gmail.com'),
('Alexa','San Silvestre','ruta','2016-10-15',50.0,100,'alexa@gmail.com'),('Emilie','Carrera Solidaria','ruta','2016-10-08',50.0,103,'emilie@gmail.com');


INSERT into PagosTransferencia (nombre_Completo,correoElec,dni,iban,importe)	values
('Alexander Graham','alex@gmail.com',1,'ES12 1234 5678 9098 7545 6787',52.5),
('Hunter Davis','hunter@gmail.com','ES61 4799 0517 7651 2972 3002',7,52.5);


insert into DatosInscripciones (nombre_c, estadoI, fecha_cambio_estado, correoE) values
('San Silvestre','Inscrito','2016-10-10','alex@gmail.com'),
('San Silvestre','Preinscrito','2016-10-12','alexa@gmail.com')
,('Carrera Solidaria','Inscrito','2016-10-10','emilie@gmail.com'),
('Media Maraton','Preinscrito','2016-10-09','marta@gmail.com'), ('Vuelta Ciclista','Inscrito','2016-11-01','hunter@gmail.com');
