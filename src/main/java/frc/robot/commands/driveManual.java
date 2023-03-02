
package frc.robot.commands;
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

    if(speed > -Constants.db_driveTrainSpeed && speed < Constants.db_driveTrainSpeed){
      speed = 0;
    }

    if(rotation > -Constants.db_driveTrainRotationStill && rotation < Constants.db_driveTrainRotationStill){
      rotation = 0;
    }
    if((speed < -Constants.db_driveTrainRotationSpeed || speed > Constants.db_driveTrainRotationSpeed) && (rotation < Constants.db_driveTrainRotationMove && rotation > -Constants.db_driveTrainRotationMove)){
      rotation = 0;
    }
    RobotContainer.driveTrain.driveCurvature(-speed * Constants.lm_driveTrainSpeed, rotation * Constants.lm_driveTrainRotation, true);

     if (swipeSpeed <= Constants.db_driveTrainSwipe || swipeSpeed >= -Constants.db_driveTrainSwipe){
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