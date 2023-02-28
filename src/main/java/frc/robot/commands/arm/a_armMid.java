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

public class a_armMid extends InstantCommand{

  public a_armMid() {
    addRequirements(RobotContainer.arm);
  }

  @Override
  public void initialize(){
    RobotContainer.arm.p_armLength(Constants.pos_mid_armLength);
    RobotContainer.arm.p_armAngle(Constants.pos_mid_armAngle);
  }
}
