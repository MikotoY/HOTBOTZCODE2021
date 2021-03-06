package frc.robot;

import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Controller;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;

import edu.wpi.first.cameraserver.CameraServer;
import  edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;
import frc.robot.commands.Vision.HoldDist;
import frc.robot.commands.Vision.VisionLock;
import frc.robot.commands.shoot.SHOOT;
import frc.robot.commands.Vision.HoldDist;
// import frc.robot.commands.auto.AutoForward;
// import frc.robot.commands.auto.PathTesting;
// import frc.robot.profiling.PathFollower;
// import frc.robot.profiling.PathTracking;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;


public class Robot extends TimedRobot {
    public static final Subsystem CameraAlign = null;
    
    DigitalInput limitswitch;
	public static SwerveDrive swerve;
    public static Gyro navxGyro;
    public static VisionLock visionLock;
    public static HoldDist HoldDist;
    // public static PathTracking path;
    // public static PathFollower follower;
    public static Command autoCommand;
    public static OI oi;
    public static Pneumatics pneumatics;
    public static NetworkTable table;
    public static NetworkTableEntry yaw;
    public static double yawdub;
    public static Intake intake;
    public static Shoot shoot;
    // SendableChooser<int> chooser;

    public Timer timer;
    

   
    
    // public static PowerDistributionPanel pdp;

    public void robotInit() {
        limitswitch = new DigitalInput(1);
        navxGyro = new Gyro();
        swerve = new SwerveDrive(navxGyro); 
        visionLock = new VisionLock();
        // path = new PathTracking(swerve, navxGyro);
        pneumatics = new Pneumatics();
        // follower = new PathFollower();
        // autoCommand = new PathTesting();
        intake = new Intake();
        shoot = new Shoot();
        oi = new OI();     
        CameraServer.getInstance().startAutomaticCapture();
        
    
    }

    @Override
    public void robotPeriodic() {

        table = NetworkTableInstance.getDefault().getTable("chameleon-vision").getSubTable("USB Camera-B4.09.24.1");

       

        yaw = table.getEntry("targetYaw");
        yawdub = yaw.getDouble(0);

        // NetworkTableEntry xDistEntry = table.getEntry("targetPose");
        // double[] xDist = xDistEntry.getDoubleArray(new double[0]);
        // double xDistance = xDist[0];

        // NetworkTableEntry yDistEntry = table.getEntry("targetPose");
        // double[] yDist = xDistEntry.getDoubleArray(new double[1]);
        // double yDistance = xDist[0];

        // double hypotn = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));

        //path.update();
        swerve.smartDash(); 
        //Scheduler.getInstance().run();
        SmartDashboard.putNumber("Pitch", navxGyro.getRoll() - .9);
        SmartDashboard.putNumber("Pressure", navxGyro.getPressure());
        SmartDashboard.putNumber("PressureVoltage", navxGyro.getPressureVoltage());
        SmartDashboard.putNumber("yawfromcode", yawdub);
        SmartDashboard.putNumber("time", Timer.getFPGATimestamp());
        // SmartDashboard.putNumber("DistFromTarget", hypotn);

        SmartDashboard.putNumber("visionPID", visionLock.visionRotation);
        // SmartDashboard.putBoolean("topSwitch", );
    }

    @Override
    public void autonomousInit() {
        Robot.swerve.modules[1].resetEncoder();
              // Robot.swerve.setFieldOn();

        timer = new Timer();
        timer.reset();
        // path.reset();

        // autoCommand.start();
        // pneumatics.lowIn();
    }

    @Override
    public void autonomousPeriodic() {
       // DigitalInput limitswitch = new DigitalInput(1);

        

        double time = (timer.get());
        double dist = Robot.swerve.modules[1].getDistance();
        double gyroangle = navxGyro.getAngle();
        VictorSP shootMotor = new VictorSP(3);
    }
        // VictorSP liftMotor = new VictorSP(2);


   //1 turn = 11 inches
   //i turn = 25000
//    
//     if (limitswitch.get()) {
        
//     // liftMotor.set(1);
//     shootMotor.set(1);
//     // Timer.delay(5);
//     // liftMotor.set(0);
//     shootMotor.set(0);

//     // if (time <= 5) { 

//         if (dist <= 40000) {
//             Robot.swerve.driveNormal(0,.4,-.15);
//         }
    
//         else {
//         Robot.swerve.driveNormal(0, 0, 0);
//         Robot.intake.shootForward();
//         // Robot.intake.liftUp();
//         }

//     }
//     else {
//     Robot.intake.shootStop();
//     // Robot.intake.liftStop();
//     }
//uncomment if no shoot^^


// else {

//     if (dist <= 85000) {
//         Robot.swerve.driveNormal(0,.5,0);
//    }
//    else  {
//    Robot.swerve.driveNormal(0,0,0);
//    }
// }


// }

//     else if (time > 3) {

//      if (gyroangEle < 165) {
//         Robot.swerve.driveNormal(0, 0, 0);
//     }
//     else Robot.swerve.driveNormal(0, 0, 0);
// //    Timer.delay(3);

//     }
// }



    @Override
    public void teleopInit() {
        Robot.swerve.setFieldOff();
        //swerve.smartDash();
        
        // swerve.targetAngle = navxGyro.getPitch();

        // pneumatics.lowOut();
    }

    @Override
    public void teleopPeriodic() {
        
        Scheduler.getInstance().run();
    
    }

    @Override
    public void disabledInit() {
        
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
    }
}
