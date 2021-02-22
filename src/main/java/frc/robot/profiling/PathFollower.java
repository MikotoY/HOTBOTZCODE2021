// package frc.robot.profiling;

// import frc.robot.Robot;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import jaci.pathfinder.Trajectory;

// public class PathFollower {
//     ProfileFollower parFollower, perpFollower, rotFollower;
//     SwerveTrajectory trajectory;
//     int currentWaypoint;
//     long startTime;

//     public PathFollower() {
//         this.rotFollower = new ProfileFollower(.00225, 0, 0.005, 0, 0.0005);
//         this.parFollower = new ProfileFollower(.00575, 0.002, 0.125, 0, 0.002);
//         this.perpFollower = new ProfileFollower(0, 0, 0.0001, 0, 0.0);
//         if (!SmartDashboard.containsKey("zP"))
//             SmartDashboard.putNumber("zP", rotFollower.kP);
//         if (!SmartDashboard.containsKey("zD"))
//             SmartDashboard.putNumber("zD", rotFollower.kD);
//         if (!SmartDashboard.containsKey("zV"))
//             SmartDashboard.putNumber("zV", rotFollower.kV);
//         if (!SmartDashboard.containsKey("parP"))
//             SmartDashboard.putNumber("parP", parFollower.kP);
//         if (!SmartDashboard.containsKey("parD"))
//             SmartDashboard.putNumber("parD", parFollower.kD);
//         if (!SmartDashboard.containsKey("perpP"))
//             SmartDashboard.putNumber("perpP", perpFollower.kP);
//         if (!SmartDashboard.containsKey("perpD"))
//             SmartDashboard.putNumber("perpD", perpFollower.kD);
//     }

//     private double totalTime(Trajectory t) {
//         return t.get(0).dt * (t.length() - 1);
//     }

//     public Trajectory.Segment currentSegment(double t) {
//         if (trajectory == null) return null;
//         try {
//             return trajectory
//                     .get((int) Math.round(t / totalTime(trajectory) * trajectory.length()));
//         } catch (IndexOutOfBoundsException e) {
//             return trajectory.get(trajectory.length() - 1);
//         }
//     }

//     public void startTrajectory(SwerveTrajectory t) {
//         rotFollower.kP = SmartDashboard.getNumber("zP", rotFollower.kP);
//         rotFollower.kD = SmartDashboard.getNumber("zD", rotFollower.kD);
//         rotFollower.kV = SmartDashboard.getNumber("zV", rotFollower.kV);
//         parFollower.kP = SmartDashboard.getNumber("parP", parFollower.kP);
//         parFollower.kD = SmartDashboard.getNumber("parD", parFollower.kD);
//         perpFollower.kP = SmartDashboard.getNumber("perpP", perpFollower.kP);
//         perpFollower.kD = SmartDashboard.getNumber("perpD", perpFollower.kD);
//         trajectory = t;
//         startTime = System.nanoTime();
//         currentWaypoint = 0;

//         parFollower.resetPID();
//         perpFollower.resetPID();
//         rotFollower.resetPID();
//     }

//     public void update() {
//         if (isFinished()) {
//             Robot.swerve.driveField(0, 0, 0);
//             return;
//         } else {
//             double t = (System.nanoTime() - startTime) / 1e9;

//             // update translational motion
//             Trajectory.Segment seg = currentSegment(t);
//             double sin = Math.sin(seg.heading);
//             double cos = Math.cos(seg.heading);
//             double xErr = seg.x - Robot.path.currentX;
//             double yErr = seg.y - Robot.path.currentY;
//             // rotate (x,y) by -heading to get (par,perp)
//             double parErr = xErr * cos + yErr * sin;
//             double perpErr = -xErr * sin + yErr * cos;

//             double parPower = parFollower.update(0, parErr, seg.velocity, seg.acceleration);
//             double perpPower = perpFollower.update(0, perpErr, 0, 0);

//             // rotate (par,perp) by heading to get (x,y)
//             double xPower = parPower * cos - perpPower * sin;
//             double yPower = parPower * sin + perpPower * cos;

//             // update rotational motion
//             if (t >= trajectory.waypointTime[currentWaypoint + 1]
//                     && currentWaypoint < trajectory.waypoints.length - 2) {
//                 currentWaypoint++;
//             }
//             MotionProfile rotProfile = trajectory.gyroProfile[currentWaypoint];
//             double rotProfileTime = t - trajectory.waypointTime[currentWaypoint];
//             double rotPower = rotFollower.update(Robot.path.currentZ, 
//                                                  rotProfile.currentP(rotProfileTime),
//                                                  rotProfile.currentV(rotProfileTime),
//                                                  rotProfile.currentA(rotProfileTime));

//             Robot.swerve.driveField(xPower, yPower, rotPower);
//         }
//     }

//     public void cancel() {
//         trajectory = null;
//     }

//     public boolean isFinished() {
//         return trajectory == null || (System.nanoTime() - startTime) / 1e9 > totalTime(trajectory);
//     }
// }
