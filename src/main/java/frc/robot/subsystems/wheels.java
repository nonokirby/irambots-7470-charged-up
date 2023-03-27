// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class wheels extends SubsystemBase {
  WPI_VictorSPX wheelsMotor = new WPI_VictorSPX(Constants.id_wheelsMotor);

public void Intake(Double speed) {
  wheelsMotor.set(speed);
}
public void outTake(Double speed) {
  wheelsMotor.set(speed);
}
@Override
public void periodic(){
}
}



