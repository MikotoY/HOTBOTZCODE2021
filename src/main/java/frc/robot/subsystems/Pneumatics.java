/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
// import frc.robot.commands.pneumatics.lowliftsolenoid;
/**
 * Add your docs here.
 */



public class Pneumatics extends Subsystem {
 //asdf 
  Compressor c = new Compressor(0);
  // Solenoid lowliftSolenoid = new Solenoid(1);
  // Solenoid highliftSolenoid = new Solenoid(2);
  Solenoid tiltSolenoid = new Solenoid(0);
  // Solenoid legSolenoid = new Solenoid(5);
  // Solenoid balltiltSolenoid = new Solenoid(3);
  // public boolean lowOn = false;
  // public boolean lowOnn = false;

  

  public Pneumatics() {
    super();
  }

  

  // public void reverseLEG() {
  //   lowOnn =! lowOnn;
  // }

  // public void reverseLow() {
  //   lowOn =! lowOn;
  // }
//   public void lowIn() {
//     lowliftSolenoid.set(false);
//   }

//   public void lowOut() {
//     lowliftSolenoid.set(true);
//   }


// //HIGH
//   public void highIn() {
//     highliftSolenoid.set(false);
//   }

//   public void highOut() {
//     highliftSolenoid.set(true);
//   }


//TILT
  public void tiltIn() {
    tiltSolenoid.set(false);
  }

  public void tiltOut() {
    tiltSolenoid.set(true);
  }


//BALLTILT
//   public void balltiltIn() {
//     balltiltSolenoid.set(false);
//   }

//   public void balltiltOut() {
//     balltiltSolenoid.set(true);
//   }


// //LEGS
//   public void legIn() {
//     legSolenoid.set(false);
//   }

//   public void legOut() {
//     legSolenoid.set(true);
//   }


  //COMRPESSOR
  public void compressorOn() {
    c.setClosedLoopControl(true);
  }

  public void compressorOff() {
    c.setClosedLoopControl(false);
  }

  

  @Override
  public void initDefaultCommand() {
   // setDefaultCommand(new lowliftsolenoid());
  }
}
