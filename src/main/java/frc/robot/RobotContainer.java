 
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.commands.claw.*;
import frc.robot.commands.arm.*;
import frc.robot.commands.encoders.*;
import frc.robot.subsystems.*;

 public class RobotContainer {
    public final static grabber grabber = new grabber();
    public final static armDirectional armDirectional = new armDirectional();
    public final static driveTrain driveTrain = new driveTrain();
    public final static gearShift gearShift = new gearShift();
    public final static armLinear armLinear = new armLinear();
    

    public final static Joystick m_driver = new Joystick(1);
    public final static Joystick m_arcade = new Joystick(0);

    SendableChooser<SequentialCommandGroup> autoChooser;
    
    private final JoystickButton clawGrabCone = new JoystickButton(m_arcade,1);
    private final JoystickButton clawGrabSquare = new JoystickButton(m_arcade, 2);
    private final JoystickButton a_armHigh = new JoystickButton(m_arcade, 3);
    private final JoystickButton a_armMid = new JoystickButton(m_arcade, 4);
    private final JoystickButton a_armLow = new JoystickButton(m_arcade, 5);
    private final JoystickButton a_armStow = new JoystickButton(m_arcade, 6);
    private final JoystickButton r_armBackward = new JoystickButton(m_arcade, 9);
    private final JoystickButton r_armFoward = new JoystickButton(m_arcade, 10);
    private final JoystickButton mw_armIn = new JoystickButton(m_arcade,11);
    private final JoystickButton mw_armOut = new JoystickButton(m_arcade, 12);

  public RobotContainer() {
    SmartDashboard.putData("reset encoders", new resetEncoders());
    SmartDashboard.putNumber("linear encoder", armLinear.getLinEncoder());
    SmartDashboard.putNumber("directional encoder", armDirectional.getDirEncoder());
    SmartDashboard.putString("gearshift", gearShift.position());
    SmartDashboard.putData("reset encoders", new resetEncoders());

    configureButtonBindings();
    driveTrain.setDefaultCommand(new driveManual());
    gearShift.setDefaultCommand(new shifter());

    SequentialCommandGroup a_mid_taxiBack = new SequentialCommandGroup(
    new InstantCommand(()   -> grabber.s_grabSolenoid.set(Value.kForward), grabber), 
    new InstantCommand(()   -> grabber.l_grabSolenoid.set(Value.kReverse), grabber),
    new RunCommand(()   -> armDirectional.armMove(-0.5), armDirectional).withTimeout(2.5),
    new InstantCommand(()   -> armDirectional.armMove(0), armDirectional),
    new InstantCommand(()   -> grabber.s_grabSolenoid.set(Value.kReverse),grabber),
    new InstantCommand(()   -> grabber.l_grabSolenoid.set(Value.kForward), grabber),
    new RunCommand(()   -> gearShift.shift(true),gearShift).withTimeout(3),
    new RunCommand(()   -> driveTrain.driveArcade(0, 0.3),driveTrain).withTimeout(1),
    new RunCommand(()   -> driveTrain.driveArcade(0, 0.5), driveTrain).withTimeout(3),
    new InstantCommand(()   -> driveTrain.driveArcade(0,0),driveTrain));

    SequentialCommandGroup a_mid_taxiCharge = new SequentialCommandGroup(
      new InstantCommand(()   -> grabber.s_grabSolenoid.set(Value.kForward), grabber), 
      new InstantCommand(()   -> grabber.l_grabSolenoid.set(Value.kReverse), grabber),
      new RunCommand(()       -> armDirectional.armMove(-0.65), armDirectional).withTimeout(2.5),
      new InstantCommand(()   -> armDirectional.armMove(0), armDirectional),
      new InstantCommand(()   -> grabber.s_grabSolenoid.set(Value.kReverse),grabber),
      new InstantCommand(()   -> grabber.l_grabSolenoid.set(Value.kForward), grabber),
      new RunCommand(()       -> gearShift.shift(true),gearShift).withTimeout(3),
      new RunCommand(()       -> driveTrain.driveArcade(0, 0.3),driveTrain).withTimeout(9),
      new RunCommand(()       -> driveTrain.driveArcade(0, 0.5), driveTrain).withTimeout(4),
      new InstantCommand(()   -> driveTrain.driveArcade(0,0),driveTrain));

    autoChooser = new SendableChooser<>();
    autoChooser.setDefaultOption("mid & taxi", a_mid_taxiBack);
    autoChooser.addOption("mid & taxi charge", a_mid_taxiCharge );
    SmartDashboard.putData(autoChooser);
 }
private void configureButtonBindings() {
  clawGrabSquare.toggleOnTrue(new clawGrabSquare());
  clawGrabSquare.toggleOnTrue(new clawReleaseSquare());
  clawGrabCone.onTrue(new clawGrabCone());
  clawGrabCone.onFalse(new clawReleaseCone());
  r_armBackward.whileTrue(new r_armBackward());
  r_armFoward.whileTrue(new r_armFoward());
  mw_armIn.whileTrue(new mw_armIn());
  mw_armOut.whileTrue(new mw_armOut());
  a_armHigh.onTrue(new a_armHigh());
  a_armMid.onTrue(new a_armLow());
  a_armLow.onTrue(new a_armLow());
  a_armStow.onTrue(new a_armStow());
  }

  public Command getAutonomousCommand() {
    
    return autoChooser.getSelected();

  }
}