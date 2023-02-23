/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;


public class armWest extends CommandBase {
  
  public armWest() {
    // Use addRequirements() here to declare subsystem dependencies
    // eg. addRequirements(chassis);
    addRequirements(Robot.armDirectional);
  }

  // Called just before this Command runs the first time
 // @Override
  //protected void initialize() {
  


  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    Robot.armDirectional.armLeft();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.armDirectional.stop();
  }
  // Called when another command which addRequirements one or more of the same
  // subsystems is scheduled to run
 /*  @Override
  protected void interrupted() {
    end();
  } */
}