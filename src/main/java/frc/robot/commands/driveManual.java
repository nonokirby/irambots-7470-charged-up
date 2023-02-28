
package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
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
    double speed = RobotContainer.m_driver.getRawAxis(2);
    double rotation = RobotContainer.m_driver.getRawAxis(1);
    boolean quickturn = true;
    System.out.print("driveManual");

    if(speed > -0.1 && speed < 0.1){
      speed = 0;
    }

    if(rotation > -0.1 && rotation < 0.1){
      rotation = 0;
    }
    if((speed < -0.1 || speed > 0.1) && (rotation < 0.3 && rotation > -0.3)){
        rotation = 0;
      }
    RobotContainer.driveTrain.driveCurvature(-speed, rotation, quickturn);

    double swipeSpeed = RobotContainer.m_driver.getRawAxis(0);
    if (swipeSpeed <= 0.1 || swipeSpeed >= -0.1){
      RobotContainer.driveTrain.sideSwipe(swipeSpeed);
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