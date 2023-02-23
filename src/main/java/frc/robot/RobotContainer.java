 
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
   private final JoystickButton grabDown = new JoystickButton(m_driver,6);
   //private final JoystickButton grabUp = new JoystickButton(m_driver, 2);
   //private final JoystickButton grabUp = new JoystickButton(m_driver, 5);
   private final JoystickButton armUp = new JoystickButton(m_driver,11);
   private final JoystickButton grabUp = ;
   /*m_arcade Buttons Controller */
   //private final JoystickButton grabUp = new JoystickButton(m_arcade, 6);

   /* Subsystems */
public final static grabber grabber = new grabber();
public final static arm arm = new arm();
   public RobotContainer() {
//configures button bindings
configureButtonBindings();
System.out.print("configure command post");

Robot.driveTrain.setDefaultCommand(new driveManual());
 }

private void configureButtonBindings() {
/* Driver 1 Buttons */
  grabDown.onTrue(new grabDown(grabber));
  armUp.onTrue(new armManual());
  /* Driver 2 Buttons */
  grabUp.onTrue(new grabUp(grabber));
  System.out.print("configureButtonBindings");
//driver controller
//arm limited
/* new JoystickButton(m_driver, 11).whileTrue(new armUpLimited());
new JoystickButton(m_driver, 12).whileTrue(new armDownLimited());

//arm manual
new JoystickButton(m_driver, 9).whileTrue(new armManual());
new JoystickButton(m_driver, 10).whileTrue(new armRetract());

//shooter
new JoystickButton(m_driver, 3).whileTrue(new shooterManual());
new JoystickButton(m_driver, 5).whileTrue(new fullShooter());

//reverse shooter

new JoystickButton(m_driver, 1).whileTrue(new grabDown());
new JoystickButton(m_driver, 2).whileTrue(new grabUp());

//hanger controller

//small hooks
new JoystickButton(m_arcade, 1).whileTrue(new grabDown());
new JoystickButton(m_arcade, 2).whileTrue(new grabUp());

//big hook
new JoystickButton(m_arcade, 7).whileTrue(new armWest());
new JoystickButton(m_arcade, 8).whileTrue(new armEast());
}
*/
}
public Joystick getjoy1() {
  return m_arcade;
}
public Joystick getjoy2() {
  return m_driver;
}}






/* 
public class OI {
 
 
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.
  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:
  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.WhileTrue(new ExampleCommand());
  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
public Joystick joy1;
public Joystick joy2;
public Joystick joy3;
public JoystickButton joystickButton1;
public JoystickButton joystickButton2;
public JoystickButton joystickButton3;
public JoystickButton joystickButton4;
public JoystickButton joystickButton5;
public JoystickButton joystickButton6;
public JoystickButton joystickButton7;
public JoystickButton joystickButton8;
public JoystickButton joystickButton9;
public JoystickButton joystickButton10;
public JoystickButton joystickButton11;
public JoystickButton joystickButton12;
public OI() {
//input port 1 button reading
//input a
  joy1 = new Joystick(0);
 JoystickButton btn1a = new JoystickButton(joy1, 1);
 JoystickButton btn2a = new JoystickButton(joy1, 2);
 JoystickButton btn3a = new JoystickButton(joy1, 3);
 JoystickButton btn4a = new JoystickButton(joy1, 4);
 JoystickButton btn5a = new JoystickButton(joy1, 5);
 JoystickButton btn6a = new JoystickButton(joy1, 6);
 JoystickButton btn7a = new JoystickButton(joy1, 7);
 JoystickButton btn8a = new JoystickButton(joy1, 8);
  JoystickButton btn9a = new JoystickButton(joy1, 9);
  JoystickButton btn10a = new JoystickButton(joy1, 10);
 JoystickButton btn11a = new JoystickButton(joy1, 11);
  JoystickButton btn12a = new JoystickButton(joy1, 12);
//input port 2 button reading
//input b
  joy2 = new Joystick(1);
  JoystickButton btn1b = new JoystickButton(joy2, 1);
  JoystickButton btn2b = new JoystickButton(joy2, 2);
  JoystickButton btn3b = new JoystickButton(joy2, 3);
  JoystickButton btn4b = new JoystickButton(joy2, 4);
  JoystickButton btn5b = new JoystickButton(joy2, 5);
  JoystickButton btn6b = new JoystickButton(joy2, 6);
  JoystickButton btn7b = new JoystickButton(joy2, 7);
  JoystickButton btn8b = new JoystickButton(joy2, 8);
  JoystickButton btn9b = new JoystickButton(joy2, 9);
  JoystickButton btn10b = new JoystickButton(joy2, 10);
  JoystickButton btn11b = new JoystickButton(joy2, 11);
  JoystickButton btn12b = new JoystickButton(joy2, 12);
  joy3 = new Joystick(2);
  JoystickButton btn1c = new JoystickButton(joy3, 1);
  JoystickButton btn2c = new JoystickButton(joy3, 2);
  JoystickButton btn3c = new JoystickButton(joy3, 3);
  JoystickButton btn4c = new JoystickButton(joy3, 4);
  JoystickButton btn5c = new JoystickButton(joy3, 5);
  JoystickButton btn6c = new JoystickButton(joy3, 6);
  JoystickButton btn7c = new JoystickButton(joy3, 7);
  JoystickButton btn8c = new JoystickButton(joy3, 8);
 //JoystickButton btn9c = new JoystickButton(joy3, 9);
 //JoystickButton btn10c = new JoystickButton(joy3, 10);
 //JoystickButton btn11c = new JoystickButton(joy3, 11);
 // JoystickButton btn12c = new JoystickButton(joy3, 12);
  
  btn1a.whileTrue(new armUpLimited());
  btn2a.whileTrue(new armDownLimited());
  btn3a.whileTrue(new hookEast());
  btn4a.whileTrue(new hookWest());
  btn5a.whileTrue(new shooterManual());
  btn6a.whileTrue(new fullShooter());
  btn7a.whileTrue(new armWest());
  btn8a.whileTrue(new armEast());
  btn9a.WhileTrue(new resetArmEncoder());
  btn10a.whileTrue(new putDown());
  btn11a.whileTrue(new armUpLimited());
  btn12a.whileTrue(new armDownLimited());
//input port 2 button mapping
  btn1b.WhileTrue(new cargoVert());
  //btn1b.WhileTrue(new intakeCell());
  btn2b.whileTrue(new armUpLimited());
  btn3b.whileTrue(new shooterManual());
  btn4b.whileTrue(new putDown());
  btn5b.whileTrue(new fullShooter());
  btn6b.whileTrue(new putDown());
  btn7b.whileTrue(new hookEast());
  btn8b.whileTrue(new hookWest());
  btn9b.whileTrue(new armManual());
  btn10b.whileTrue(new armRetract());
  btn11b.whileTrue(new armUpLimited());
  btn12b.whileTrue(new armDownLimited());
  btn1c.WhileTrue(new cargoVert());
  //btn1c.WhileTrue(new intakeCell());
  btn2c.whileTrue(new armUpLimited());
  btn3c.whileTrue(new armWest());
  btn4c.whileTrue(new hookWest());
  btn5c.whileTrue(new hookEast());
  btn6c.whileTrue(new shooterManual());
  btn7c.whileTrue(new armDownLimited());
  btn8c.whileTrue(new armEast());
}
public Joystick getjoy1() {
  return joy1;
}
public Joystick getjoy2() {
  return joy2;
};
//public GenericHID getJoystick() {
	//return null;
//}
//public Object interpretHatState(Object joystick1, int i, int j, double d, double e) {
	//return null;
}
}
*/

 /* 
 
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.
  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:
  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.WhileTrue(new ExampleCommand());
  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
public Joystick joy1;
public Joystick joy2;
public Joystick joy3;
public JoystickButton joystickButton1;
public JoystickButton joystickButton2;
public JoystickButton joystickButton3;
public JoystickButton joystickButton4;
public JoystickButton joystickButton5;
public JoystickButton joystickButton6;
public JoystickButton joystickButton7;
public JoystickButton joystickButton8;
public JoystickButton joystickButton9;
public JoystickButton joystickButton10;
public JoystickButton joystickButton11;
public JoystickButton joystickButton12;
public OI() {
//input port 1 button reading
//input a
  joy1 = new Joystick(0);
 JoystickButton btn1a = new JoystickButton(joy1, 1);
 JoystickButton btn2a = new JoystickButton(joy1, 2);
 JoystickButton btn3a = new JoystickButton(joy1, 3);
 JoystickButton btn4a = new JoystickButton(joy1, 4);
 JoystickButton btn5a = new JoystickButton(joy1, 5);
 JoystickButton btn6a = new JoystickButton(joy1, 6);
 JoystickButton btn7a = new JoystickButton(joy1, 7);
 JoystickButton btn8a = new JoystickButton(joy1, 8);
  JoystickButton btn9a = new JoystickButton(joy1, 9);
  JoystickButton btn10a = new JoystickButton(joy1, 10);
 JoystickButton btn11a = new JoystickButton(joy1, 11);
  JoystickButton btn12a = new JoystickButton(joy1, 12);
//input port 2 button reading
//input b
  joy2 = new Joystick(1);
  JoystickButton btn1b = new JoystickButton(joy2, 1);
  JoystickButton btn2b = new JoystickButton(joy2, 2);
  JoystickButton btn3b = new JoystickButton(joy2, 3);
  JoystickButton btn4b = new JoystickButton(joy2, 4);
  JoystickButton btn5b = new JoystickButton(joy2, 5);
  JoystickButton btn6b = new JoystickButton(joy2, 6);
  JoystickButton btn7b = new JoystickButton(joy2, 7);
  JoystickButton btn8b = new JoystickButton(joy2, 8);
  JoystickButton btn9b = new JoystickButton(joy2, 9);
  JoystickButton btn10b = new JoystickButton(joy2, 10);
  JoystickButton btn11b = new JoystickButton(joy2, 11);
  JoystickButton btn12b = new JoystickButton(joy2, 12);
  joy3 = new Joystick(2);
  JoystickButton btn1c = new JoystickButton(joy3, 1);
  JoystickButton btn2c = new JoystickButton(joy3, 2);
  JoystickButton btn3c = new JoystickButton(joy3, 3);
  JoystickButton btn4c = new JoystickButton(joy3, 4);
  JoystickButton btn5c = new JoystickButton(joy3, 5);
  JoystickButton btn6c = new JoystickButton(joy3, 6);
  JoystickButton btn7c = new JoystickButton(joy3, 7);
  JoystickButton btn8c = new JoystickButton(joy3, 8);
 //JoystickButton btn9c = new JoystickButton(joy3, 9);
 //JoystickButton btn10c = new JoystickButton(joy3, 10);
 //JoystickButton btn11c = new JoystickButton(joy3, 11);
 // JoystickButton btn12c = new JoystickButton(joy3, 12);
  
  btn1a.WhileTrue(new armUpLimited());
  btn2a.WhileTrue(new armDownLimited());
  btn3a.WhileTrue(new hookEast());
  btn4a.WhileTrue(new hookWest());
  btn5a.WhileTrue(new shooterManual());
  btn6a.WhileTrue(new fullShooter());
  btn7a.WhileTrue(new armWest());
  btn8a.WhileTrue(new armEast());
  btn9a.WhileTrue(new resetArmEncoder());
  btn10a.WhileTrue(new putDown());
  btn11a.WhileTrue(new armUpLimited());
  btn12a.WhileTrue(new armDownLimited());
//input port 2 button mapping
  btn1b.WhileTrue(new cargoVert());
  //btn1b.WhileTrue(new intakeCell());
  btn2b.WhileTrue(new armUpLimited());
  btn3b.WhileTrue(new shooterManual());
  btn4b.WhileTrue(new putDown());
  btn5b.WhileTrue(new fullShooter());
  btn6b.WhileTrue(new putDown());
  btn7b.WhileTrue(new hookEast());
  btn8b.WhileTrue(new hookWest());
  btn9b.WhileTrue(new armManual());
  btn10b.WhileTrue(new armRetract());
  btn11b.WhileTrue(new armUpLimited());
  btn12b.WhileTrue(new armDownLimited());
  btn1c.WhileTrue(new cargoVert());
  //btn1c.WhileTrue(new intakeCell());
  btn2c.WhileTrue(new armUpLimited());
  btn3c.WhileTrue(new armWest());
  btn4c.WhileTrue(new hookWest());
  btn5c.WhileTrue(new hookEast());
  btn6c.WhileTrue(new shooterManual());
  btn7c.WhileTrue(new armDownLimited());
  btn8c.WhileTrue(new armEast());
}
public Joystick getjoy1() {
  return joy1;
}
public Joystick getjoy2() {
  return joy2;
};
//public GenericHID getJoystick() {
	//return null;
//}
//public Object interpretHatState(Object joystick1, int i, int j, double d, double e) {
	//return null;
}

*/