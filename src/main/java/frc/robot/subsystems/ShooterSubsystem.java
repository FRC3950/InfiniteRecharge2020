/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsystem.
   */
  public final WPI_TalonSRX m_shooterMotor;
  public final WPI_TalonSRX m_shooterMotorFollower;
  // public final WPI_TalonFX m_shooterPractice;
  public ShooterSubsystem() {
    // m_shooterPractice = new WPI_TalonFX(0);
    m_shooterMotor = new WPI_TalonSRX(4);
    m_shooterMotorFollower = new WPI_TalonSRX(5);
    m_shooterMotor.setInverted(true);
    m_shooterMotorFollower.setInverted(true);
    m_shooterMotor.setSensorPhase(true);
    
    m_shooterMotorFollower.follow(m_shooterMotor);
    
   
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
 // MOVE TO TURRET  
  // public int getInitPos(){
  //   int initPos = m_shooterMotor.getSelectedSensorPosition();
  //   System.out.println("Init pos" + initPos);
  //   return initPos;
  // }
  public double getEncoder(){
    return m_shooterMotor.getSelectedSensorVelocity(0);
  }
  public double getRPM(){
    return ((getEncoder() / 4096) * 600);
  }


}
