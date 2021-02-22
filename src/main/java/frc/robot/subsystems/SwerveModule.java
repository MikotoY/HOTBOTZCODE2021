package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.profiling.TrapezoidProfile;
import frc.robot.profiling.ProfileFollower;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.ControlType;
// import com.revrobotics.CANSparkMax.IdleMode;
// import com.revrobotics.CANSparkMaxLowLevel.ConfigParameter;

import edu.wpi.first.wpilibj.*;

/**
 * @author Duncan Wizardman Page
 */
public class SwerveModule implements PIDSource, PIDOutput {
    private PIDController steerPID;
    // public CANSparkMax driveController;
    protected WPI_TalonSRX driveController;
    public WPI_VictorSPX steerController;
    private AbsoluteEncoder steerEncoder;
    public double positionX, positionY;
    private boolean enabled;
    public ProfileFollower swerveMP = new ProfileFollower(.008, 0.0, 0.15, 0, 0.02, this, this);
    public static double distPerRev = (4 * Math.PI) / 6;
    public int distPerPulse = 1;
    double distZero;

    public SwerveModule(WPI_TalonSRX driveController, WPI_VictorSPX steerController, AbsoluteEncoder steerEncoder,
            double positionX, double positionY) {
        this.steerController = steerController;
        this.driveController = driveController;
        this.steerEncoder = steerEncoder;
        this.positionX = positionX;
        this.positionY = positionY;
        steerPID = new PIDController(RobotMap.SwerveDrive.SWERVE_STEER_P, RobotMap.SwerveDrive.SWERVE_STEER_I,
                RobotMap.SwerveDrive.SWERVE_STEER_D, steerEncoder, steerController);
        steerPID.setInputRange(0, 2 * Math.PI);
        steerPID.setOutputRange(-RobotMap.SwerveDrive.SWERVE_STEER_CAP, RobotMap.SwerveDrive.SWERVE_STEER_CAP);
        steerPID.setContinuous();
        steerPID.disable();
        // driveController.setRampRate(0);
        // driveController.setIdleMode(IdleMode.kBrake);
        // driveController.setSmartCurrentLimit(40);
        // driveController.setParameter(ConfigParameter.kCtrlType, ControlType.kDutyCycle.value);
        // driveController.burnFlash();
        driveController.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
        0, 0);
        driveController.setSensorPhase(true);
        resetEncoder();
    }

    protected void enable() {
        steerPID.enable();
        enabled = true;
    }

    protected void disable() {
        steerPID.disable();
        driveController.set(0);
        steerController.set(0);
        enabled = false;
    }

    /**
     * @param angle in radians
     * @param speed motor speed [-1 to 1]
     */
    protected void set(double angle, double speed) {
        if (!enabled)
            return;
        angle = wrapAngle(angle);
        double dist = Math.abs(angle - steerEncoder.getAngle());
        // if the setpoint is more than 90 degrees from the current position, flip
        // everything
        if (dist > Math.PI / 2 && dist < 3 * Math.PI / 2) {
            angle = wrapAngle(angle + Math.PI);
            speed *= -1;
        }
        steerPID.setSetpoint(angle);
        driveController.set(Math.max(-1, Math.min(1, speed))); // coerce speed between -1 and 1
    }

    public void rest() {
        driveController.set(0);
    }

    public double getAngle() {
        return steerEncoder.getAngle();
    }

    private double wrapAngle(double angle) {
        angle %= 2 * Math.PI;
        if (angle < 0)
            angle += 2 * Math.PI;
        return angle;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void pidWrite(double output) {
        // TODO Auto-generated method stub
        // driveController.set(ControlMode.PercentOutput, output);
        driveController.set(output);

    }

    public void setPIDSourceType(PIDSourceType pidSource) {
    }

    public PIDSourceType getPIDSourceType() {
        return null;
    }

    public void resetEncoder() {
        distZero += getDistance();
    }

    public double getDistance() {
        return driveController.getSelectedSensorPosition(0) * distPerPulse -
        distZero;
        // return driveController.getEncoder().getPosition() * distPerRev - distZero;
    }

    public double pidGet() {
        return getDistance();
    }

    public void runProfile(double angle, TrapezoidProfile profile) {
        resetEncoder();
        angle = wrapAngle(angle - Math.PI / 2);
        double dist = Math.abs(angle - steerEncoder.getAngle());
        // if the setpoint is more than 90 degrees from the current position, flip
        // everything
        if (dist > Math.PI / 2 && dist < 3 * Math.PI / 2) {
            angle = wrapAngle(angle + Math.PI);
            profile.scalar *= -1;
        }
        steerPID.setSetpoint(angle);
        swerveMP.startProfile(profile);
    }

}