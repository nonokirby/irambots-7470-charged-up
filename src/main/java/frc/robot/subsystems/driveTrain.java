// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.commands.driveManual;
public class driveTrain extends SubsystemBase {
  private final MotorControllerGroup leftMotors = Constants.driveTrainLeftMotors;
  private final MotorControllerGroup rightMotors = Constants.driveTrainRightMotors;
  private final DifferentialDrive differentialDrive = Constants.driveTrainDifferentialDrive;


  public void initDefaultCommand() {
   setDefaultCommand(new driveManual(this));
  }
  public MotorControllerGroup getLeftMotors() {
    return leftMotors;
  }
  public MotorControllerGroup getRightMotors(){
    return rightMotors;
  }
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
  public boolean isFinished() {
      return false;
  }

  // Called once after isFinished returns true
  public void end(boolean interrupted) {
  }
  
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
