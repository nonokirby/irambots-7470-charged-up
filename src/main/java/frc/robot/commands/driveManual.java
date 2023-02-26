
package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.RobotContainer;
import frc.robot.RobotContainer;

public class driveManual extends CommandBase {
        public driveManual() {
        addRequirements(RobotContainer.driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        ////////////////////
        //Curvature Drive//
        ////////////////////
        //TODO edit joystick mapping for the drivetrain
    double speed = -RobotContainer.m_driver.getRawAxis(2);
    double rotation = -RobotContainer.m_driver.getRawAxis(1);
    boolean quickTurn = true;
//creates internal dead zone within code without affecting the controller
    if( speed > -0.1 && speed < 0.1){
      speed = 0;
    }
//creates internal dead zone within code without affecting the controller
    if( rotation > -0.1 && rotation < 0.1){

      rotation = 0;
    }
    if( speed < -0.5){

        rotation = 0;
      }
    RobotContainer.driveTrain.driveCurvature(-speed, rotation, quickTurn);

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
    }
  }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
   /* @Override
     protected void interrupted() {
    }
    */