// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class grabber extends SubsystemBase {
  DoubleSolenoid grabSolenoid = Constants.grabSolenoid;


public void grabDown() {
  grabSolenoid.set(Value.kReverse);
  grabSolenoid.set(Value.kForward);
  
}
public void grabUp() {
  grabSolenoid.set(Value.kForward);
  grabSolenoid.set(Value.kReverse);
  
}  
}



