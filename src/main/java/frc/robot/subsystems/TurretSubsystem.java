/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretSubsystem extends SubsystemBase {
  /**
   * Creates a new TurretSubsystem.
   */
  private final WPI_TalonSRX m_turretMotor;
  private final DigitalInput m_homePosition;
  private final DigitalInput m_maxPosition;

  public TurretSubsystem() {

    m_turretMotor = new WPI_TalonSRX(2);
    m_homePosition = new DigitalInput(0);
    m_maxPosition = new DigitalInput(1);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
