/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  /**
   * Creates a new DrivetrainSubystem.
   */
  DifferentialDrive m_drive;
  private final Talon m_frontLeft;
  private final Talon m_frontRight;
  private final Talon m_backLeft;
  private final Talon m_backRight;

  public DrivetrainSubsystem() {
    
    m_frontLeft = new Talon(0);
    m_frontRight = new Talon(1);
    m_backLeft = new Talon(2);
    m_backRight = new Talon(3);
    SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_backLeft);
    SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight, m_backRight);
    m_drive = new DifferentialDrive(left, right);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
  public void Drive(double y, double twist){
    m_drive.arcadeDrive(y,twist);
  }
}
