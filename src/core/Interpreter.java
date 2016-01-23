package core;
import edu.wpi.first.wpilibj.Timer;
import config.interpConfig;

public class Interpreter
{
	private int autoStep = 0;
	private double[][] commands;
	private Drive drive;
	private Timer timer = new Timer();
	private RobotCore robotCore;
	private boolean isFirst = true;
	private double prevAng = 0;
	private double angChange = 0;
	
	public Interpreter(Drive drive, RobotCore robotCore){
		this.drive = drive;
		this.robotCore = robotCore;
	}
	
	public void interpInit() {
		commands = Parser.parse();
	}
	
	public void next(){
		isFirst = true;
		System.out.println("Advancing to next step");
		autoStep++;
	}
	
	private void waitTimer(double wantValue){
		if(isFirst){
			timer.start();
			isFirst = false;
		}
		
		if(timer.get() >= wantValue) {
			timer.stop();
			timer.reset();
			next();
		}
	}
	
	private void waitGyro(double ang){
		
		if(isFirst){
			prevAng = robotCore.navX.getAngle();
			isFirst = false;
			prevAng = 0;
			angChange = 0;
		}
		double currAng = robotCore.navX.getAngle();
		
		if (Math.abs(prevAng - currAng) > interpConfig.angChangeThreshold){
			if(prevAng > 0)
				angChange += -((currAng - prevAng) + 360);	
			else
				angChange += ((currAng - prevAng) - 360);	
		}
		
		else {
			angChange += (currAng - prevAng);			
		}
		
		if(ang > 0 && angChange > ang) {
			next();
		}
		
		else if (ang < 0 && angChange < ang) {
			next();
		}
		prevAng = currAng;
	}
	
	public void dispatch(){
		
		if((commands[autoStep][0]) == -1) {	//Dead line
			drive.move(0, 0);
			System.out.println("Dead line at " + autoStep);
		}	
		else if ((commands[autoStep][0]) == Steps.getStep(Type.DRIVE)){	//Drive
			drive.move(commands[autoStep][1],commands[autoStep][2]);
			next();
			return;
		}
		else if ((commands[autoStep][0]) == Steps.getStep(Type.WAIT_TIMER)) {	//Wait
			waitTimer(commands[autoStep][1]);
		}
		else if ((commands[autoStep][0]) == Steps.getStep(Type.WAIT_GYRO)) {	//Wait
			waitGyro(commands[autoStep][1]);
		}
	}
}
