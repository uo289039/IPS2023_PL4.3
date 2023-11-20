package giis.demo.tkrun;

import giis.demo.util.Database;

public class CompeticionModel {
	private Database db=new Database();

	public void createCompeticion(int id, String nombre, String fecha, String descripcion, String tipo, String nPlazas, String distancia, String iban) {
		String sql="insert into Competicion (id,nombre_c,fecha,descr,distancia,tipo,nPlazas,iban_c) values (?,?,?,?,?,?,?,?)";
		db.executeUpdate(sql,id,nombre,fecha,descripcion,distancia,tipo,nPlazas,iban);
	}

	public void insertCategory(int id, String nombre, int edadMin, int edadMax, String genero) {
		String sql="insert into Categoria (id_c,nombre_cat,edadMin,edadMax,genero) values (?,?,?,?,?)";
		db.executeUpdate(sql,id,nombre,edadMin,edadMax,genero);
	}

	public void insertPlazo(int id, String descr, String fechaIni, String getfechaFin, int cuota) {
		String sql="insert into Plazo (id_c,descr,getfechaFin,edadMax,cuota) values (?,?,?,?,?)";
		db.executeUpdate(sql,id,descr,fechaIni,getfechaFin,cuota);
	}
}
