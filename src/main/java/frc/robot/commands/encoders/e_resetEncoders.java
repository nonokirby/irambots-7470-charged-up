package frc.robot.commands.encoders;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.armDirectional;
import frc.robot.subsystems.armLinear;
import frc.robot.subsystems.driveTrain;

public class e_resetEncoders extends InstantCommand{
    public e_resetEncoders(){
    }

    @Override
    public void initialize(){
        armDirectional.resetEncoder();
        armLinear.resetEncoder();
        driveTrain.resetEncoders();
    }
}
