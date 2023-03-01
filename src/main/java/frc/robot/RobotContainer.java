 
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.commands.claw.*;
import frc.robot.commands.arm.*;
import frc.robot.commands.encoders.*;
import frc.robot.subsystems.*;

 public class RobotContainer {
    public final static grabber grabber = new grabber();
    public final static arm arm = new arm();
    public final static driveTrain driveTrain = new driveTrain();
    public final static gearShift gearShift = new gearShift();

    public final static Joystick m_driver = new Joystick(1);
    public final static Joystick m_arcade = new Joystick(0);
    
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
    configureButtonBindings();
    driveTrain.setDefaultCommand(new driveManual());
    gearShift.setDefaultCommand(new shifter());
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
}