package giis.demo.util.io.exception;

import giis.demo.util.argumentchecks.ArgumentChecks;

public class LineFormatException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int line;

	public LineFormatException() {
		// TODO Auto-generated constructor stub
	}
	
	public LineFormatException(String msg) {
		super(msg);
	}
	
	public LineFormatException(int line, String msg) {
		
		super(msg);
		ArgumentChecks.isTrue(line >= 0, msg);
		this.line = line;
		
	}
	
	@Override
	public String getMessage() {
		return "Error en línea " + line + ": " + super.getMessage();
	}

}
