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
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.math.controller.PIDController;

@SuppressWarnings("unused")
public class armDirectional extends SubsystemBase {

    private static TalonSRX directionalMotorTalonSRX;
    private PIDController linearPIDController;

    
    public armDirectional(){

     
      
      directionalMotorTalonSRX = new WPI_TalonSRX(Constants.id_directionalMotor);
      directionalMotorTalonSRX.configFactoryDefault();
      directionalMotorTalonSRX.setNeutralMode(NeutralMode.Brake);
      directionalMotorTalonSRX.set(ControlMode.PercentOutput, 0);
    }


    public void armMove(double speed) {
        directionalMotorTalonSRX.set(ControlMode.PercentOutput, speed * Constants.lm_directionalMotorSpeed);
        
    }

  

    
    
    public static void resetEncoders() {
        
        directionalMotorTalonSRX.setSelectedSensorPosition(0);
    }


    public static double getDirEncoder() {
        return directionalMotorTalonSRX.getSelectedSensorPosition();
    }
    
    // -29398.000000
    // 55296
    

    
    public void p_armAngle(double angle){
      directionalMotorTalonSRX.set(ControlMode.Position, angle);
    }
 
}   