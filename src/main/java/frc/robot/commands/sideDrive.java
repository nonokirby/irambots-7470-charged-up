// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class sideDrive extends CommandBase {
  public sideDrive() {
    addRequirements(RobotContainer.sideSwipe);
  }


  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    double speed = RobotContainer.m_driver.getRawAxis(0);
    if (speed >= 0.1 || speed <= -0.1){
      RobotContainer.sideSwipe.swipe(speed);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    RobotContainer.sideSwipe.stop();
  }
}

