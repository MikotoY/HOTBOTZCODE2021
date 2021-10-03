/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.auto.*;
import frc.robot.commands.groups.IntakeAndShoot;
import frc.robot.commands.shoot.SHOOT;
import frc.robot.commands.intake.intakeIN;
import frc.robot.commands.intake.intakeOUT;
import frc.robot.commands.intake.motorBW.*;
import frc.robot.commands.intake.motorFW.*;
// import frc.robot.commands.intake.liftDOWN;
// import frc.robot.commands.intake.liftUP;
import frc.robot.commands.pneumatics.*;
import frc.robot.commands.swerve.*;
import frc.robot.triggers.*;
import frc.robot.commands.Vision.*;
import frc.robot.commands.intake.*;



/**
1 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    
    public static Joystick joy1 = new Joystick(0);
        Trigger lowSpeed = new JoystickButton(joy1, RobotMap.Controller.LEFT_BUMPER);
        // Trigger highSpeed = new JoystickButton(joy1, RobotMap.Controller.RIGHT_TRIGGER);
        
        Button kSwerve = new JoystickButton(joy1, RobotMap.Controller.START);
        Button fieldOrient = new JoystickButton(joy1, RobotMap.Controller.RIGHT_BUMPER);
        Button gyroReset = new JoystickButton(joy1, RobotMap.Controller.LEFT_BUMPER);
        // Button ballIn = new JoystickButton(joy1,RobotMap.Controller.A);
        // Button ballOut = new JoystickButton(joy1, RobotMap.Controller.B);
        
        Button visionLock = new JoystickButton(joy1, RobotMap.Controller.VisionLock);
        Button tilt = new JoystickButton(joy1, RobotMap.Controller.A);
        // Button liftUp = new JoystickButton(joy1, RobotMap.Controller.Y);
        // Button liftDown = new JoystickButton(joy1, RobotMap.Controller.X);\
        // Button shoot = new JoystickButton(joy1, RobotMap.Controller.Y);

       



        public static Joystick joy2 = new Joystick(1);
        Trigger endClimb = new EndAuto();
        // Button lowLift = new JoystickButton(joy2, RobotMap.Logitech.low);
        // Button highLift = new JoystickButton(joy2, RobotMap.Logitech.high);
        // Button midposition = new JoystickButton(joy2, RobotMap.Logitech.mid);
        // Button tilt = new JoystickButton(joy2,RobotMap.Logitech.tilt);
        // Button balltilt = new JoystickButton(joy2,RobotMap.Logitech.balltilt);
        // Button legs = new JoystickButton(joy2, RobotMap.Logitech.leg);
        // Button liftup = new JoystickButton(joy2, RobotMap.Logitech.up);
        // Button liftdown = new JoystickButton(joy2, RobotMap.Logitech.down);
        // Button autolift = new JoystickButton(joy2, RobotMap.Logitech.autolift);
        // Button liftUp = new JoystickButton(joy2, RobotMap.Logitech.high);
        // Button liftDown = new JoystickButton(joy2, RobotMap.Logitech.four);

        // Button shoot = new JoystickButton(joy2, RobotMap.Logitech.trigger);
        // Button intake = new JoystickButton(joy2, RobotMap.Logitech.five);
        Button intakeAndShoot = new JoystickButton(joy2, RobotMap.Logitech.trigger); /* Replacing buttons above for the command group */
        Button outtake = new JoystickButton(joy2, RobotMap.Logitech.three);
        Button winchUp = new JoystickButton(joy2, RobotMap.Logitech.four);
        




    public OI() {
        lowSpeed.whenActive(new SwerveSetLowSpeed());
        // highSpeed.whenActive(new SwerveSetHighSpeed());
        // lockSwerve.whenPressed(new SwerveLock());

        
        fieldOrient.whenPressed(new SwerveSetField());
        gyroReset.whenPressed(new SwerveGyroReset());
        //lowLift.whenReleased(new lowliftsolenoidreverse());

        // lowLift.whenActive(new lowliftsolenoid());
        // highLift.whenActive(new highliftsolenoid());
        // midposition.whenPressed(new LiftMid());
        // intake.whenPressed(new intakeIN()); Commented out for command group
        outtake.whenPressed(new intakeOUT());

        tilt.toggleWhenPressed(new tiltsolenoid());
        // shoot.whenPressed(new SHOOT()); Commented out for command group

        intakeAndShoot.whenPressed(new IntakeAndShoot());

        // winchUp.whenPressed(new liftUp());
        // liftDown.whenPressed(new liftDOWN());

        // legs.whenPressed(new LEG());
        // legs.whenPressed(new autoLift());
        // balltilt.whenPressed(new balltiltsolenoid());

        //legs.whenReleased(new LEGsolenoidreverse());
        // liftup.whenActive(new up());
        // liftdown.whenActive(new down());

    }

    public boolean getClimbButton() {
        return joy2.getRawButtonReleased(2);
    }
}