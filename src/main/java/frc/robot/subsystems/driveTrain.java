/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;


public class driveTrain extends SubsystemBase {

  WPI_TalonSRX lma = new WPI_TalonSRX(0);
  WPI_VictorSPX lmb = new WPI_VictorSPX(1);

  MotorControllerGroup driveTrainLeftMotors = new MotorControllerGroup(lma, lmb);

  WPI_TalonSRX rma = new WPI_TalonSRX(2);
  WPI_VictorSPX rmb = new WPI_VictorSPX(3);

  MotorControllerGroup driveTrainRightMotors = new MotorControllerGroup(rma, rmb);

  DifferentialDrive DifferentialDrive = new DifferentialDrive(driveTrainLeftMotors, driveTrainRightMotors);

  public static Encoder r_driveEncoder = new Encoder(0, 1);
  public static Encoder l_driveEncoder = new Encoder(2, 3);




  private final WPI_VictorSPX sideMotorVictorSPX = new WPI_VictorSPX(Constants.id_sideMotor);
  AHRS gyro = new AHRS(SerialPort.Port.kMXP);

  public void initialize(){
    		/* setup some followers */
		lmb.configFactoryDefault();
		lmb.follow(lma);


		/* Factory default hardware to prevent unexpected behavior */
		lma.configFactoryDefault();

		/* Configure Sensor Source for Pirmary PID */
		lma.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.leftMotorConfig.kPIDLoopIdx,
				Constants.leftMotorConfig.kTimeoutMs);

		/* set deadband to super small 0.001 (0.1 %).
			The default deadband is 0.04 (4 %) */
		lma.configNeutralDeadband(0.001, Constants.leftMotorConfig.kTimeoutMs);

		/**
		 * Configure Talon SRX Output and Sensor direction accordingly Invert Motor to
		 * have green LEDs when driving Talon Forward / Requesting Postiive Output Phase
		 * sensor to have positive increment when driving Talon Forward (Green LED)
		 */
		lma.setSensorPhase(true);
		lma.setInverted(false);

		/* Set relevant frame periods to be at least as fast as periodic rate */
		lma.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.leftMotorConfig.kTimeoutMs);
		lma.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.leftMotorConfig.kTimeoutMs);

		/* Set the peak and nominal outputs */
		lma.configNominalOutputForward(0, Constants.leftMotorConfig.kTimeoutMs);
		lma.configNominalOutputReverse(0, Constants.leftMotorConfig.kTimeoutMs);
		lma.configPeakOutputForward(1, Constants.leftMotorConfig.kTimeoutMs);
		lma.configPeakOutputReverse(-1, Constants.leftMotorConfig.kTimeoutMs);

		/* Set Motion Magic gains in slot0 - see documentation */
		lma.selectProfileSlot(Constants.leftMotorConfig.kSlotIdx, Constants.leftMotorConfig.kPIDLoopIdx);
		lma.config_kF(Constants.leftMotorConfig.kSlotIdx, Constants.leftMotorConfig.kGains.kF, Constants.leftMotorConfig.kTimeoutMs);
		lma.config_kP(Constants.leftMotorConfig.kSlotIdx, Constants.leftMotorConfig.kGains.kP, Constants.leftMotorConfig.kTimeoutMs);
		lma.config_kI(Constants.leftMotorConfig.kSlotIdx, Constants.leftMotorConfig.kGains.kI, Constants.leftMotorConfig.kTimeoutMs);
		lma.config_kD(Constants.leftMotorConfig.kSlotIdx, Constants.leftMotorConfig.kGains.kD, Constants.leftMotorConfig.kTimeoutMs);

		/* Set acceleration and vcruise velocity - see documentation */
		lma.configMotionCruiseVelocity(3000, Constants.leftMotorConfig.kTimeoutMs);
		lma.configMotionAcceleration(3000, Constants.leftMotorConfig.kTimeoutMs);

		/* Zero the sensor once on robot boot up */
		lma.setSelectedSensorPosition(0, Constants.leftMotorConfig.kPIDLoopIdx, Constants.leftMotorConfig.kTimeoutMs);

    rmb.configFactoryDefault();
		rmb.follow(rma);


		/* Factory default hardware to prevent unexpected behavior */
		rma.configFactoryDefault();

		/* Configure Sensor Source for Pirmary PID */
		rma.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,Constants.rightMotorConfig.kPIDLoopIdx,
				Constants.rightMotorConfig.kTimeoutMs);

		/* set deadband to super small 0.001 (0.1 %).
			The default deadband is 0.04 (4 %) */
		rma.configNeutralDeadband(0.001,Constants.rightMotorConfig.kTimeoutMs);

		/**
		 * Configure Talon SRX Output and Sensor direction accordingly Invert Motor to
		 * have green LEDs when driving Talon Forward / Requesting Postiive Output Phase
		 * sensor to have positive increment when driving Talon Forward (Green LED)
		 */
		rma.setSensorPhase(true);
		rma.setInverted(false);

		/* Set relevant frame periods to be at least as fast as periodic rate */
		rma.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10,Constants.rightMotorConfig.kTimeoutMs);
		rma.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10,Constants.rightMotorConfig.kTimeoutMs);

		/* Set the peak and nominal outputs */
		rma.configNominalOutputForward(0,Constants.rightMotorConfig.kTimeoutMs);
		rma.configNominalOutputReverse(0,Constants.rightMotorConfig.kTimeoutMs);
		rma.configPeakOutputForward(1,Constants.rightMotorConfig.kTimeoutMs);
		rma.configPeakOutputReverse(-1,Constants.rightMotorConfig.kTimeoutMs);

		/* Set Motion Magic gains in slot0 - see documentation */
		rma.selectProfileSlot(Constants.rightMotorConfig.kSlotIdx,Constants.rightMotorConfig.kPIDLoopIdx);
		rma.config_kF(Constants.rightMotorConfig.kSlotIdx,Constants.rightMotorConfig.kGains.kF,Constants.rightMotorConfig.kTimeoutMs);
		rma.config_kP(Constants.rightMotorConfig.kSlotIdx,Constants.rightMotorConfig.kGains.kP,Constants.rightMotorConfig.kTimeoutMs);
		rma.config_kI(Constants.rightMotorConfig.kSlotIdx,Constants.rightMotorConfig.kGains.kI,Constants.rightMotorConfig.kTimeoutMs);
		rma.config_kD(Constants.rightMotorConfig.kSlotIdx,Constants.rightMotorConfig.kGains.kD,Constants.rightMotorConfig.kTimeoutMs);

		/* Set acceleration and vcruise velocity - see documentation */
		rma.configMotionCruiseVelocity(3000,Constants.rightMotorConfig.kTimeoutMs);
		rma.configMotionAcceleration(3000,Constants.rightMotorConfig.kTimeoutMs);

		/* Zero the sensor once on robot boot up */
		rma.setSelectedSensorPosition(0,Constants.rightMotorConfig.kPIDLoopIdx,Constants.rightMotorConfig.kTimeoutMs);
  }

  public void stop(){
    DifferentialDrive.stopMotor();
  }

  public void driveArcade(double speed, double rotation){
    DifferentialDrive.arcadeDrive(speed, rotation);
  }

  public void r_motionMagic(double position, String motor){
    rma.set(ControlMode.MotionMagic, position);
  }
  public void l_motionMagic(double position, String motor){
    lma.set(ControlMode.MotionMagic, position);
  }
  public void sideSwipe(double speed){
    sideMotorVictorSPX.set(speed);
  }

  public double l_getEncoder(){
    return l_driveEncoder.getRaw();
  }
  
  public static double r_getEncoder(){
    return r_driveEncoder.getRaw();
  }

  public static void resetEncoders(){
    r_driveEncoder.reset();
    l_driveEncoder.reset();
  }
  @Override
  public void periodic(){
  }
}







