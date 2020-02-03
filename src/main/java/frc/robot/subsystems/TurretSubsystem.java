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
  private final DigitalInput m_leftPosition;
  private final DigitalInput m_rightPosition;
/** Hey guys whats up hally here yall are dumb haha bye */
  public TurretSubsystem() {

    m_turretMotor = new WPI_TalonSRX(2);
    m_leftPosition = new DigitalInput(0);
    m_rightPosition = new DigitalInput(1);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void turretSpin(){
    m_turretMotor.set(.5);
  }
  public void turretLimit(){
  if(m_leftPosition.get() == true){
    m_turretMotor.set(0);
  } if (m_rightPosition.get() == true){
    m_turretMotor.set(0);
  }
  }
  public void setRelativeAngle(double offset){
    if (offset > 1){
      m_turretMotor.set(.15);
    } else if(offset < -1){
      m_turretMotor.set(-.15);
    }else{
      m_turretMotor.set(0);
    }
  }
}
