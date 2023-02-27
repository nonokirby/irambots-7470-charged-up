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
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.commands.driveManual;


public class driveTrain extends SubsystemBase {

  WPI_VictorSPX driveTrainLeftMotorA = new WPI_VictorSPX(Constants.id_leftMotor_A);
  WPI_VictorSPX driveTrainLeftMotorB = new WPI_VictorSPX(Constants.id_leftMotor_B);

  MotorControllerGroup driveTrainLeftMotors = new MotorControllerGroup(driveTrainLeftMotorA, driveTrainLeftMotorB);

  WPI_VictorSPX driveTrainRightMotorA = new WPI_VictorSPX(Constants.id_rightMotor_A);
  WPI_VictorSPX driveTrainRightMotorB = new WPI_VictorSPX(Constants.id_rightMotor_B);

  MotorControllerGroup driveTrainRightMotors = new MotorControllerGroup(driveTrainRightMotorA, driveTrainRightMotorB);

  DifferentialDrive DifferentialDrive = new DifferentialDrive(driveTrainLeftMotors, driveTrainRightMotors);

  private final WPI_VictorSPX sideMotorVictorSPX = new WPI_VictorSPX(Constants.id_sideMotor);

  public void initDefaultCommand(){
    setDefaultCommand(new driveManual());
  }

  public void stop(){
    DifferentialDrive.stopMotor();
  }

  public void driveArcade(double speed, double rotation){
    DifferentialDrive.arcadeDrive(speed, rotation);
  }

  public void sideSwipe(double speed){
    sideMotorVictorSPX.set(speed);
  }
}







