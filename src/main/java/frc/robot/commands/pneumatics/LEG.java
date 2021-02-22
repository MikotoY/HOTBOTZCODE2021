//  /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands.pneumatics;

// import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.Robot;
// import frc.robot.OI;

// public class LEG extends Command {
//   public LEG() {
//     requires(Robot.pneumatics);
//   }

//   @Override
//   protected void initialize() {
//     Robot.pneumatics.legOut();
//   }

//   @Override
//   protected void execute() {
   
//   }


//   @Override
//   protected boolean isFinished() {
//     return !OI.joy2.getRawButton(2);
//   }

  
//   @Override
//   protected void end() {
//     Robot.pneumatics.legIn();
//   }

 
//   @Override
//   protected void interrupted() {
//     Robot.pneumatics.legIn();
//   }
// }
