// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.subsystems;

// import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.wpilibj.command.Command;
// import edu.wpi.first.wpilibj.networktables.NetworkTable;

// public class NetworkTables extends Command {
//   public NetworkTables() {
//     // Use requires() here to declare subsystem dependencies
//     // eg. requires(chassis);
//   }

//   // Called just before this Command runs the first time
//   @Override
//   protected void initialize() {
//     NetworkTableInstance inst = 
//     NetworkTableInstance.getDefault();
//     edu.wpi.first.networktables.NetworkTable table = 
//     inst.getTable("table");
//     NetworkTableEntry entry = 
//     table.getEntry("Success"); 
//   }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   protected void execute() {
//   }

//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   protected boolean isFinished() {
//     return false;
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
