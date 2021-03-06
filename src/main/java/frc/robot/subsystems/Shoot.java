/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Shoot extends Subsystem {
  VictorSP shootMotor = new VictorSP(3);


public void shootForward() {
  shootMotor.set(1);
}

public void shootStop() {
  shootMotor.set(0);
}

  @Override
  public void initDefaultCommand() {
  }
}