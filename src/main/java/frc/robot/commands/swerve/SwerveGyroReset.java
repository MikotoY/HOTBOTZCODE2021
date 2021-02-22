package frc.robot.commands.swerve;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwerveGyroReset extends Command {
    public SwerveGyroReset() {
    }

    @Override
    public void execute() {
        Robot.navxGyro.reset();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end() {
    }
}