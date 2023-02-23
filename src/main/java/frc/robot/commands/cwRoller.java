/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//im in pain
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class cwRoller extends CommandBase {
  public cwRoller() {
    // Use addRequirements() here to declare subsystem dependencies
    addRequirements(Robot.rollerSpeed);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    Robot.rollerSpeed.rollermotor.set(1);
    //if wrong direction, just flip numbers of ccwRoller and cwRoller
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.rollerSpeed.rollermotor.set(0);
  }

  // Called when another command which addRequirements one or more of the same
  // subsystems is scheduled to run
 /*  @Override
  protected void interrupted() {
  } */
}