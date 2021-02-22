// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands.pneumatics;

// import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.OI;
// import frc.robot.Robot;
// import frc.robot.subsystems.Pneumatics;

// public class highliftsolenoid extends Command {
//   public highliftsolenoid() {
//     requires(Robot.pneumatics);
//   }

//   @Override
//   protected void initialize() {
//   }

//   @Override
//   protected void execute() {
//     Robot.pneumatics.highOut();
//     Robot.pneumatics.lowOut();
//   }


//   @Override
//   protected boolean isFinished() {
//     return !OI.joy2.getRawButton(6);
//   }

  
//   @Override
//   protected void end() {
//     Robot.pneumatics.highIn();
//     Robot.pneumatics.lowIn();
//   }

 
//   @Override
//   protected void interrupted() {
//     Robot.pneumatics.highIn();
//     Robot.pneumatics.lowIn();
//   }
// }
