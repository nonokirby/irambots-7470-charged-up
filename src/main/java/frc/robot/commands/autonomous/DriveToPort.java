package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
//import frc.robot.RobotMap;
//import frc.robot.subsystems.driveTrain;
//import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

public class DriveToPort extends CommandBase {

    public DriveToPort () {
        addRequirements(Robot.driveTrain);
        withTimeout(5.0);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        double startTime = Timer.getMatchTime();
        // change joystick mapping for drivetrain here
        if ( startTime < 6.0) { 
            Robot.driveTrain.driveCurvature(-Robot.RobotContainer.m_arcade.getRawAxis(3)* 0.7, Robot.RobotContainer.m_arcade.getRawAxis(0) * 0.7,true);
        } else {
            Robot.driveTrain.driveCurvature(Robot.RobotContainer.m_arcade.getRawAxis(3) * 0.0, Robot.RobotContainer.m_arcade.getRawAxis(0) * 0.0,false);
            
        }
      
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}