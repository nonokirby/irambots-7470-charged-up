// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class grabber extends SubsystemBase {
  WPI_TalonSRX grabberMotor = new WPI_TalonSRX(Constants.id_grabberMotor);

public void gIntake() {
  grabberMotor.set(1.0);
}
public void gRelease() {
  grabberMotor.set(-1.0);
}
public void cRelease() {
  grabberMotor.set(-0.2);
}
public void gStop(){
  grabberMotor.set(0);
}
public void gHold(){
  grabberMotor.set(0.15);
}
@Override
public void periodic(){
}
}



