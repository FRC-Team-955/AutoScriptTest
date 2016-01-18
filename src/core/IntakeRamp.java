package core;

/**
 * Components that interact with game pieces
 * @author Trevor
 *
 */
public class IntakeRamp{
	public RobotCore core;

	public Ramp ramp;
	public Intake intake;
  
  /**
   * Wrapper for given ramp and intake
   * 
   * @param chnRampOne
   * @param chnRampTwo
   * @param cimIntake
   */
	public IntakeRamp(int chnRampOne, int chnRampTwo, int cimIntake, boolean isFlipped){
	ramp = new Ramp(chnRampOne, chnRampTwo);
		intake  = new Intake(cimIntake, isFlipped);
	} 

	public void forward(){
		intake.forward();
	}

	public void reverse(){
		intake.reverse();
	
	}

	public void open(){
		ramp.open();
	}
	
	public void close(){
		ramp.close();
	}
	
	public void stop() {
		intake.stop();
	}

} 
