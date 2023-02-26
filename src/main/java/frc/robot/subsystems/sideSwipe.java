// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.




package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class sideSwipe extends SubsystemBase {

  private final WPI_VictorSPX sideMotorVictorSPX = new WPI_VictorSPX(Constants.id_sideMotor);
public sideSwipe() {
  }

  public void swipe(double speed) {
    sideMotorVictorSPX.set(speed);
  }
  public void stop() {
    sideMotorVictorSPX.set(0.0);
  }
}
