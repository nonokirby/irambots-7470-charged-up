/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class arm extends SubsystemBase {
    

    private final TalonSRX armMotorTalonSRX = new TalonSRX(Constants.id_armMotor);
    private final TalonSRX directionalMotorTalonSRX = new TalonSRX(Constants.id_directionalMotor);

    public void mw_armWinch(double speed) {
        armMotorTalonSRX.set(ControlMode.PercentOutput,speed);
    }

    public void armMove(double speed) {
        directionalMotorTalonSRX.set(ControlMode.PercentOutput,speed);
    }

    public void armWinch(double speed) {

        if(speed < 0 && getArmEncoder() <= 2500){
          armMotorTalonSRX.set(ControlMode.PercentOutput, speed);
        } else if(speed > 0 && getArmEncoder() >= -28512){
          armMotorTalonSRX.set(ControlMode.PercentOutput, speed);
        }
          else {
              armMotorTalonSRX.set(ControlMode.PercentOutput, 0);
          }
    }
    
        public void resetEncoder() {
        armMotorTalonSRX.setSelectedSensorPosition(0);
    }

    public double getArmEncoder() {
        return armMotorTalonSRX.getSelectedSensorPosition();
    }
    // -29398.000000
    //positional points
    public void p_armLength(double length){
      armMotorTalonSRX.set(ControlMode.PercentOutput, 1)
    }
    public void p_armAngle(double angle){
      directionalMotorTalonSRX.set(ControlMode.PercentOutput, 1)
    }
}