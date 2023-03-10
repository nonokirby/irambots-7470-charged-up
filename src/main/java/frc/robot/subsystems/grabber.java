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
 public DoubleSolenoid s_grabSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.id_sGrabSolenoidF, Constants.id_sGrabSolenoidR);
  public DoubleSolenoid l_grabSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.id_lGrabSolenoidF, Constants.id_lGrabSolenoidR);


public void s_grabberToggle(Value Value) {
  s_grabSolenoid.set(Value);
}
public void l_grabberToggle(Value Value) {
  l_grabSolenoid.set(Value);
}
@Override
public void periodic(){
}
}



