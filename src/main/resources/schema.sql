--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
--drop table Carreras;
--create table Carreras (id int primary key not null, inicio date not null, fin date not null, fecha date not null, descr varchar(32), check(inicio<=fin), check(fin<fecha));


--delete table Participa;
--delete table Atleta;
--delete table Competicion
--delete table Categoria;

drop table if exists Categoria;
create table Categoria(id_categoria int not null,tipo varchar(20) not null, 
constraint pk_Categoria PRIMARY KEY(id_categoria),
check(tipo in('montaña','ruta')));


drop table if exists Competicion;
create table Competicion(id int primary key not null, inicio date not null, fin date not null, fecha date not null, descr varchar(32), 
cuota decimal(4,2), distancia decimal(4,2), id_cat int not null, nPlazas int not null,
constraint FK_Competicion_Categoria Foreign Key (id_cat) references "Categoria" (id_categoria), 
check(inicio<=fin),check(fin<fecha));

drop table if exists Atleta;
create table Atleta(dni int primary key not null,f_nacimiento date not null, nombre varchar(20) not null,
sexo varchar(7) not null,inscripcion date not null, formaPago varchar(15) not null, correoE varchar(15) not null,
check(sexo in ('hombre','mujer')), check(formaPago in ('transferencia','tarjeta')));

drop table if exists Participa;
<<<<<<< HEAD
create table Participa(dni_at int not null, id_c int not null, estadoI varchar(15), categoria varchar(20), constraint pk_Participa PRIMARY KEY(dni_at,id_c), 
>>>>>>> branch 'main' of https://github.com/uo289039/IPS2023_PL4.3
                        constraint FK_Participa_Competicion Foreign Key (id_c) references "Competicion" (id),
                        constraint FK_Participa_Atleta Foreign Key (dni_at) references "Competicion" (dni),
                        check(estadoI in ('No Inscrito','Preinscrito','Inscrito')));

CREATE TRIGGER calcular_categoria
AFTER INSERT ON Atleta
FOR EACH ROW
BEGIN
    DECLARE categoria varchar(20);
    DECLARE edad int;
    SET edad = DATEDIFF(YEAR, @f_nacimiento, GETDATE());
    IF NEW.sexo = 'hombre' THEN
        IF edad < 12 THEN
            SET categoria = 'Masculino sub-12';
        ELSEIF edad < 16 THEN
            SET categoria = 'Masculino sub-16';
        ELSEIF edad < 18 THEN
            SET categoria = 'Masculino sub-18';
        ELSEIF edad < 23 THEN
            SET categoria = 'Masculino sub-23';
        ELSEIF edad < 30 THEN
            SET categoria = 'Masculino senior-30';
        ELSEIF edad < 40 THEN
            SET categoria = 'Masculino senior-40';
        ELSEIF edad < 50 THEN
            SET categoria = 'Masculino senior-50';
        ELSEIF edad < 60 THEN
            SET categoria = 'Masculino senior-60';
        ELSEIF edad >= 60 THEN
            SET categoria = 'Masculino veteranos';
        END IF;
    ELSEIF NEW.sexo = 'mujer' THEN
        IF edad < 12 THEN
            SET categoria = 'Femenino sub-12';
        ELSEIF edad < 16 THEN
            SET categoria = 'Femenino sub-16';
        ELSEIF edad < 18 THEN
            SET categoria = 'Femenino sub-18';
        ELSEIF edad < 23 THEN
            SET categoria = 'Femenino sub-23';
        ELSEIF edad < 30 THEN
            SET categoria = 'Femenino senior-30';
        ELSEIF edad < 40 THEN
            SET categoria = 'Femenino senior-40';
        ELSEIF edad < 50 THEN
            SET categoria = 'Femenino senior-50';
        ELSEIF edad < 60 THEN
            SET categoria = 'Femenino senior-60';
        ELSEIF edad >= 60 THEN
            SET categoria = 'Femenino veteranas';
        END IF;
    END IF;
    INSERT INTO Participa (dni_at, id_c, categoria) VALUES (NEW.dni, null, categoria);
END;

                       