--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:
delete from competicion;
insert into competicion(id,inicio,fin,fecha,descr) values 
	(100,'2016-10-05','2016-10-25','2016-11-09','finalizada',50.0,5),
	(101,'2016-10-05','2016-10-25','2016-11-10','en fase 3',50.5,5),
	(102,'2016-11-05','2016-11-09','2016-11-20','en fase 2',50.0,5),
	(103,'2016-11-10','2016-11-15','2016-11-21','en fase 1',50.0,5),
	(104,'2016-11-11','2016-11-15','2016-11-22','antes inscripcion',50.0,5);
