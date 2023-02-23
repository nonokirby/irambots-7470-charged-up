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
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.commands.driveManual;

//@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

public class driveTrain extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  
  //private final WPI_VictorSPX leftMotorA = Constants.driveTrainLeftMotorA;
  //private final WPI_VictorSPX leftMotorB = Constants.driveTrainLeftMotorB;


  private final MotorControllerGroup leftMotors = Constants.driveTrainLeftMotors;

 // private final WPI_VictorSPX rightMotorA = Constants.driveTrainRightMotorA;
 // private final WPI_VictorSPX rightMotorB = Constants.driveTrainRightMotorB;


  private final MotorControllerGroup rightMotors = Constants.driveTrainRightMotors;

  
  private final DifferentialDrive differentialDrive = Constants.driveTrainDifferentialDrive;
public Object driveArcade;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    Robot.driveTrain.setDefaultCommand(new driveManual());
  }
  public MotorControllerGroup getLeftMotors() {
    return leftMotors;
  }
  public MotorControllerGroup getRightMotors(){
    return rightMotors;
  }
  /*public void driveTank(final double left, final double right) {
    differentialDrive.tankDrive(left, right);
  }*/
  
  /*public void driveArcade(final double speed, final double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);
  }*/

   
 

  public void stop() {
    differentialDrive.stopMotor();
    
  }

public static Object getInstance() {

  
	return null;
}



 public void driveArcade(double speed, double rotation) {
}
public void driveCurvature(double speed, double rotation, boolean quickTurn) {
  differentialDrive.curvatureDrive(speed, rotation, quickTurn);
}

public void tankDrive(double left, double right) {
  differentialDrive.tankDrive(left, right);
}

}







