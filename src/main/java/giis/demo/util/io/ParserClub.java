package giis.demo.util.io;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import giis.demo.tkrun.CategoriaEntity;
import giis.demo.tkrun.ClubEntity;
import giis.demo.tkrun.ClubModel;
import giis.demo.tkrun.ParticipaEntity;
import giis.demo.util.argumentchecks.ArgumentChecks;
import giis.demo.util.io.exception.LineFormatException;

public class ParserClub {
	
	private int lineNum = 0;
	private int atIns = 0;
	private int numAt;
	private ClubModel cm = new ClubModel();
	
	
	public ClubEntity parseLines(List<String> lineas, String idC, int numPlzs) {
		ClubEntity resultado = null;
		for(String linea: lineas) {
			try {
				lineNum++;
				if (lineNum == 1) {
					resultado = parseClub(linea, idC);
				}
				else if(numPlzs > 0) {
					inscribe(parseLine(linea, idC), idC);
					numPlzs--;
					atIns++;
				}
			} catch (LineFormatException e) {
				System.err.println("Linea " + lineNum + " no pudo ser parseada: " + e.getMessage());
			}
		}
		
		if(atIns == numAt)
			JOptionPane.showMessageDialog(null, "Todos los atletas han sido inscritos correctamente");
		else {
			int atRest = numAt - atIns;
			JOptionPane.showMessageDialog(null, "Se han inscrito los primeros " + atIns + ". Se quedaron sin plaza los " + atRest + " atletas restantes");
		}
		
		return resultado;
	}
	
	private void inscribe(ParticipaEntity atleta, String idC) {
		cm.inscribeAtleta(atleta);
		cm.bajaPlazas(idC);
	}

	private ClubEntity parseClub(String line, String idComp) throws LineFormatException {
		ArgumentChecks.isNotNull(line, "Línea no encontrada!");
		ArgumentChecks.isTrue(!line.isEmpty(), "Línea en blanco!");
		
		String[] tokens = line.split(";");
		String nombre = tokens[0];
		
		int numAt = parseInt(tokens[1]);
		this.numAt = numAt;

		Random random = new Random();
	    String idClub = String.valueOf(random.nextInt(1000) + 1);
		
		return new ClubEntity(idComp, idClub, nombre, numAt);
	}

	public ParticipaEntity parseLine(String line, String idC) throws LineFormatException {
		
		ArgumentChecks.isNotNull(line, "Línea no encontrada!");
		ArgumentChecks.isTrue(!line.isEmpty(), "Línea en blanco!");
		
		String[] tokens = line.split(";");
		String correo = tokens[0];
		
		String nombre = tokens[1];
		
		int año = parseInt(tokens[2]);
		int mes = parseInt(tokens[3]);
		int dia = parseInt(tokens[4]);
		
		String genero = tokens[5];
		
		Date fechaNac = new Date(año, mes, dia);
		Date hoy = new Date();
		long edad = (hoy.getTime() - fechaNac.getTime()) / 1000 / 60 / 60 / 24 / 365;
		
		String cat = "General";
		List<CategoriaEntity> categorias = new ClubModel().getCategorias(Integer.parseInt(idC));
		for (CategoriaEntity c: categorias) {
			if (edad >= c.getEdadMin() && edad <=c.getEdadMax() && genero.equals(c.getGenero()))
				cat = c.getNombre();
		}
		
		return new ParticipaEntity(correo, idC, "Inscrito", cat);
		
	}

	private int parseInt(String value) throws LineFormatException {
		try {
			return Integer.parseInt(value);
		} catch(NumberFormatException e) {
			throw new LineFormatException("No se pudo parsear el dato " + value +" a precisión doble");
		}
	}
}
