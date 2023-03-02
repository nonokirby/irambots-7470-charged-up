package frc.robot.commands.encoders;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.driveTrain;

public class e_r_driveTrain extends InstantCommand {
    public e_r_driveTrain(){
    }
    
    public void initialize(){
        driveTrain.r_getEncoder();
    }
}
