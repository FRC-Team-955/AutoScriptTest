package core;

import components.Cim;
import sensors.Enc;
import edu.wpi.first.wpilibj.Timer;


	public class Intake {
	
		private int cimChannel;
		private Cim cim;
//		private Enc enc;
//		private Timer tm;
		
		public Intake(int cimChannel, boolean isFlipped/* ,int chnA, int chnB*/){
		
		this.cimChannel = cimChannel;
		cim = new Cim(cimChannel, isFlipped);
//		enc = new Enc(chnA, chnB, config.EncConfig.encIntakeDisPulse);
		
		}
		
	public void forward(){
		cim.set(config.IntakeConfig.intakeCimSpeed);
//		tm.reset();
//		tm.start();
	}
	
	public void reverse(){
		cim.set(-1 *config.IntakeConfig.outtakeCimSpeed);
//		tm.reset();
//		tm.start();
	}
	
	public void stop(){
		cim.set(0);
//		tm.stop();
//		tm.reset();
	}
	
//	public void update(){
//		if(tm.get() > config.IntakeConfig.intakeStartTime){
//			if(enc.getRate() < config.IntakeConfig.intakeRateThreshold){
//				cim.set(0);
//				tm.stop();
//				tm.reset();
//			}
//		}
//	}
}
