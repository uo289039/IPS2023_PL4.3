--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:


delete from Participa;
delete from Atleta;
delete from Categoria;
delete from Competicion;
insert into Competicion(id,inicio,fin,fecha,descr,cuota,distancia) values 
	(100,'2016-10-05','2016-10-25','2016-11-09','finalizada',50.0,5),
	(101,'2016-10-05','2016-10-25','2016-11-10','en fase 3',50.5,5),
	(102,'2016-11-05','2016-11-09','2016-11-20','en fase 2',50.0,5),
	(103,'2016-11-10','2016-11-15','2016-11-21','en fase 1',50.0,5),
	(104,'2016-11-11','2016-11-15','2016-11-22','antes inscripcion',50.0,5);

insert into Atleta(dni,f_nacimiento,nombre,sexo) values
(1,'2004-11-03','Alexander','hombre'),(3,'2004-1-04','Marta','mujer'),(7,'2002-12-09','Hunter','hombre'),
(2,'2003-01-12','Emilie','mujer'),(9,'2000-10-11','Alexa','mujer');

insert into Participa(dni_at,id_c) values 
(1,100),(2,103),(9,100),(7,102),(3,101);

insert into Categoria(id_comp,tipo) values(100,'montaña'),(103,'ruta'),(101,'montaña'),(102,'ruta'),(104,'montaña')