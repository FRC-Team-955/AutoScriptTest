package core;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;;

public class Ramp {

	private DoubleSolenoid noid;
	public Ramp(int chnOne, int chnTwo) {
		noid = new DoubleSolenoid(chnOne, chnTwo);
	}
	
	
	public void open(){
		noid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void close(){
		noid.set(DoubleSolenoid.Value.kReverse);
	}
}
