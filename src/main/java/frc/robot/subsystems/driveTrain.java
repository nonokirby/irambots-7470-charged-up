/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.commands.driveManual;
import edu.wpi.first.wpilibj.SerialPort;


public class driveTrain extends SubsystemBase {

  WPI_VictorSPX driveTrainLeftMotorA = new WPI_VictorSPX(0);
  WPI_VictorSPX driveTrainLeftMotorB = new WPI_VictorSPX(1);

  MotorControllerGroup driveTrainLeftMotors = new MotorControllerGroup(driveTrainLeftMotorA, driveTrainLeftMotorB);

  WPI_VictorSPX driveTrainRightMotorA = new WPI_VictorSPX(2);
  WPI_VictorSPX driveTrainRightMotorB = new WPI_VictorSPX(3);

  MotorControllerGroup driveTrainRightMotors = new MotorControllerGroup(driveTrainRightMotorA, driveTrainRightMotorB);

  DifferentialDrive DifferentialDrive = new DifferentialDrive(driveTrainLeftMotors, driveTrainRightMotors);

  private final WPI_VictorSPX sideMotorVictorSPX = new WPI_VictorSPX(Constants.id_sideMotor);
  AHRS gyro = new AHRS(SerialPort.Port.kMXP);

  public void initDefaultCommand(){
    setDefaultCommand(new driveManual());
  }

  public void stop(){
    DifferentialDrive.stopMotor();
  }

  public void driveCurvature(double speed, double rotation, boolean quickturn){
    DifferentialDrive.curvatureDrive(speed, rotation, quickturn);
  }

  public void sideSwipe(double speed){
    sideMotorVictorSPX.set(speed);
  }
}







