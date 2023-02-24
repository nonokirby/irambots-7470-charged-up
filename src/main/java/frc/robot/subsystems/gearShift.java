// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import edu.wpi.first.wpilibj.DoubleSolenoid;

public class gearShift extends SubsystemBase {
  DoubleSolenoid shiftSolenoid = Constants.shiftSolenoid;

//True is high false is low
public void shift(boolean pos) {
 if (pos == true) {
  shiftSolenoid.set(Value.kReverse);
 }
 else {
 shiftSolenoid.set(Value.kForward);
 }
}
}



