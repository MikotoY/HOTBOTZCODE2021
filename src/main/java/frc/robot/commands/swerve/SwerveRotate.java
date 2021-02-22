package frc.robot.commands.swerve;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDInterface;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwerveRotate extends Command{
    private double angle, speed;
    

    public SwerveRotate(double angle, double speed) {
        requires(Robot.swerve);
        this.angle = angle;
        this.speed = speed;
    }

    public void initialize() {
    }

    public void execute() {
        Robot.swerve.driveNormal(0, 0, speed);
    }

    public boolean isFinished() {
        return Math.abs(Robot.navxGyro.getAngle()) > angle;
    }


    public void end() {
        Robot.swerve.driveField(0, 0, 0);
    }
}