// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class grabber extends SubsystemBase {
  DoubleSolenoid s_grabSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.id_sGrabSolenoidF, Constants.id_sGrabSolenoidR);
  DoubleSolenoid l_grabSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.id_lGrabSolenoidF, Constants.id_lGrabSolenoidR);


public void grabberToggle(String Solenoid, Value Value) {
  
  
}
}



