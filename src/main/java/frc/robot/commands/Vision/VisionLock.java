/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;

/**
 * Add your docs here.
 */
public class VisionLock extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  public static double visionRotation;
  public VisionLock() {
    // Intert a subsystem name and PID values here
    super("VisionLock", .019, 0, .002);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
    setSetpoint(0);
    enable();
  }

  @Override
  public void initDefaultCommand() {
  }

  @Override
  protected double returnPIDInput() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("chameleon-vision").getSubTable("USB Camera-B4.09.24.1");

        NetworkTableEntry yaw = table.getEntry("targetYaw");
        double yawdub = yaw.getDouble(0);

    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return -yawdub;
  }

  @Override
  protected void usePIDOutput(double output) {

    if (OI.joy1.getRawButton(10)) {

      visionRotation = output;
    }
    else {
      visionRotation = 0;

    }
     
    
    
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);


  }
}
