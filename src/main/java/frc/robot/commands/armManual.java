/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class armManual extends CommandBase {
    //@SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    public armManual() {
        addRequirements(Robot.arm);
    }

    @Override
    public void execute(){
        Robot.arm.armVert();
    }
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.arm.stop();
    }

    /* @Override
    protected void interrupted() {
        end();
    }
*/
}