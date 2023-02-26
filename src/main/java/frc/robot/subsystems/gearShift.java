// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class gearShift extends SubsystemBase {
  Solenoid  shiftSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 4);
  

//True is high false is low
public void shift(boolean pos) {
 shiftSolenoid.set(pos);
}
}



