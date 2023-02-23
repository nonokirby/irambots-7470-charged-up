/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
//import java.util.concurrent.TimeUnit;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;
import frc.robot.commands.autonomous.DriveToPort;
import frc.robot.subsystems.*;

//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
@SuppressWarnings("unused") public class Robot extends TimedRobot {
  public final Joystick m_driver = new Joystick(1);
  public final Joystick m_arcade = new Joystick(0);
  public static driveTrain driveTrain;
  public static SequentialCommandGroup autonomousForward;
  // private static double autoStart;
  // What's the problem with autoStart?
  // nothing now, cant have a problem if it isnt a part of the running code
  //public static cellOutput cellOutput;
  //public static intakeCell intakeCell;
  public static armWest armWest;
  public static armEast armEast;
  public static hookEast hookEast;
  public static hookWest hookWest;
  //public static cargoVert cargoVert;
  //public static cellRoller cellRoller;
  public static armManual armManual;
  public static frc.robot.subsystems.armDirectional armDirectional;
  public static frc.robot.subsystems.hookDirectional hookDirectional;
  public static frc.robot.subsystems.grabber grabber;
  //public static Command cargoVert;
  //public static cellRoller2 cellRoller2;
  //public static cargo cargo;
  public static shooterManual shooterManual;
  public static shooter shooter;
  //public static putDown putDown;
  public static RobotContainer RobotContainer;
  public static arm arm;
  public static sideSwipe sideSwipe;
  public static Command m_autonomousCommand;
  public static DriveToPort DriveToPort;
  public static maxShooter maxShooter;
  public static grabUp grabUp;
  public static grabDown grabDown;
  //public static TurnAround turnAround;
  //public static auto180 auto180;
  public static Object wheelShooter;
  SendableChooser<CommandBase> m_chooser = new SendableChooser<>();
  public static rollerSpeed rollerSpeed = new rollerSpeed();
  
   
  



  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    
 

    new Thread(()-> {
      UsbCamera camera = CameraServer.startAutomaticCapture();
    }).start();
    // -31820.000000
    Constants.init();
    driveTrain = new driveTrain();
    shooter = new shooter();
    //cellRoller = new cellRoller();
    //cargo = new cargo();
   // cellRoller2 = new cellRoller2();
   grabber = new grabber();
   rollerSpeed = new rollerSpeed();
    arm = new arm();
    armDirectional = new armDirectional();
   hookDirectional = new hookDirectional();
    maxShooter = new maxShooter();
    RobotContainer = new RobotContainer();
    sideSwipe = new sideSwipe();

    
    // m_chooser.addDefault("Default Auto", new autonomous());
    // chooser.addObject("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    autonomousForward = new SequentialCommandGroup();
    /*Command driveToPort_ = new Command() {
      @Override
      protected void initialize() {
        setTimeout(5.0);
      }
      @Override
      protected void execute() {
        double time = Timer.getFPGATimestamp();
        double startTime = Timer.getMatchTime();
        /*if (time - startTime < 5.0) {
          Robot.driveTrain.driveCurvature(-Robot.oi.joy1.getRawAxis(3) * 0.3, Robot.oi.joy1.getRawAxis(0) * 0.3, true);
        } else {
          Robot.driveTrain.driveCurvature(Robot.oi.joy1.getRawAxis(3) * 0.0, Robot.oi.joy1.getRawAxis(0) * 0.0, false);
        }*//*
      }
      @Override
      protected boolean isFinished() {
        return true;
      }
    };*/

    /**Command auto180 = new Command() {
      @Override
      protected void initialize() {
        setTimeout(5.0);
        Constants.ahrs.getRawGyroZ();
        Constants.ahrs.reset();
      }
      @Override
      protected void execute() {
        //double time = Timer.getFPGATimestamp();
        //double startTime = Timer.getMatchTime();
        if (time - startTime < 0.5) {
          Robot.driveTrain.driveCurvature(Robot.oi.joy1.getRawAxis(3) * 0, Robot.oi.joy1.getRawAxis(0) * .6, true);
        } else {
          Robot.driveTrain.driveCurvature(Robot.oi.joy1.getRawAxis(3) * 0.0, Robot.oi.joy1.getRawAxis(0) * 0.0, false);
        }
      }
      
      @Override
      protected boolean isFinished() {
        return true;
      }
    };
    */
    // autonomousForward.addCommands(new Command());
    m_autonomousCommand = new DriveToPort();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    //SmartDashboard.putNumber("Arm Distance", Constants.armMotor.getSelectedSensorPosition());
  }
 
  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
    Robot.grabber.grabUp();

  }

  @Override
  public void disabledPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
     m_autonomousCommand = m_chooser.getSelected();
     //Constants.armMotor.setSelectedSensorPosition(0);
    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */

    

    // schedule the autonomous command (example)
    // Scheduler.getInstance().add(drive);
    //CommandScheduler.getInstance().add(new driveManual() {
      CommandScheduler.getInstance().schedule(new driveManual() {
        //CommandScheduler.getInstance().schedule(new DriveToPort() {
        //double timeElapsed;
    
      @Override
      public void initialize() {
        // driveTrain.tankDrive(-.6, .6);
        //Constants.shooterMotor.set(-0.7);
        //Constants.cargoMotor.set(0.7);
        
      }



      @Override
      public void execute() {
        double startTime = Timer.getMatchTime();
        //double time = Timer.getFPGATimestamp();
        if (startTime >= 26.0) {
           driveTrain.tankDrive(-0.4, 0.4);
          // Constants.shooterMotor.set(0);
           //Constants.cargoMotor.set(0);
        }
        else if (startTime >= 22.0 && startTime < 26)
        {
          driveTrain.tankDrive(-0.4,-0.4);
          //Constants.sideMotor.set(0.6);
        }
        else if (startTime >= 18.0)
        {
          driveTrain.tankDrive(0.4,-0.4);
        }
        else if (startTime >= 14.0 && startTime < 18)
        {
          driveTrain.tankDrive(0.4,0.4);
        }
        else {
          driveTrain.tankDrive(-0.0,0.0);
        }
        
         
         
        
  
    };
  
      
        
        
        //timeElapsed = Timer.getFPGATimestamp();
        //while (timeElapsed < 1 ||timeElapsed > 10){
        //  driveTrain.tankDrive(+0.5, -0.5);
          
        //;
        

        @Override
        public boolean isFinished() {

          double startTime = Timer.getMatchTime();
          if (startTime == 9) {
            //driveTrain.tankDrive(0.0, 0.0);
            //shooter.stop();
            return true;
          }
          else {
            return false;
          }
         
        }
      });
    }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
    
  }

  @Override
  public void teleopInit() {
   //driveTrain.tankDrive(0.0, 0.0);
    //Constants.shooterMotor.set(0.0);
    //Constants.cargoMotor.set(0.0);
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
  } 

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    //CommandScheduler.getInstance().run();
    double speed = Robot.RobotContainer.m_arcade.getRawAxis(1);
    double rotation = Robot.RobotContainer.m_arcade.getRawAxis(2);
   //driveTrain.tankDrive(-m_driver.getY(),m_driver.getY());
   driveTrain.tankDrive(-m_arcade.getRawAxis(2) + m_arcade.getRawAxis(1), -m_arcade.getRawAxis(1) + -m_arcade.getRawAxis(2));
   Constants.sideMotor.set(-Robot.RobotContainer.m_arcade.getRawAxis(0));
   // read PID coefficients from SmartDashboard
    double p = SmartDashboard.getNumber("P Gain", 0);
    double i = SmartDashboard.getNumber("I Gain", 0);
    double d = SmartDashboard.getNumber("D Gain", 0);
    double iz = SmartDashboard.getNumber("I Zone", 0);
    double ff = SmartDashboard.getNumber("Feed Forward", 0);
    double max = SmartDashboard.getNumber("Max Output", 0);
    double min = SmartDashboard.getNumber("Min Output", 0);
    double rotations = SmartDashboard.getNumber("Set Rotations", 0);

    // if PID coefficients on SmartDashboard have changed, write new values to controller
   /*   if((p != kP)) { m_pidController.setP(p); kP = p; }
    if((i != kI)) { m_pidController.setI(i); kI = i; }
    if((d != kD)) { m_pidController.setD(d); kD = d; }
    if((iz != kIz)) { m_pidController.setIZone(iz); kIz = iz; }
    if((ff != kFF)) { m_pidController.setFF(ff); kFF = ff; }
    if((max != kMaxOutput) || (min != kMinOutput)) { 
      m_pidController.setOutputRange(min, max); 
      kMinOutput = min; kMaxOutput = max; 
    }

    /**
     * PIDController objects are commanded to a set point using the 
     * SetReference() method.
     * 
     * The first parameter is the value of the set point, whose units vary
     * depending on the control type set in the second parameter.
     * 
     * The second parameter is the control type can be set to one of four 
     * parameters:
     *  com.revrobotics.CANSparkMax.ControlType.kDutyCycle
     *  com.revrobotics.CANSparkMax.ControlType.kPosition
     *  com.revrobotics.CANSparkMax.ControlType.kVelocity
     *  com.revrobotics.CANSparkMax.ControlType.kVoltage
     */
  //  m_pidController.setReference(rotations, CANSparkMax.ControlType.kPosition);
    
 

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    Robot.grabber.grabDown();
    Robot.grabber.grabUp();

  }

  public void SequentialCommandGroup() {

  }

}

