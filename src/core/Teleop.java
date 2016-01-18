package core;

/**
 * Joins user input with core components
 * @author Trevor
 *
 */
public class Teleop {
	private RobotCore robotCore;
	private Drive drive;
	private IntakeRamp ir1;
	private IntakeRamp ir2;
	/**
	 * Creates standard teleop object
	 * 
	 * @param robotCorxe
	 * @param drive
	 */
	public Teleop (RobotCore robotCore, Drive drive, IntakeRamp ir1,IntakeRamp ir2)
 {
		this.robotCore = robotCore;
		this.drive = drive;
		this.ir1 = ir1;
		this.ir2 = ir2;
	}
		
	/**
	 * Periodic functionality including drive
	 */
	public void run() {
		
		robotCore.joy.update();
		joyDrive();
		joyIR();
	}
	
	private void joyDrive() {
		double[] rTheta = robotCore.joy.getRTheta();
		drive.move(rTheta[0], rTheta[1]);		
	
		
	}

	private void joyIR(){
		if(robotCore.intakeJoy.getRawButton(config.TeleopConfig.btnOpen1)){			
			ir1.open();
		} 
			
		if(robotCore.intakeJoy.getRawButton(config.TeleopConfig.btnClose1)){			
			ir1.close();
		} 
		
		if(robotCore.intakeJoy.getRawButton(config.TeleopConfig.btnReverse1)){
			ir1.reverse();
		} 
		
		if(robotCore.intakeJoy.getRawButton(config.TeleopConfig.btnForward1)){			
			ir1.forward();
		} 
	
		if(robotCore.intakeJoy.getRawButton(config.TeleopConfig.btnOpen2)){			
			ir2.open();
		} 
		
		if(robotCore.intakeJoy.getRawButton(config.TeleopConfig.btnClose1)){			
			ir1.close();
		} 
			
		if(robotCore.intakeJoy.getRawButton(config.TeleopConfig.btnReverse2)){
			ir2.reverse();
		}
		
		if(robotCore.intakeJoy.getRawButton(config.TeleopConfig.btnForward2)){			
			ir2.forward();
		} 
		
		if(robotCore.intakeJoy.getRawButton(config.TeleopConfig.btnStop1)){			
			ir1.stop();
		} 
		
		if(robotCore.intakeJoy.getRawButton(config.TeleopConfig.btnStop2)){			
			ir2.stop();
		} 
	
	}

}
