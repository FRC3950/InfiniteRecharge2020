/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  /**
   * Creates a new DrivetrainSubsystem.
   */
  private final WPI_TalonFX m_frontLeft = new WPI_TalonFX(26);
  private final WPI_TalonFX m_frontRight = new WPI_TalonFX(21);
  private final WPI_TalonFX m_backLeft = new WPI_TalonFX(25);
  private final WPI_TalonFX m_backRight = new WPI_TalonFX(22);

  DifferentialDrive m_drive;

  // private final Joystick stick = new Joystick(0);

  public DrivetrainSubsystem() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    final SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_backLeft);
    final SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight, m_backRight);
    m_drive = new DifferentialDrive(left, right);
    m_drive.setSafetyEnabled(false);    
    m_frontLeft.setNeutralMode(NeutralMode.Brake);
    m_backLeft.setNeutralMode(NeutralMode.Brake);
    m_frontRight.setNeutralMode(NeutralMode.Brake);
    m_backRight.setNeutralMode(NeutralMode.Brake);

  
  }

   //Drives the robot based on joystick values
   public void drive(double y, double twist){
    // if (y < .25){
    //   y = 0;
    // }
    y = y * y * y;
    //Might need to create a dead band for the direction and rotation
    m_drive.arcadeDrive(y, twist);
  }
}
