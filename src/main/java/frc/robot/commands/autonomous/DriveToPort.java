package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveToPort extends CommandBase {

    public DriveToPort () {
        addRequirements(RobotContainer.driveTrain);
        withTimeout(5.0);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}