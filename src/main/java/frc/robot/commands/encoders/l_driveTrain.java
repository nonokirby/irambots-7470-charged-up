package frc.robot.commands.encoders;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.arm;

public class l_driveTrain extends InstantCommand {
    public l_driveTrain(){
    }
    
    public void initialize(){
        arm.getDirEncoder();
    }
}
