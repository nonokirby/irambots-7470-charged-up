/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.armDirectional;

public class a_armMid extends InstantCommand{

  public final static armDirectional armDirectional = new armDirectional();
  public int aPos;
  public a_armMid() {
    addRequirements(RobotContainer.armLinear);
    addRequirements(RobotContainer.armDirectional);
  }
  @SuppressWarnings("resource")
  @Override
  public void initialize(){
    SendableChooser<SequentialCommandGroup> autoChooser;
    autoChooser = new SendableChooser<>();
    if (aPos == 0){
      SequentialCommandGroup a_armMid = new SequentialCommandGroup(
      new RunCommand(()   -> armDirectional.armMove(-0.5), armDirectional).withTimeout(2.5),
      new InstantCommand(()   -> armDirectional.armMove(0), armDirectional));
      autoChooser.setDefaultOption("a_armMid", a_armMid);
    }
    if (aPos == 1){
      SequentialCommandGroup a_armMid = new SequentialCommandGroup(
      new RunCommand(()   -> armDirectional.armMove(-0.5), armDirectional).withTimeout(2.5),
      new InstantCommand(()   -> armDirectional.armMove(0), armDirectional));
      autoChooser.setDefaultOption("a_armMid", a_armMid);
    }

  }
}
