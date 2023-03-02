package frc.robot.commands.encoders;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.armDirectional;

public class e_armDirectional extends InstantCommand {
    public e_armDirectional(){
    }
    
    public void initialize(){
        armDirectional.getDirEncoder();
    }
}
