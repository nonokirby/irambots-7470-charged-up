/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
 /* 
 package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class pullIn extends CommandBase {

  public pullIn() {
    
  }
  public void execute () {
    RobotContainer.armDirectional.armMove(-0.4);
    RobotContainer.armLinear.armWinch(0.4);

  }
  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.armLinear.armWinch(0);
    RobotContainer.armDirectional.armMove(0);
  }

}


*/