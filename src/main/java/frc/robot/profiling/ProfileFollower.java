package frc.robot.profiling;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

public class ProfileFollower {
    double kV, kA, kP, kI, kD;
    PIDSource encoder;
    PIDOutput output;
    MotionProfile profile;
    long startTime;
    double prevTime;
    double prevError;
    double integral;

    public ProfileFollower(double kV, double kA, double kP, double kI, double kD, PIDSource encoder, PIDOutput output) {
        this.kV = kV;
        this.kA = kA;
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.encoder = encoder;
        this.output = output;
    }

    public ProfileFollower(double kV, double kA, double kP, double kI, double kD) {
        this.kV = kV;
        this.kA = kA;
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    public void startProfile(MotionProfile mP) {
        resetPID();
        profile = mP;
    }

    public void resetPID() {
        prevError = integral = 0;
        startTime = System.nanoTime();
        prevTime = 0;
    }

    public void update() {
        if (profile == null) {
            output.pidWrite(0);
        } else {
            double t = (System.nanoTime() - startTime) / 1e9;
            output.pidWrite(update(encoder.pidGet(), profile.currentP(t), profile.currentV(t), profile.currentA(t)));
        }
    }

    public double update(double pos, double profilePos, double profileVel, double profileAccel) {
        double t = (System.nanoTime() - startTime) / 1e9;
        double dt = Math.max(0.0001, Math.min(0.1, t - prevTime));

        double error = profilePos - pos;
        double deriv = (error - prevError) / dt;
        integral += error * dt;

        prevError = error;
        prevTime = t;

        return kP*error + kI*integral + kD*deriv + kV*profileVel + kA*profileAccel;
    }

    public void cancel() {
        profile = null;
    }

    public boolean isFinished() {
        return profile == null || (System.nanoTime() - startTime) / 1e9 > profile.totalTime();
    }
}
