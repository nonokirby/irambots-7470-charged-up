/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/*package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class cargoVert extends CommandBase {
    //@SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    public cargoVert() {
      //Use addRequirements() here to declare subsystem dependencies
      // eg. addRequirements(chassis);
      addRequirements(Robot.cargo);
    }
    
    

    @Override
    public void execute() {
       Robot.cargo.cargoUp();
    }
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.cargo.stop();
    }

   /*  @Override
    protected void interrupted() {
        end();
    } */

    //}