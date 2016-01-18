
package core;

import config.IRConfig;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {	
	RobotCore robotCore = new RobotCore();
	Drive drive = new Drive(robotCore); 
	IntakeRamp ir1 = new IntakeRamp(config.IRConfig.chnRampA1, config.IRConfig.chnRampA2, config.IRConfig.chnCimIntakeA, IRConfig.cimIntakeAIsFlipped);
	IntakeRamp ir2 = new IntakeRamp(config.IRConfig.chnRampB1, config.IRConfig.chnRampB2, config.IRConfig.chnCimIntakeB, IRConfig.cimIntakeBIsFlipped);
	Auto auto = new Auto(robotCore, ir1, ir2, drive);
	
	Teleop teleop = new Teleop(robotCore, drive, ir1, ir2);
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	auto.run();
    }

    /**
     * This function is called periodically during operator control
     * Run at 50hz
     */
    public void teleopPeriodic() {
    	teleop.run();
    	System.out.println(robotCore.encLeft.getDistance());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
    
}
