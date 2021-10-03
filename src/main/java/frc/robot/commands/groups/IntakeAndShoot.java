// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.intake.intakeIN;
import frc.robot.commands.shoot.SHOOT;

public class IntakeAndShoot extends CommandGroup {
  public IntakeAndShoot() {
    // Simultaneously shoot and run the intake
    addParallel(new SHOOT());
    addParallel(new intakeIN());
  }
}
