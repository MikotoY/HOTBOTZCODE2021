// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// // package frc.robot.commands.pneumatics;

// // import edu.wpi.first.wpilibj.command.Command;

// // public class lowliftsolenoid extends Command {
// //   public lowliftsolenoid() {
// //     // Use requires() here to declare subsystem dependencies
// //     // eg. requires(chassis);
// //   }

// //   // Called just before this Command runs the first time
// //   @Override
// //   protected void initialize() {
// //   }

// //   // Called repeatedly when this Command is scheduled to run
// //   @Override
// //   protected void execute() {
// //   }

// //   // Make this return true when this Command no longer needs to run execute()
// //   @Override
// //   protected boolean isFinished() {
// //     return false;
// //   }

// //   // Called once after isFinished returns true
// //   @Override
// //   protected void end() {
// //   }

// //   // Called when another command which requires one or more of the same
// //   // subsystems is scheduled to run
// //   @Override
// //   protected void interrupted() {
// //   }
// // }


// package frc.robot.commands.pneumatics;

// import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.OI;
// import frc.robot.Robot;
// import frc.robot.subsystems.Pneumatics;

// public class lowliftsolenoid extends Command {
//   public lowliftsolenoid() {
//     requires(Robot.pneumatics);
//   }

//   @Override
//   protected void initialize() {
//   }

//   @Override
//   protected void execute() {
//     Robot.pneumatics.lowOut();
//   }


//   @Override
//   protected boolean isFinished() {
//     return !OI.joy2.getRawButton(4);
//   }

  
//   @Override
//   protected void end() {
//     Robot.pneumatics.lowIn();
//   }

 
//   @Override
//   protected void interrupted() {
    
//   }
// }