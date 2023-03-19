// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class hDrive extends SubsystemBase {
  Solenoid  liftSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.id_liftSolenoid);
  static String position = "low";
  

public void lift(boolean pos) {
 if (pos = true){
  position = "high";
 }
 else {
  position = "low";
 }
 liftSolenoid.set(pos);
}
public static String position(){
  return position;
}
@Override
public void periodic(){
  SmartDashboard.putString("gearshift", frc.robot.subsystems.gearShift.position());
}
}



