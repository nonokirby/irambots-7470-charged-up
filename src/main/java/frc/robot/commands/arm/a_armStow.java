/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class a_armStow extends InstantCommand{

  public a_armStow() {
    addRequirements(RobotContainer.arm);
  }

  @Override
  public void execute (){
    RobotContainer.arm.p_armLength(0);
    RobotContainer.arm.p_armAngle(0);
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
