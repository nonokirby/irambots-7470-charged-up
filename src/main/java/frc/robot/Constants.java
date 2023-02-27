/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj.SerialPort;

/**
 * The Constants is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Constants {
 
  public static AHRS ahrs;

  // Define device Id variables
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
  
  public static int pos_high_armLength;
  public static int pos_mid_armLength;
  public static int pos_low_armLength;
  public static int pos_stow_armLength;

  public static int pos_high_armAngle;
  public static int pos_mid_armAngle;
  public static int pos_low_armAngle;
  public static int pos_stow_armAngle;

  public static void init() {
    //define device Id
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
    
    //1024 per full revolution
    pos_high_armLength = 0;
    pos_mid_armLength = 0;
    pos_low_armLength = 0;
    pos_stow_armLength = 0;
    pos_high_armAngle = 0;
    pos_mid_armAngle = 0;
    pos_low_armAngle = 0;
    pos_stow_armAngle = 0;

  }
}