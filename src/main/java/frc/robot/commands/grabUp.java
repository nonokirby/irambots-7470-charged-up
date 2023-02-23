// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.subsystems.grabber;
import edu.wpi.first.wpilibj2.command.CommandBase;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class grabUp extends CommandBase {
public grabUp(grabber subsystem) {
    addRequirements(Robot.grabber);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.grabber.grabUp();
    System.out.print("grabUp ");
  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return true;
  }
}
