// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.InstantCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class medGrab extends InstantCommand {

  public medGrab(/*String pos*/) {
    addRequirements(RobotContainer.grabber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void execute() {
    //String pos = "low";
/*    if (pos == "in"){
      RobotContainer.grabber.gMove(1.0);
    }
    if (pos == "out"){
      RobotContainer.grabber.gMove(-1.0);
    }
    if (pos == "stale"){
      RobotContainer.grabber.gMove(0.0);
    }
    if (pos == "hold"){
      RobotContainer.grabber.gMove(0.3);
    }
    */
    RobotContainer.grabber.gGrab();
    System.out.print("hello");
  }
@Override
public boolean isFinished() {
  return false;
}
@Override
public void end(boolean interrupted) {
  RobotContainer.grabber.gHold();
}
  }



