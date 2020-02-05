/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /**
   * Creates a new IntakeSubsystem.
   */

  private final WPI_TalonSRX m_intakeMotor;
  private final WPI_TalonSRX m_singulatorMotor;

  private final DoubleSolenoid m_intakeLeftSolenoid;
  private final DoubleSolenoid m_intakeRightSolenoid;

  public IntakeSubsystem() {

    m_intakeMotor = new WPI_TalonSRX(3);
    m_singulatorMotor = new WPI_TalonSRX(11);

    m_intakeLeftSolenoid = new DoubleSolenoid(2, 3);
    m_intakeRightSolenoid = new DoubleSolenoid(4, 5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void intakeBall(){
    m_intakeMotor.set(.5);
  }
  public void singulatorMotor(){
    m_singulatorMotor.set(5);
  }
  public void intakeLift(){
    if(m_intakeLeftSolenoid.get() == DoubleSolenoid.Value.kReverse && m_intakeRightSolenoid.get() == DoubleSolenoid.Value.kReverse){
      m_intakeLeftSolenoid.set(DoubleSolenoid.Value.kForward);
      m_intakeRightSolenoid.set(DoubleSolenoid.Value.kForward);
    } else {
      m_intakeLeftSolenoid.set(DoubleSolenoid.Value.kReverse);
      m_intakeRightSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }

}
