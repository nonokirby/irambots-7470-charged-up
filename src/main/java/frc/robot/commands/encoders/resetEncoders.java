package frc.robot.commands.encoders;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.arm;
import frc.robot.subsystems.driveTrain;

public class resetEncoders extends InstantCommand{
    public resetEncoders(){
    }

    @Override
    public void initialize(){
        arm.resetEncoders();
        driveTrain.resetEncoders();
    }
}
