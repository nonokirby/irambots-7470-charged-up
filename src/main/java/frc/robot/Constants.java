/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import java.net.InterfaceAddress;
import java.util.Collection;
import java.util.List;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The Constants is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Constants {
 
  public static AHRS ahrs;

  // Define 'LEFT' Motors

  public static WPI_VictorSPX driveTrainLeftMotorA;
  public static WPI_VictorSPX driveTrainLeftMotorB;

  // Define Speed Controller Group for 'LEFT Motors

  public static MotorControllerGroup driveTrainLeftMotors;

  // Define 'RIGHT' Motors

  public static WPI_VictorSPX driveTrainRightMotorA;
  public static WPI_VictorSPX driveTrainRightMotorB;

  // Define Speed Controller Group for 'RIGHT' Motors

  public static MotorControllerGroup driveTrainRightMotors;

  // Define Speed Controller Group for 'SzIDE' Motors

  public static MotorControllerGroup driveTrainSideMotors;

  // Define Differential Drive

  public static DifferentialDrive driveTrainDifferentialDrive;
  // Define Rest of the motors
  public static int id_leftMotor_A;
  public static int id_leftMotor_B;
  public static int id_rightMotor_A;
  public static int id_rightMotor_B;
  public static int id_sideMotor;
  public static int id_directionalMotor;
  public static int id_armMotor;
  public static int id_shiftSolenoid;
  public static int id_sGrabSolenoidF;
  public static int id_sGrabSolenoidR;
  public static int id_lGrabSolenoidF;
  public static int id_lGrabSolenoidR;

  public static void init() {
    id_leftMotor_A        = 0;
    id_leftMotor_B        = 1;
    id_rightMotor_A       = 2;
    id_rightMotor_B       = 3;
    id_sideMotor          = 4; 
    id_directionalMotor   = 13;
    id_armMotor           = 14;
    id_shiftSolenoid      = 4;
    id_sGrabSolenoidF     = 6;
    id_sGrabSolenoidR     = 7;
    id_lGrabSolenoidF     = 0;
    id_lGrabSolenoidR     = 1;


    ahrs = new AHRS(SerialPort.Port.kMXP);








  

  id_directionalMotor = 10;

//Define Options for Differential Drive
  driveTrainDifferentialDrive.setSafetyEnabled(false);
  driveTrainDifferentialDrive.setExpiration(0.1);
  driveTrainDifferentialDrive.setMaxOutput(1);  
 //You can set the power output by changing (1.0 is most power and .1 is much less power)
// this is where you can change the speed for the drivetrain


/**
 * This is a demo program providing a real-time display of navX
 * MXP values.
 *
 * In the operatorControl() method, all data from the navX sensor is retrieved
 * and output to the SmartDashboard.
 *
 * The output data values include:
 *
 * - Yaw, Pitch and Roll angles
 * - Compass Heading and 9-Axis Fused Heading (requires Magnetometer calibration)
 * - Linear Acceleration Data
 * - Motion Indicators
 * - Estimated Velocity and Displacement
 * - Quaternion Data
 * - Raw Gyro, Accelerometer and Magnetometer Data
 *
 * As well, Board Information is also retrieved; this can be useful for debugging
 * connectivity issues after initial installation of the navX MXP sensor.
 *
 */

   /* Display 6-axis Processed Angle Data                                      */
 SmartDashboard.putBoolean(  "IMU_Connected",        Constants.ahrs.isConnected());
 SmartDashboard.putBoolean(  "IMU_IsCalibrating",    Constants.ahrs.isCalibrating());
 SmartDashboard.putNumber(   "IMU_Yaw",              Constants.ahrs.getYaw());
 SmartDashboard.putNumber(   "IMU_Pitch",            Constants.ahrs.getPitch());
 SmartDashboard.putNumber(   "IMU_Roll",             Constants.ahrs.getRoll());
 
 /* Display tilt-corrected, Magnetometer-based heading (requires             */
 /* magnetometer calibration to be useful)                                   */
 
 SmartDashboard.putNumber(   "IMU_CompassHeading",   Constants.ahrs.getCompassHeading());
 
 /* Display 9-axis Heading (requires magnetometer calibration to be useful)  */
 SmartDashboard.putNumber(   "IMU_FusedHeading",     Constants.ahrs.getFusedHeading());

 /* These functions are compatible w/the WPI Gyro Class, providing a simple  */
 /* path for upgrading from the Kit-of-Parts gyro to the navx MXP            */
 
 SmartDashboard.putNumber(   "IMU_TotalYaw",         Constants.ahrs.getAngle());
 SmartDashboard.putNumber(   "IMU_YawRateDPS",       Constants.ahrs.getRate());

 /* Display Processed Acceleration Data (Linear Acceleration, Motion Detect) */
 
 SmartDashboard.putNumber(   "IMU_Accel_X",          Constants.ahrs.getWorldLinearAccelX());
 SmartDashboard.putNumber(   "IMU_Accel_Y",          Constants.ahrs.getWorldLinearAccelY());
 SmartDashboard.putBoolean(  "IMU_IsMoving",         Constants.ahrs.isMoving());
 SmartDashboard.putBoolean(  "IMU_IsRotating",       Constants.ahrs.isRotating());

 /* Display estimates of velocity/displacement.  Note that these values are  */
 /* not expected to be accurate enough for estimating robot position on a    */
 /* FIRST FRC Robotics Field, due to accelerometer noise and the compounding */
 /* of these errors due to single (velocity) integration and especially      */
 /* double (displacement) integration.                                       */
 
 SmartDashboard.putNumber(   "Velocity_X",           Constants.ahrs.getVelocityX());
 SmartDashboard.putNumber(   "Velocity_Y",           Constants.ahrs.getVelocityY());
 SmartDashboard.putNumber(   "Displacement_X",       Constants.ahrs.getDisplacementX());
 SmartDashboard.putNumber(   "Displacement_Y",       Constants.ahrs.getDisplacementY());
 
 /* Display Raw Gyro/Accelerometer/Magnetometer Values                       */
 /* NOTE:  These values are not normally necessary, but are made available   */
 /* for advanced users.  Before using this data, please consider whether     */
 /* the processed data (see above) will suit your needs.                     */
 
 SmartDashboard.putNumber(   "RawGyro_X",            Constants.ahrs.getRawGyroX());
 SmartDashboard.putNumber(   "RawGyro_Y",            Constants.ahrs.getRawGyroY());
 SmartDashboard.putNumber(   "RawGyro_Z",            Constants.ahrs.getRawGyroZ());
 SmartDashboard.putNumber(   "RawAccel_X",           Constants.ahrs.getRawAccelX());
 SmartDashboard.putNumber(   "RawAccel_Y",           Constants.ahrs.getRawAccelY());
 SmartDashboard.putNumber(   "RawAccel_Z",           Constants.ahrs.getRawAccelZ());
 SmartDashboard.putNumber(   "RawMag_X",             Constants.ahrs.getRawMagX());
 SmartDashboard.putNumber(   "RawMag_Y",             Constants.ahrs.getRawMagY());
 SmartDashboard.putNumber(   "RawMag_Z",             Constants.ahrs.getRawMagZ());
 SmartDashboard.putNumber(   "IMU_Temp_C",           Constants.ahrs.getTempC());
 SmartDashboard.putNumber(   "IMU_Timestamp",        Constants.ahrs.getLastSensorTimestamp());
 
 /* Omnimount Yaw Axis Information                                           */
 /* For more info, see http://navx-mxp.kauailabs.com/installation/omnimount  */
 final AHRS.BoardYawAxis yaw_axis = Constants.ahrs.getBoardYawAxis();
 SmartDashboard.putString(   "YawAxisDirection",     yaw_axis.up ? "Up" : "Down" );
 SmartDashboard.putNumber(   "YawAxis",              yaw_axis.board_axis.getValue() );
 
 /* Sensor Board Information                                                 */
 SmartDashboard.putString(   "FirmwareVersion",      Constants.ahrs.getFirmwareVersion());
 
 /* Quaternion Data                                                          */
 /* Quaternions are fascinating, and are the most compact representation of  */
 /* orientation data.  All of the Yaw, Pitch and Roll Values can be derived  */
 /* from the Quaternions.  If interested in motion processing, knowledge of  */
 /* Quaternions is highly recommended.                                       */
 SmartDashboard.putNumber(   "QuaternionW",          Constants.ahrs.getQuaternionW());
 SmartDashboard.putNumber(   "QuaternionX",          Constants.ahrs.getQuaternionX());
 SmartDashboard.putNumber(   "QuaternionY",          Constants.ahrs.getQuaternionY());
 SmartDashboard.putNumber(   "QuaternionZ",          Constants.ahrs.getQuaternionZ());
 
 /* Connectivity Debugging Support                                           */
 SmartDashboard.putNumber(   "IMU_Byte_Count",       Constants.ahrs.getByteCount());
 SmartDashboard.putNumber(   "IMU_Update_Count",     Constants.ahrs.getUpdateCount());
 
 //Arm Encoder Distance
 //SmartDashboard.putNumber("Arm Distance", Constants.armMotor.getSelectedSensorPosition());
  }
}