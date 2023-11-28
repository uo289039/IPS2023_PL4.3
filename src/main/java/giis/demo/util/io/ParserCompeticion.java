package giis.demo.util.io;

import java.util.ArrayList;
import java.util.List;

import giis.demo.tkrun.TiempoEntity;
import giis.demo.util.argumentchecks.ArgumentChecks;
import giis.demo.util.io.exception.LineFormatException;

public class ParserCompeticion {
	
	private int lineNum = 0;
	
	
	public List<TiempoEntity> parseLines(List<String> lineas, String idC) {
		List<TiempoEntity> resultado = new ArrayList<>();
		for(String linea: lineas) {
			try {
				lineNum++;
				resultado.add(parseLine(linea, idC));
			} catch (LineFormatException e) {
				System.err.println("Linea " + lineNum + " no pudo ser parseada: " + e.getMessage());
			}
		}
		return resultado;
	}
	
	public TiempoEntity parseLine(String line, String idC) throws LineFormatException {
		
		ArgumentChecks.isNotNull(line, "Línea no encontrada!");
		ArgumentChecks.isTrue(!line.isEmpty(), "Línea en blanco!");
		
		String[] tokens = line.split(";");
		int dorsal = parseInt(tokens[0]);
		
		String tiempo = tokens[1];
		
		if(tokens[1].equalsIgnoreCase("N/S") || tokens[1].equalsIgnoreCase("N/T")) {
			tiempo = "---";
		}
		
		
		List<String>tp=new ArrayList<String>();
		if(tokens.length > 2) {
			for(int i=2; i<tokens.length; i++) {
				if(!tokens[i].isEmpty())
					tp.add(tokens[i]);
			}
		}
		
		return new TiempoEntity(idC, dorsal, tiempo, tp);
		
	}

	private int parseInt(String value) throws LineFormatException {
		try {
			return Integer.parseInt(value);
		} catch(NumberFormatException e) {
			throw new LineFormatException("No se pudo parsear el dato " + value +" a precisión doble");
		}
	}
}
