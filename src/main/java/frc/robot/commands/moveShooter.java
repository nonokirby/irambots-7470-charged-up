/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
//shooter  used to be jack
public class moveShooter extends CommandBase {
    //@SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    //private boolean move;

    public moveShooter() {
        addRequirements(Robot.shooter);
    }

    @Override
    public void execute (){
        Robot.shooter.shooterVert();
    }
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.shooter.stop();
    }

      /* @Override
     protected void interrupted() {
        end();
    } */

}