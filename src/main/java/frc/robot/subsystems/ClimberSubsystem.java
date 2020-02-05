/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {
  /**
   * Creates a new ClimberSubsystem.
   */
  private final WPI_TalonFX m_climberMotor;
  private final WPI_TalonFX m_climberMotorFollower;
  private final DoubleSolenoid m_climberSolenoid;
  private final DigitalInput m_climberLimitSwitch;
  
  public ClimberSubsystem() {
    
    m_climberMotor = new WPI_TalonFX(25);
    m_climberMotorFollower = new WPI_TalonFX(26);
    
    m_climberSolenoid = new DoubleSolenoid(0, 1);

    m_climberLimitSwitch = new DigitalInput(7);

    m_climberMotorFollower.follow(m_climberMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void toggleLockGear(){
    if (m_climberSolenoid.get() == DoubleSolenoid.Value.kForward){
      m_climberSolenoid.set(DoubleSolenoid.Value.kReverse);
    } else{
      m_climberSolenoid.set(DoubleSolenoid.Value.kForward);
    }

  }
  public void setLockGear(boolean s) {
    m_climberSolenoid.set(s ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse); //One line if statement
  }
  public void raiseClimber(){
    m_climberMotor.set(.5);
  }
  public void lowerClimber(){
    m_climberMotor.set(-.5);
  }
  public void turnOffClimber(){
    m_climberMotor.set(0);
  }
  public void isClimberAtTop(){
    if(m_climberMotor.getSelectedSensorPosition() >= 18000){ //NEED TO FIX WHEN WE TEST CLIMBER
    turnOffClimber();
    }
  }
  public void isLimitSwitchTrue(){
    if(m_climberLimitSwitch.get()){
      turnOffClimber();
    }
  }
}
