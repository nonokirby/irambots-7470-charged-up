/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
//import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.driveManual;

//@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

public class driveTrain extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  
  //private final WPI_VictorSPX leftMotorA = Constants.driveTrainLeftMotorA;
  //private final WPI_VictorSPX leftMotorB = Constants.driveTrainLeftMotorB;


  // For Victor SPX
  WPI_VictorSPX driveTrainLeftMotorA = new WPI_VictorSPX(2);
  WPI_VictorSPX driveTrainLeftMotorB = new WPI_VictorSPX(3);


//Define what motors are part of the 'LEFT' Speed Controller Group  
MotorControllerGroup driveTrainLeftMotors = new MotorControllerGroup(driveTrainLeftMotorA, driveTrainLeftMotorB/*, driveTrainLeftMotorC*/);


//For Victor SPX
WPI_VictorSPX driveTrainRightMotorA = new WPI_VictorSPX(0);
WPI_VictorSPX driveTrainRightMotorB = new WPI_VictorSPX(1);

// Define the ports the 'RIGHT' Motor Controllers are Connected to the RoboRIO (CAN or PWM)  If CAN additional steps are required to set address port on Motor Controller

//Define what motors are part of the 'RIGHT' Speed Controller Group  
MotorControllerGroup driveTrainRightMotors = new MotorControllerGroup(driveTrainRightMotorA, driveTrainRightMotorB/*, driveTrainRightMotorC*/);

//Define what Speed Controller Groups are part of the Differential Drive
DifferentialDrive DifferentialDrive = new DifferentialDrive(driveTrainLeftMotors, driveTrainRightMotors);
public Object driveArcade;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    setDefaultCommand(new driveManual());
  }
  public MotorControllerGroup getLeftMotors() {
    return driveTrainLeftMotors;
  }
  public MotorControllerGroup getRightMotors(){
    return driveTrainRightMotors;
  }
  /*public void driveTank(final double left, final double right) {
    differentialDrive.tankDrive(left, right);
  }*/
  
  /*public void driveArcade(final double speed, final double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);
  }*/

   
 

  public void stop() {
    DifferentialDrive.stopMotor();
    
  }

public static Object getInstance() {

  
	return null;
}



 public void driveArcade(double speed, double rotation) {
}
public void driveCurvature(double speed, double rotation, boolean quickTurn) {
  DifferentialDrive.curvatureDrive(speed, rotation, quickTurn);
}

public void tankDrive(double left, double right) {
  DifferentialDrive.tankDrive(left, right);
}

}







