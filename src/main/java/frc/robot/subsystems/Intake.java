/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Spark;


import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  VictorSP wheelMotor = new VictorSP(1);
  // VictorSP winchMotor = new VictorSP(2); 
  VictorSP shootMotor = new VictorSP(3);


  // public Colorwheel() {
  //   super();
  // }
  

public void intakeIn() {
  wheelMotor.set(1);
}

public void intakeOut() {
  wheelMotor.set(-1);

}

public void intakeStop() {
  wheelMotor.set(0);
}

// public void liftUp() {
//   liftMotor.set(1);
// }

// public void liftDown() {
//   liftMotor.set(-1);
// }

// public void liftStop() {
//   liftMotor.set(0);
// }

public void shootForward() {
  shootMotor.set(1);
}

public void shootStop() {
  shootMotor.set(0);
}

// public void winchUp() {
//   winchMotor.set(1);
// }

// public void winchStop() {
//   winchMotor.set(0);
// }

// public void winchDown() {
//   winchMotor.set(-1);
// }
// Commented out Temp Winch

  @Override
  public void initDefaultCommand() {
  }
}
  //   Set the default command for a subsystem here.
  //   setDefaultCommand(new MySpecialCommand());
  // }

// public void liftUp() {
// }
// }
