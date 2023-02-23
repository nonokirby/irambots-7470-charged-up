// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj.SerialPort;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static AHRS ahrs;

    //Define Left Motors
    public static WPI_VictorSPX driveTrainLeftMotorA;
    public static WPI_VictorSPX driveTrainLeftMotorB;
  
    //Define Right Motors
    public static WPI_VictorSPX driveTrainRightMotorA;
    public static WPI_VictorSPX driveTrainRightMotorB;
   
    //Define Middle Motors
    public static WPI_VictorSPX driveTrainMiddleMotorA;
    public static WPI_VictorSPX driveTrainMiddleMotorB;
    
    //Define Speed Controller Groups
    public static MotorControllerGroup driveTrainLeftMotors;
    public static MotorControllerGroup driveTrainRightMotors;
    public static MotorControllerGroup driveTrainMiddleMotors;
   
    //Define Differential Drive
    public static DifferentialDrive driveTrainDifferentialDrive;

    public static void init() {

    ahrs = new AHRS(SerialPort.Port.kMXP);
    

    //Give the motors their ID
    driveTrainRightMotorA = new WPI_VictorSPX(1);
    driveTrainRightMotorB = new WPI_VictorSPX(2);
    driveTrainLeftMotorA = new WPI_VictorSPX(3);
    driveTrainLeftMotorB = new WPI_VictorSPX(4);
    driveTrainMiddleMotorA = new WPI_VictorSPX(5);
    driveTrainMiddleMotorB = new WPI_VictorSPX(6);
   
    //Define what motors are part of their respective Speed Controller Group  
    driveTrainLeftMotors = new MotorControllerGroup(driveTrainLeftMotorA, driveTrainLeftMotorB/*, driveTrainLeftMotorC*/);
    driveTrainRightMotors = new MotorControllerGroup(driveTrainRightMotorA, driveTrainRightMotorB/*, driveTrainRightMotorC*/);
    driveTrainMiddleMotors = new MotorControllerGroup(driveTrainMiddleMotorA, driveTrainMiddleMotorB);
   
    //Define what Speed Controller Groups are part of the Differential Drive
    driveTrainDifferentialDrive = new DifferentialDrive(driveTrainLeftMotors, driveTrainRightMotors);

    //Define Options for Differential Drive
    driveTrainDifferentialDrive.setSafetyEnabled(false);
    driveTrainDifferentialDrive.setExpiration(0.1);
    driveTrainDifferentialDrive.setMaxOutput(0.7);  

}}