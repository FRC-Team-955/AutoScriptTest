
package core;

import edu.wpi.first.wpilibj.Timer;
import config.AutoConfig;

public class Auto {
	RobotCore robotcore;
	IntakeRamp ir1;
	IntakeRamp ir2;
	Drive drive;
	Timer tm = new Timer();
	
	private boolean isRunning = false;	//Whether the timer is running or not
	private int counter = 0;
	
	public Auto(RobotCore robotCore, IntakeRamp ir1, IntakeRamp ir2, Drive drive){
		this.robotcore = robotCore;
		this.ir1 = ir1;
		this.ir2 = ir2;
		this.drive = drive;
	}
	
	/**
	 * Runs through autonomous actions
	 */
	public void run(){
		switch(counter){			
			case 0:{
				move(AutoConfig.disDriveBackwards,1,0);
				break;
			}
			
			case 1:{
				runIntake2();
				break;
			}
			
			case 2:{
				move(AutoConfig.disDriveForward,1,90);
				break;
			}
			
			case 3:{
				runIntake1();
				break;
			}
			
			case 4:{
				move(AutoConfig.disDriveForwardEnd, 1, 90);
				break;
			}
			
		
		}
	}
	
	/**
	 * Runs front intake
	 */
	private void runIntake1(){
		if(!isRunning)
			tm.start();
		
		if(tm.get() < AutoConfig.intakeTime)
			ir1.forward();
		
		else{
			tm.stop();
			tm.reset();
			ir1.stop();
			counter++;
		}
	}
	
	/**
	 * runs back intake
	 */
	private void runIntake2(){
		if(!isRunning)
			tm.start();
		
		if(tm.get() < AutoConfig.intakeTime)
			ir2.forward();
		
		else{
			tm.stop();
			tm.reset();
			ir2.stop();
			counter++;
		}
	}
	
	/**
	 * Drives forward until at a predetermined distance
	 */
	private void move(double distance, double velocity, double angle){
		drive.move(velocity, angle);
		//		if(Math.abs(robotcore.encRight.getDistance() - distance) < AutoConfig.maxEncTolerance && Math.abs(robotcore.encLeft.getDistance() - distance) < AutoConfig.maxEncTolerance){
//			drive.move(velocity, angle);
//		}
		
//		else{
//			drive.move(0, 0);
//			//counter++;
//		}
			
	}
	
}


