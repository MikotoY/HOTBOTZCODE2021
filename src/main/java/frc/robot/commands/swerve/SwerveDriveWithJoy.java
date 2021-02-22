package frc.robot.commands.swerve;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;

public class SwerveDriveWithJoy extends Command {
    public SwerveDriveWithJoy() {
        requires(Robot.swerve);
    }

    @Override
    public void execute() {
        // NetworkTable table = NetworkTableInstance.getDefault().getTable("chameleon-vision").getSubTable("USB Camera-B4.09.24.1");

       

        // NetworkTableEntry yaw = table.getEntry("targetYaw");
    //     double yawdub = yaw.getDouble(0);

      

    //   if (OI.joy1.getRawButton(10)) {
    //          if (yawdub < 0) {
    //             Robot.swerve.moveLWithCam();
    //          }
    //          else if (yawdub > 0) {

    //             Robot.swerve.moveRWithCam();
    //          }

             
    //   }
    //   else {
        Robot.swerve.move();

         }

    
// }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end() {
        Robot.swerve.driveNormal(0, 0, 0);
    }
}