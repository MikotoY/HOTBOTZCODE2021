// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands.auto;

// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.Robot;

// public class AutoForward extends Command {
//   public AutoForward() {
//     requires(Robot.swerve);
//   }

//   // Called just before this Command runs the first time
//   @Override
//   protected void initialize() {
//   }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   protected void execute() {
//     Robot.swerve.driveNormal(0, .5, 0);
//   }

//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   protected boolean isFinished() {
//    double dist = Robot.swerve.modules[1].getDistance();
//    //1 turn = 11 inches
//    //i turn = 25000
//    if (dist >= 85000) {
//      return true;   }
     

//      else {
//        return false;
//      }
   
//   }

//   // Called once after isFinished returns true
//   @Override
//   protected void end() {
//   }

//   // Called when another command which requires one or more of the same
//   // subsystems is scheduled to run
//   @Override
//   protected void interrupted() {
//   }
// }
