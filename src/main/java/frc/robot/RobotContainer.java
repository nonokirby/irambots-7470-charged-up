 
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.commands.claw.*;
import frc.robot.commands.arm.*;
import frc.robot.subsystems.*;
/*
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

 public class RobotContainer {
     /* Subsystems */
  public final static grabber grabber = new grabber();
  public final static arm arm = new arm();
  public final static driveTrain driveTrain = new driveTrain();
  public final static gearShift gearShift = new gearShift();
  public final static sideSwipe sideSwipe = new sideSwipe();
   //controllers
   public final static Joystick m_driver = new Joystick(1);
   public final static Joystick m_arcade = new Joystick(0);
   
   /*m_driver Buttons Controller */
   private final JoystickButton clawGrabCone = new JoystickButton(m_arcade,1);
   private final JoystickButton clawGrabSquare = new JoystickButton(m_arcade, 2);
   private final JoystickButton mw_armIn = new JoystickButton(m_driver,11);
   private final JoystickButton shifter = new JoystickButton(m_driver, 12);


   public RobotContainer() {
//configures button bindings
configureButtonBindings();
driveTrain.setDefaultCommand(new driveManual());
sideSwipe.setDefaultCommand(new sideDrive());
gearShift.setDefaultCommand(new shifter());
 }

private void configureButtonBindings() {
  /* Driver Buttons */

  /* Operator Buttons */
  clawGrabSquare.onTrue(new clawGrabSquare(grabber));
  clawGrabSquare.onFalse(new clawReleaseSquare(grabber));
  clawGrabCone.onTrue(new clawGrabCone(grabber));
  mw_armIn.whileTrue(new mw_armIn());

  shifter.whileFalse(new shifter());
  System.out.print("configureButtonBindings");
//driver controller
//arm limited
}
public Joystick getjoy1() {
  return m_arcade;
}
public Joystick getjoy2() {
  return m_driver;
}}