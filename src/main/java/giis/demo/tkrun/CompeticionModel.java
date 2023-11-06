package giis.demo.tkrun;

import giis.demo.util.Database;

public class CompeticionModel {
	private Database db=new Database();

	public void createCompeticion(int id, String nombre, String inicio, String fin, String fecha, String cuota,
			String descrip, String tipo, String nplazas, String iban, String distancia) {
		String sql="insert into Competicion (id,nombre_c,inicio,fin,fecha,descr,cuota,distancia,tipo,nPlazas,iban_c) values (?,?,?,?,?,?,?,?,?,?,?)";
		db.executeUpdate(sql,id,nombre,inicio,fin,fecha,descrip,cuota,distancia,tipo,nplazas,iban);
	}
}
