package frc.robot.commands.swerve;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwerveSetLowSpeed extends Command {
    public SwerveSetLowSpeed() {
    }

    @Override
    public void execute() {
        Robot.swerve.setSpeed(30, 30);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end() {
        Robot.swerve.setSpeed(65, 55);
    }
}