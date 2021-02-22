package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;

public class Gyro {
    private static AHRS gyro = new AHRS(SPI.Port.kMXP);
    private static double offset = 0;
    AnalogInput pressureSensor = new AnalogInput(5);

    public Gyro() {
        super();
    }

    public double getPressure() {
        return ((pressureSensor.getVoltage() - .318) * .665) * 120;
    }
        //OUTPUTS 0-120 to Dashboard

    public double getPressureVoltage() {
        return ((((pressureSensor.getVoltage() - .318) * .665) * .08) + .93);

        // MULTIPLY BY .08, add .95
        // Multiply this by the setpoint in PIDControl()
         //This will change the setpoint variably from 95% to 103%
    }
    //OUTPUTS 0-1

    public double getAngle() {
        return gyro.getAngle() + offset;
    }

    public double getRoll() {
        return (double)gyro.getRoll();
    }

    public double getRate() {
        return gyro.getRate();
    }

    public void reset() {
        gyro.zeroYaw();
        offset = 0;
    }

    public void set(double angle) {
        gyro.reset();
        offset = angle;
    }

    public double pidGet() {
        return getAngle();
    }
    // public static double angleCorrect() {
    // return gyro.getAngle() * -.025;
    // }

    // public double straight(boolean angle) {
    // if (angle) {
    // currentangle = gyro.getAngle();
    // SwerveDrive.angle = false;
    // }
    // return (gyro.getAngle() - currentangle) * .015;
    // }
}