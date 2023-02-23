// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class fullShooter extends CommandBase {
  public fullShooter() {
     addRequirements(Robot.maxShooter);
  }


  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    Robot.maxShooter.maxVert();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.maxShooter.stop();
  }

  // Called when another command which addRequirements one or more of the same
  // subsystems is scheduled to run
/*   @Override
  protected void interrupted() {
    end();
  } */
}

