package core;

public class Steps {

	public static double getStep(Type type) {
		
		double i;
		
		switch (type) {
		case DRIVE:
			i = 0.0;
			break;
		case WAIT:
			i=1.0;
			break;
		default:
			i = -1.0; 
			break;
		}
		return i;
	}
	
}
