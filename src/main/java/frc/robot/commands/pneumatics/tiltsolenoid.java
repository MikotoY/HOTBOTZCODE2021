package frc.robot.commands.pneumatics;

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Pneumatics;

public class tiltsolenoid extends Command {
  public tiltsolenoid() {
    requires(Robot.pneumatics);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.pneumatics.tiltOut();
    }

  
  @Override
  protected boolean isFinished() {
    // return !OI.joy2.getRawButton(1);
    return false;
  }

  
  @Override
  protected void end() {
    Robot.pneumatics.tiltIn();
  }

 
  @Override
  protected void interrupted() {
    Robot.pneumatics.tiltIn();
  }
}