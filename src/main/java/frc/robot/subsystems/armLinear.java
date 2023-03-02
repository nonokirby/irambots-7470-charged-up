/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;



public class armLinear extends SubsystemBase {

    private static TalonSRX armMotorTalonSRX;
    
    public armLinear(){
      armMotorTalonSRX = new WPI_TalonSRX(Constants.id_armMotor);
      armMotorTalonSRX.configFactoryDefault();
      armMotorTalonSRX.setNeutralMode(NeutralMode.Brake);
      armMotorTalonSRX.set(ControlMode.PercentOutput, 0);
    }

    public void mw_armWinch(double speed) {
        armMotorTalonSRX.set(ControlMode.PercentOutput, speed * Constants.lm_armMotorSpeed);
    }


    public void armWinch(double speed) {

        if(speed < 0 && getArmEncoder() <= 2500){
          armMotorTalonSRX.set(ControlMode.PercentOutput, speed * Constants.lm_armMotorSpeed);
        } else if(speed > 0 && getArmEncoder() >= -28512){
          armMotorTalonSRX.set(ControlMode.PercentOutput, speed * Constants.lm_armMotorSpeed);
        }
          else {
              armMotorTalonSRX.set(ControlMode.PercentOutput, 0);
        }
    }
    
    public static void resetEncoders() {
        armMotorTalonSRX.setSelectedSensorPosition(0);
    }

    public static double getArmEncoder() {
        return armMotorTalonSRX.getSelectedSensorPosition();
    }
    
    // -29398.000000
    // 55296
    public void p_armLength(double length){
      double error = -5000;
      while (error > 5 || error < -5){
  
      if (error < 0){
        armMotorTalonSRX.set(ControlMode.PercentOutput, 0.5);
        armMotorTalonSRX.setSelectedSensorPosition(getArmEncoder()+0.5);
      }
      if (error > 0){
        armMotorTalonSRX.set(ControlMode.PercentOutput, -0.5);
        armMotorTalonSRX.setSelectedSensorPosition(getArmEncoder()-0.5);
      }

      }
    }

    @Override
    public void periodic(){
      SmartDashboard.putNumber("linear encoder", getArmEncoder());
    }
}   