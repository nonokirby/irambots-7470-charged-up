/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class w_armRetract extends CommandBase {

  public w_armRetract() {
    addRequirements(RobotContainer.arm);
  }

  @Override
  public void execute (){
    RobotContainer.arm.armWinch(1);
  }
  
  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.arm.armWinch(0);
  }

}