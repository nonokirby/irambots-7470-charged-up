// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class shifter extends CommandBase {
  
  public shifter () {
    // Use addRequirements() here to declare subsystem dependencies.
    //addRequirements(Robot.gearShift);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void execute() {
  double lever = Robot.RobotContainer.m_driver.getRawAxis(3);
  //High
  System.out.print("shifter");
  if (lever >= 0.5){
    Robot.gearShift.shift(false);
  }
  //Low
  else if (lever <= -0.5){
    Robot.gearShift.shift(true);
  }
 }

  public boolean isFinished(){
    return false;
  }
  // Make this return true when this Command no longer needs to run execute()
}

