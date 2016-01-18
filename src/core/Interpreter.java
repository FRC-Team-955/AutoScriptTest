package core;
import edu.wpi.first.wpilibj.Timer;

public class Interpreter
{
	private int autoStep = 0;
	private double[][] commands;
	private Drive drive;
	private Timer timer = new Timer();
	private boolean isFirst = true;
	
	public Interpreter(Drive drive){
		commands = Parser.parse();
		this.drive = drive;
	}
	
	public void next(){
		isFirst = true;
		autoStep++;
	}
	
	private void wait(double wantValue){
		if(isFirst)
			timer.start();
		
		if(timer.get() > wantValue)
			next();
	}
	
	public void dispatch(){
		
		switch((int)commands[autoStep][0]){
			case -1: {	//Dead line
				//die
			}	
			case 0:{	//Drive
				drive.move(commands[autoStep][1],commands[autoStep][2]);
				next();
				break;
			}
			
			case 1: {	//Wait
				wait(commands[autoStep][1]);
				break;
			}
		}
		
		isFirst = false;
	}
}
