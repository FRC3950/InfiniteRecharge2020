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
    m_singulatorMotor = new WPI_TalonSRX(7);

    m_intakeLeftSolenoid = new DoubleSolenoid(2, 3);
    m_intakeRightSolenoid = new DoubleSolenoid(4, 5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //Sets the motor for the intake rollers to a certain speed
  public void setIntakeMotor(double speed){
    m_intakeMotor.set(speed);
  }

  //Sets the motor for the mecanum intake wheels to a certain speed
  //Should it be negative?
  public void setSingulatorMotor(double speed){
    m_singulatorMotor.set(speed);
  }

  //Allows the driver to raise or lower the intake with a button
  public boolean changeIntakePosition(){
    if(m_intakeLeftSolenoid.get() == DoubleSolenoid.Value.kReverse && m_intakeRightSolenoid.get() == DoubleSolenoid.Value.kReverse){
      m_intakeLeftSolenoid.set(DoubleSolenoid.Value.kForward);
      m_intakeRightSolenoid.set(DoubleSolenoid.Value.kForward);
    } else {
      m_intakeLeftSolenoid.set(DoubleSolenoid.Value.kReverse);
      m_intakeRightSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    return true;
  }

  //Sets the intake to a position based on a boolean value
  public void setIntakePosition(boolean upOrDown){
    if(upOrDown == true){
      m_intakeLeftSolenoid.set(DoubleSolenoid.Value.kForward);
      m_intakeRightSolenoid.set(DoubleSolenoid.Value.kForward);
    } else {
      m_intakeLeftSolenoid.set(DoubleSolenoid.Value.kReverse);
      m_intakeRightSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }

  //Checks whether the intake is in the raised position or the lowered position
  public boolean intakePosition(){
    if(m_intakeLeftSolenoid.get() == DoubleSolenoid.Value.kReverse && m_intakeRightSolenoid.get() == DoubleSolenoid.Value.kReverse){
      return true;
    } else {
     return false;
    }
  }

  public void reverseMotors(){
    m_singulatorMotor.set(-.5);
    m_intakeMotor.set(-.5);

  }

  public boolean intakeBalls(int ballCount, int ballInIntake, boolean intakePosition){
    if(ballCount == 4 && ballInIntake == 1){
      return true;
    } else if(intakePosition){
      return true;
    } else{
      setIntakeMotor(1);
      setSingulatorMotor(.5); 
      return false;  
    }
  }
}