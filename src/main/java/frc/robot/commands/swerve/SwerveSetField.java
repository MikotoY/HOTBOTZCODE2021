package frc.robot.commands.swerve;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwerveSetField extends Command {
    public SwerveSetField() {
    }

    @Override
    public void execute() {
        Robot.swerve.setField();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end() {
    }
}