// package frc.robot.profiling;

// import jaci.pathfinder.Pathfinder;
// import jaci.pathfinder.Trajectory;

// public class SwerveTrajectory extends Trajectory {
//     double[] waypointTime;
//     SwerveWaypoint[] waypoints;
//     double angularVelocity;
//     double angularAcc;
//     TrapezoidProfile[] gyroProfile;

//     public static SwerveTrajectory generate(Trajectory.Config config, SwerveWaypoint[] waypoints,
//             double angularVelocity, double angularAcc) {
//         SwerveTrajectory trajectory;
//         trajectory = new SwerveTrajectory(Pathfinder.generate(waypoints, config));
//         trajectory.waypoints = waypoints;
//         trajectory.angularVelocity = angularVelocity;
//         trajectory.angularAcc = angularAcc;

//         for (int i = 0; i < waypoints.length; i++) {
//             double shortdist = Math.hypot(trajectory.segments[0].x - waypoints[i].x,
//                     trajectory.segments[0].y - waypoints[i].y);

//             for (int j = 0; j < trajectory.segments.length; j++) {
//                 double dist = Math.hypot(trajectory.segments[j].x - waypoints[i].x,
//                         trajectory.segments[j].y - waypoints[i].y);
//                 if (dist <= shortdist) {
//                     shortdist = dist;
//                     trajectory.waypointTime[i] = j * trajectory.segments[j].dt;
//                 }
//             }
//         }
//         trajectory.gyroProfile[0] = new TrapezoidProfile(trajectory.waypoints[0].rotation,
//                 trajectory.waypoints[1].rotation, 0, 0, trajectory.angularVelocity, trajectory.angularAcc);
//         for (int i = 1; i < waypoints.length - 1; i++) {
//             double startPos = trajectory.gyroProfile[i - 1]
//                     .currentP(trajectory.waypointTime[i] - trajectory.waypointTime[i - 1]);
//             double startV = trajectory.gyroProfile[i - 1]
//                     .currentV(trajectory.waypointTime[i] - trajectory.waypointTime[i - 1]);
//             double endPos = trajectory.waypoints[i + 1].rotation;
//             trajectory.gyroProfile[i] = new TrapezoidProfile(startPos, endPos, startV, 0, trajectory.angularVelocity,
//                     trajectory.angularAcc);
//         }
//         return trajectory;
//     }

//     public SwerveTrajectory(Trajectory trajectory) {
//         super(trajectory.segments);
//         waypointTime = new double[trajectory.segments.length];
//         gyroProfile = new TrapezoidProfile[trajectory.segments.length];
//         // TODO Auto-generated constructor stub
//     }
// }