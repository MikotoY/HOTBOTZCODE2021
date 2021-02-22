package frc.robot.commands.swerve;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwerveLock extends Command {
    public SwerveLock() {
        requires(Robot.swerve);
    }

    @Override
    public void execute() {
        Robot.swerve.lockWheels();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end() {

    }
}