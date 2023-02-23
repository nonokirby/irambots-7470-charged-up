// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class hookEast extends CommandBase {
  public hookEast() {
    // Use addRequirements() here to declare subsystem dependencies
    // eg. addRequirements(chassis);
addRequirements(Robot.hookDirectional);   
}
  

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    Robot.hookDirectional.hookRight();

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.hookDirectional.stop();

  }

  // Called when another command which addRequirements one or more of the same
  // subsystems is scheduled to run
/*   @Override
  protected void interrupted() {
    end();
  } */
}