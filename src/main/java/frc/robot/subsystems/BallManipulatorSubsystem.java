/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallManipulatorSubsystem extends SubsystemBase {
  /**
   * Creates a new BallManipulatorSubsystem.
   */

  private final WPI_TalonSRX m_horizontalBallManipulatorMotor;
  private final WPI_TalonSRX m_verticalBallManipulatorMotor;
  private final AnalogInput m_ballPositionSensor;

  public BallManipulatorSubsystem() {

    m_horizontalBallManipulatorMotor = new WPI_TalonSRX(5);
    m_verticalBallManipulatorMotor = new WPI_TalonSRX(5);

    m_ballPositionSensor = new AnalogInput(0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void horizontalBallManipulator(){
    m_horizontalBallManipulatorMotor.set(.5);
  }
  public void verticalBallManipulator(){
    m_verticalBallManipulatorMotor.set(.5);
  }
}
