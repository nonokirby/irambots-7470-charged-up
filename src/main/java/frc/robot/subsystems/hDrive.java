// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;


public class hDrive extends SubsystemBase {
  Solenoid  liftSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.id_liftSolenoid);
public void lift(boolean pos) {
 liftSolenoid.set(pos);
}

@Override
public void periodic(){
}
}



