// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.driveTrain;
import frc.robot.RobotContainer;
public class driveManual extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final driveTrain driveTrain;

  /**
   * Creates a new ExampleCommand.
   *
   * @param drive The subsystem used by this command.
   */
  public driveManual(driveTrain drive) {
    driveTrain = drive;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = Robot.RobotContainer.m_arcade.getRawAxis(1) - Robot.RobotContainer.m_arcade.getRawAxis(2) - -Robot.RobotContainer.m_driver.getRawAxis(2);
    double rotation = Robot.RobotContainer.m_arcade.getRawAxis(0) - Robot.RobotContainer.m_driver.getRawAxis(1);
    boolean quickTurn = speed > -0.15 && speed < 0.15;
//creates internal dead zone within code without affecting the controller
    if( speed > -0.05 && speed < 0.05){
      speed = 0;
    }
//creates internal dead zone within code without affecting the controller
    if( rotation > -0.05 && rotation < 0.05){

      rotation = 0;
    }
    if( speed < -0.5){

        rotation = 0;
      }
    Robot.drive.driveCurvature(-speed, rotation, quickTurn);
   // Robot.drive.tankDrive(Robot.RobotContainer.m_arcade.getRawAxis(1),Robot.RobotContainer.m_arcade.getRawAxis(2));
    }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
