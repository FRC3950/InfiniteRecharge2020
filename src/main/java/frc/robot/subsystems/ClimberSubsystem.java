/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {
  /**
   * Creates a new ClimberSubsystem.
   */
  private final CANSparkMax m_climberMotor;
  private final CANSparkMax m_climberFollower;
  private final DoubleSolenoid m_climberSolenoid;
  public ClimberSubsystem() {
    
    m_climberMotor = new CANSparkMax(1, MotorType.kBrushless);
    m_climberFollower = new CANSparkMax(2, MotorType.kBrushless);

    m_climberSolenoid = new DoubleSolenoid(0, 1);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
