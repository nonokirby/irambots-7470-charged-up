/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class arm extends SubsystemBase {

    private final WPI_VictorSPX armMotorVictorSPX = Constants.armMotor;

    public void mw_armWinch(double speed) {
        armMotorVictorSPX.set(speed);
    }

    public void armMove(speed) {
        directionalMotorVictorSPX.set(speed);
    }

    public void armWinch(double speed) {

        if(speed < 0 && getArmEncoder() <= 2500){
          armMotorVictorSPX.set(ControlMode.PercentOutput, speed);
        } else if(speed > 0 && getArmEncoder() >= -28512){
          armMotorVictorSPX.set(ControlMode.PercentOutput, speed);
        }
          else {
              armMotorVictorSPX.set(ControlMode.PercentOutput, 0);
          }
    }
    
        public void resetEncoder() {
        armMotorVictorSPX.setSelectedSensorPosition(0);
    }

    public double getArmEncoder() {
        return armMotorVictorSPX.getSelectedSensorPosition();
    }
    // -29398.000000
}