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
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;



public class armLinear extends SubsystemBase {

    private static TalonSRX directionalMotorTalonSRX;
    private static TalonSRX armMotorTalonSRX;
    
    public armLinear(){

      armMotorTalonSRX = new TalonSRX(Constants.id_armMotor);
      armMotorTalonSRX.configFactoryDefault();
      armMotorTalonSRX.setNeutralMode(NeutralMode.Brake);
      armMotorTalonSRX.set(ControlMode.PercentOutput, 0);
      
      directionalMotorTalonSRX = new TalonSRX(Constants.id_directionalMotor);
      directionalMotorTalonSRX.configFactoryDefault();
      directionalMotorTalonSRX.setNeutralMode(NeutralMode.Brake);
      directionalMotorTalonSRX.set(ControlMode.PercentOutput, 0);
    }

    public void mw_armWinch(double speed) {
        armMotorTalonSRX.set(ControlMode.PercentOutput, speed * Constants.lm_armMotorSpeed);
    }

    public void armMove(double speed) {
        directionalMotorTalonSRX.set(ControlMode.PercentOutput, speed * Constants.lm_directionalMotorSpeed);
    }

    public void armWinch(double speed) {

        if(speed < 0 && getLinEncoder() <= 2500){
          armMotorTalonSRX.set(ControlMode.PercentOutput, speed * Constants.lm_armMotorSpeed);
        } else if(speed > 0 && getLinEncoder() >= -28512){
          armMotorTalonSRX.set(ControlMode.PercentOutput, speed * Constants.lm_armMotorSpeed);
        }
          else {
              armMotorTalonSRX.set(ControlMode.PercentOutput, 0);
        }
    }
    
    public static void resetEncoders() {
        armMotorTalonSRX.setSelectedSensorPosition(0);
        directionalMotorTalonSRX.setSelectedSensorPosition(0);
    }

    public double getLinEncoder() {
        return armMotorTalonSRX.getSelectedSensorPosition();
    }

    public double getDirEncoder() {
        return directionalMotorTalonSRX.getSelectedSensorPosition();
    }
    
    // -29398.000000
    // 55296
    public void p_armLength(double length){
      armMotorTalonSRX.set(ControlMode.Position, length);
    }
    public void p_armAngle(double angle){
      directionalMotorTalonSRX.set(ControlMode.Position, angle);
    }
}   