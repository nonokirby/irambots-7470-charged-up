package frc.robot.commands.encoders;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.armDirectional;

public class e_armLinear extends InstantCommand {
    public e_armLinear(){
    }
    
    public void initialize(){
        armDirectional.getDirEncoder();
    }
}
