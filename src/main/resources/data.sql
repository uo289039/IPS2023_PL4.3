--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:


delete from Participa;
delete from Atleta;
delete from Categoria;
delete from Competicion;
delete from PagosTransferencia;
delete from Plazo;


insert into Competicion(id,nombre_c,fecha,descr,distancia,tipo,nPlazas,devolucion,cancelacion) values 
	(100,'San Silvestre','2023-12-09','antes inscripcion',42,'Montaña',40,10,'Si'),
	(101,'Media Maraton','2023-12-10','en fase 3',21,'Ruta',30,5,'Si'),
	(102,'Vuelta Ciclista','2023-12-20','en fase 2',45,'Montaña',50,20,'Si'),
	(103,'Carrera Solidaria','2023-12-21','en fase 1',25,'Montaña',33,22,'No'),
	(104,'Subida al Cristo','2023-12-22','antes inscripcion',35,'Ruta',42,14,'Si');

insert into Atleta(dni,f_nacimiento,nombre,sexo,inscripcion,formaPago,correoE,poblacion,telefono,pais,iban) values
(1,'2004-11-03','Alexander','hombre','2016-10-10','transferencia','alex@gmail.com','Gijon','624 123 893', 'España','ES12 1234 5678 9098 7545 6787'),
(3,'2004-01-04','Marta','mujer','2016-10-09','tarjeta','marta@gmail.com','Aviles','623 198 813', 'España','ES65 6787 6567 1112 2222 3482'),
(7,'2002-12-09','Hunter','hombre','2016-11-01','transferencia','hunter@gmail.com','Madrid','612 122 803', 'España','ES61 4799 0517 7651 2972 3002'),
(2,'2003-01-12','Emilie','mujer','2016-10-10','tarjeta','emilie@gmail.com','Oviedo','656 197 891', 'España','ES21 4059 0197 7333 9419 9129'),
(9,'2000-10-11','Alexa','mujer','2016-10-12','tarjeta','alexa@gmail.com','Barcelona','655 185 821', 'España','ES54 4782 9123 0102 9860 0535'),
(10,'2001-11-03','Manolo','hombre','2016-10-10','transferencia','manolin@gmail.com','Ibias','624 123 894', 'España','ES22 1638 9123 0102 9860 0535'),
(11,'2001-11-03','Mariluz','mujer','2016-10-10','transferencia','mariluz@gmail.com','Degaña','624 123 895', 'España','ES54 2123 2123 0102 9860 0535');

insert into Participa(correoElec,id_c,estadoI) values 
('alex@gmail.com',100,'Inscrito'),('emilie@gmail.com',103,'Inscrito'),
('alexa@gmail.com',100,'Preinscrito'),('hunter@gmail.com',102,'Inscrito'),('marta@gmail.com',101,'Preinscrito'),
('manolin@gmail.com',100,'Inscrito'), ('mariluz@gmail.com',100,'Inscrito');



INSERT into PagosTransferencia (nombre_Completo,correoElec,dni,importe,iban,id_c)	values
('Alexander Graham','alex@gmail.com',1,52.5,'ES12 2222 5678 9098 7545 6787',100),
('Hunter Davis','hunter@gmail.com',7,52.5,'ES12 1234 2221 9898 7545 6787',103);


insert into Plazo(id_c,descr,fechaIni,fechaFin,cuota) values
(100,'Primer plazo','2023-11-28','2023-12-04',50.0),
(101,'Primer plazo','2023-12-30','2023-12-05',42.0),
(102,'Ultimo plazo','2023-11-29','2023-12-06',50.0),
(103,'Segundo plazo','2023-12-01','2023-12-06',30.2),
(104,'Primer plazo','2023-11-27','2023-12-04',37.0);