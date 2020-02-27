/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.analog.adis16470.frc.ADIS16470_IMU;

public class LevelerSubsystem extends SubsystemBase {
  /**
   * Creates a new LevelerSubsystem.
   */
  public static final ADIS16470_IMU imu = new ADIS16470_IMU();

  private final WPI_TalonFX m_levelerMotor;
  
  public LevelerSubsystem() {
    m_levelerMotor = new WPI_TalonFX(4);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  //Uses the accelerometer values to turn on the leveler motors to level the bar
  public void levelRobot(){
    //NEED TO USE ACCELEROMETER to decide whether to move the motor positive or negative and for how long
    if(imu.getAngle() > 3){
      m_levelerMotor.set(.1);
    } else if(imu.getAngle() < 3){
      m_levelerMotor.set(-.1);
    } else {
      m_levelerMotor.set(0);
    }
    

  }
}
