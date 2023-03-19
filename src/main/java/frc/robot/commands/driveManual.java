
package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class driveManual extends CommandBase {
        public driveManual() {
        addRequirements(RobotContainer.driveTrain);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

    double speed = RobotContainer.m_driver.getRawAxis(Constants.ax_driveTrainSpeed);
    double rotation = RobotContainer.m_driver.getRawAxis(Constants.ax_driveTrainRotation);
    double swipeSpeed = RobotContainer.m_driver.getRawAxis(Constants.ax_driveTrainSwipe);

    SmartDashboard.putNumber("set speed", speed);

    if(speed > -0.1 && speed < 0.1){
      speed = 0;
    }

    if(rotation > -0.1 && rotation < 0.1){
      rotation = 0;
    }
    if((speed < -0.1 || speed > 0.1) && (rotation < 0.2 && rotation > -0.2)){
      rotation = 0;
    }
    RobotContainer.driveTrain.driveArcade(-speed * Constants.lm_driveTrainSpeed, rotation * Constants.lm_driveTrainRotation);

     if (swipeSpeed <= 0.1 || swipeSpeed >= -0.1){
       RobotContainer.driveTrain.sideSwipe(swipeSpeed * Constants.lm_driveTrainSide);
       
     }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
    }
  }