package giis.demo.util.argumentchecks;

public class ArgumentChecks {
	
	public static void isNotNull(Object o, String msg) {
		if(o == null) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public static void isTrue(boolean arg, String msg) {
		if(!arg) {
			throw new IllegalArgumentException(msg);
		}
	}

}
