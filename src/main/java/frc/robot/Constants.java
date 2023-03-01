/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.kauailabs.navx.frc.*;


/**
 * The Constants is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class Constants {
 
  public static AHRS ahrs;

  //define device Id
  public static int id_leftMotor_A        = 0;
  public static int id_leftMotor_B        = 1;
  public static int id_rightMotor_A       = 2;
  public static int id_rightMotor_B       = 3;
  public static int id_sideMotor          = 4; 
  public static int id_directionalMotor   = 13;
  public static int id_armMotor           = 14;
  public static int id_shiftSolenoid      = 4;
  public static int id_sGrabSolenoidF     = 6;
  public static int id_sGrabSolenoidR     = 7;
  public static int id_lGrabSolenoidF     = 1;
  public static int id_lGrabSolenoidR     = 0;

  //1024 per full revolution
  public static int pos_high_armLength    = 4000;
  public static int pos_mid_armLength     = 3000;
  public static int pos_low_armLength     = 2000;
  public static int pos_stow_armLength    = 1000;
  public static int pos_high_armAngle     = 400;
  public static int pos_mid_armAngle      = 300;
  public static int pos_low_armAngle      = 200;
  public static int pos_stow_armAngle     = 100;

  public static double lm_driveTrainSpeed       = 1;
  public static double lm_driveTrainRotation    = 1;
  public static double lm_driveTrainSide        = 1;
  public static double lm_directionalMotorSpeed = 1;
  public static double lm_armMotorSpeed         = 1;


  public static int ax_driveTrainSpeed    = 2;
  public static int ax_driveTrainRotation = 1;
  public static int ax_driveTrainSwipe    = 0;
  public static int ax_gearShift          = 3;
}