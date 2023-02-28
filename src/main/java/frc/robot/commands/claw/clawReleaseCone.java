// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.claw;
import frc.robot.RobotContainer;
import frc.robot.subsystems.grabber;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class clawReleaseCone extends InstantCommand {

  public clawReleaseCone() {
    addRequirements(RobotContainer.grabber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.grabber.s_grabberToggle(Value.kReverse);
    RobotContainer.grabber.l_grabberToggle(Value.kForward);
  }
}
