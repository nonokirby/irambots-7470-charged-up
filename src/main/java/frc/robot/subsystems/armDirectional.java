/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;

public class armDirectional extends SubsystemBase {

  private final WPI_VictorSPX directionalMotorVictorSPX = Constants.directionalMotor;
    public armDirectional() {
  }
  public void armMove(angle)  {
    directionalMotorVictorSPX.set(angle);
  }
}