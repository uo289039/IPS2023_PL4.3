package giis.demo.util.io;

import giis.demo.tkrun.TiempoEntity;
import giis.demo.util.argumentchecks.ArgumentChecks;
import giis.demo.util.io.exception.LineFormatException;

public class ParserCompeticion {
	
	public TiempoEntity parseLine(String line) throws LineFormatException {
		
		ArgumentChecks.isNotNull(line, "Línea no encontrada!");
		ArgumentChecks.isTrue(!line.isEmpty(), "Línea en blanco!");
		
		String[] tokens = line.split("\t");
		int dorsal = parseInt(tokens[0]);
		String tInicio = tokens[1];
		String tFin = tokens[2];
		double tiempo = getTiempo(tInicio, tFin);
		return new TiempoEntity(dorsal, tiempo);
		
	}

	private int parseInt(String value) throws LineFormatException {
		try {
			return Integer.parseInt(value);
		} catch(NumberFormatException e) {
			throw new LineFormatException("No se pudo parsear el dato " + value +" a precisión doble");
		}
	}
	
	@SuppressWarnings("unused")
	private double parseDouble(String value) throws LineFormatException {
		try {
			return Double.parseDouble(value);
		} catch(NumberFormatException e) {
			throw new LineFormatException("No se pudo parsear el dato " + value +" a precisión doble");
		}
		
	}
	
	private double getTiempo(String tInicio, String tFin) throws LineFormatException {
		
		return 0;
	}
}
