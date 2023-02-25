 
package frc.robot;

//import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

//import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
/*
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

 public class RobotContainer {
   //controllers
   public final Joystick m_driver = new Joystick(1);
   public final Joystick m_arcade = new Joystick(0);
   
   /*m_driver Buttons Controller */
   private final JoystickButton clawRelease = new JoystickButton(m_driver,6);
   //private final JoystickButton grabUp = new JoystickButton(m_driver, 2);
   private final JoystickButton clawGrab = new JoystickButton(m_driver, 5);
   private final JoystickButton mw_armIn = new JoystickButton(m_driver,11);
   private final JoystickButton shifter = new JoystickButton(m_driver, 12);
   /*m_arcade Buttons Controller */
   //private final JoystickButton grabUp = new JoystickButton(m_arcade, 6);

   /* Subsystems */
public final static grabber grabber = new grabber();
public final static arm arm = new arm();
public final static driveTrain driveTrain = new driveTrain();
public final static gearShift gearShift = new gearShift();
   public RobotContainer() {
//configures button bindings
configureButtonBindings();
Robot.driveTrain.setDefaultCommand(new driveManual());
 }

private void configureButtonBindings() {
/* Driver 1 Buttons */
  clawRelease.whileTrue(new clawRelease(grabber));
  mw_armIn.whileTrue(new frc.robot.commands.arm.mw_armIn());
  /* Driver 2 Buttons */
  clawGrab.whileTrue(new clawGrab(grabber));
  shifter.whileTrue(new shifter());
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