package frc.robot.commands.encoders;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.armDirectional;

public class armDirectional extends InstantCommand {
    public armDirectional(){
    }
    
    public void initialize(){
        armDirectional.getDirEncoder();
    }
}
