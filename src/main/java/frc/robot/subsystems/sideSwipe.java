// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.




package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class sideSwipe extends SubsystemBase {

  private final WPI_VictorSPX sideMotorVictorSPX = Constants.sideMotor;

public sideSwipe() {
  }

  
  
  
  public void swipe() {
    sideMotorVictorSPX.set(Robot.RobotContainer.m_arcade.getRawAxis(0));

}
public void stop() {
  sideMotorVictorSPX.set(0.0);
}
}
