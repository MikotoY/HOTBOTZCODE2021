// package frc.robot.commands;

// import frc.robot.Robot;
// // import frc.robot.profiling.SwerveTrajectory;
// // import frc.robot.profiling.SwerveWaypoint;
// import com.revrobotics.CANSparkMax;

// import edu.wpi.first.wpilibj.command.Command;
// import jaci.pathfinder.Trajectory;

// public class PathCommand extends Command {
    
//     double speed = 192;
//     double acc = 120;
//     double rotVel = 180;
//     double angularAcc = 180;
//     SwerveWaypoint[] waypoints;
//     SwerveTrajectory traj;

//     public PathCommand(SwerveWaypoint... waypoints) {
//         requires(Robot.swerve); 
//         this.waypoints = waypoints;
//         Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_QUINTIC,
//                 Trajectory.Config.SAMPLES_LOW, 0.05, speed, acc, 100.0);
//         traj = SwerveTrajectory.generate(config, waypoints, rotVel, angularAcc);
//     }

//     public PathCommand(double speed, double acc, double rotVel, double angularAcc, SwerveWaypoint... waypoints) {
//         this.speed = speed;
//         this.acc = acc;
//         this.rotVel = rotVel;
//         this.angularAcc = angularAcc;
//         Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_QUINTIC,
//                 Trajectory.Config.SAMPLES_LOW, 0.05, speed, acc, 100.0);
//         traj = SwerveTrajectory.generate(config, waypoints, rotVel, angularAcc);
//     }

//     public void initialize() {
//         Robot.path.reset();
//         Robot.follower.startTrajectory(traj);
//     }

//     public void execute() {
//         Robot.follower.update();
//     }

//     @Override
//     protected boolean isFinished() {
//         return Robot.follower.isFinished();
//     }

//     public void end() {
//         Robot.swerve.driveNormal(0, 0, 0); 
//     }

//     public void cancel() {
//         Robot.follower.cancel();
//         Robot.swerve.driveNormal(0, 0, 0); 
//         super.cancel();
//     }
// }
