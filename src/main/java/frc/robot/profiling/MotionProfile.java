package frc.robot.profiling;

public interface MotionProfile {
	public double currentP(double t);
	public double currentV(double t);
	public double currentA(double t);
	public double totalTime();
}
