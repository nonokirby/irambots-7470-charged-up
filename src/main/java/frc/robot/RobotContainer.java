 
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

   private final JoystickButton grabDown = new JoystickButton(m_driver,6);
   private final JoystickButton grabUp = new JoystickButton(m_driver, 5);
   private final JoystickButton armUp = new JoystickButton(m_driver,11);
   private final JoystickButton shifter = new JoystickButton(m_driver, 12);

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
  grabDown.whileTrue(new grabDown(grabber));
  armUp.whileTrue(new armManual());
  /* Driver 2 Buttons */
  grabUp.whileTrue(new grabUp(grabber));
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






