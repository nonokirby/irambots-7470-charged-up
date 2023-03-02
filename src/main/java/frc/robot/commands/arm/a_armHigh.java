/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class a_armHigh extends InstantCommand{

  public a_armHigh() {
    addRequirements(RobotContainer.armLinear);
    addRequirements(RobotContainer.armDirectional);
  }

  @Override
  public void initialize(){
    RobotContainer.armLinear.p_armLength(Constants.pos_high_armLength);
    RobotContainer.armDirectional.p_armAngle(Constants.pos_high_armAngle);
  }
}
