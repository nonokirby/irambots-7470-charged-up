package frc.robot.commands.encoders;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.arm;

public class armLinear extends InstantCommand {
    public armLinear(){
    }
    
    public void initialize(){
        arm.getDirEncoder();
    }
}
