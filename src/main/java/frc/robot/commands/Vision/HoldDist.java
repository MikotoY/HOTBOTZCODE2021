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
public class HoldDist extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  public static double xDistance;
  
  public HoldDist() {
    // Intert a subsystem name and PID values here
    super("HoldDist", .06, 0, 0);

    setSetpoint(4.5);
    enable();
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("chameleon-vision").getSubTable("USB Camera-B4.09.24.1");

    NetworkTableEntry xDistEntry = table.getEntry("targetPose");
    double[] xDist = xDistEntry.getDoubleArray(new double[0]);
    xDistance = xDist[0];
    return xDistance;
  }

  @Override
  protected void usePIDOutput(double output) {

    if (OI.joy1.getRawButton(10)) {

      xDistance = output;
    }

    else
        xDistance = 0;

    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
  }
}
