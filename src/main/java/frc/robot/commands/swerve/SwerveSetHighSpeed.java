package frc.robot.commands.swerve;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwerveSetHighSpeed extends Command {
    public SwerveSetHighSpeed() {
    }

    @Override
    public void execute() {
        Robot.swerve.setSpeed(100, 100);
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