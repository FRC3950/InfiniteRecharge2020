/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LevelerSubsystem extends SubsystemBase {
  /**
   * Creates a new LevelerSubsystem.
   */

  private final WPI_TalonFX m_levelerMotor;
  
  public LevelerSubsystem() {
    m_levelerMotor = new WPI_TalonFX(4);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void levelRobot(){
    //NEED TO USE ACCELEROMETER to decide whether to move the motor positive or negative and for how long
    m_levelerMotor.set(.5);

  }
}
