/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

// import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
import frc.robot.subsystems.*;
import frc.robot.OI;

public class intakeOUT extends Command {
  public intakeOUT() {
   requires(Robot.intake);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.intake.intakeOut();
    // Robot.intake.liftDown();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !OI.joy2.getRawButton(3);
    }


  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.intake.intakeStop();
    // Robot.intake.liftStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.intake.intakeStop();
    // Robot.intake.liftStop();
  }
}
