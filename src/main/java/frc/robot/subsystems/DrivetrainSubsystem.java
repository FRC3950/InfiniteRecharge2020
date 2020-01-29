/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  /**
   * Creates a new DrivetrainSubystem.
   */
  DifferentialDrive m_drive;
  private final WPI_TalonFX m_frontLeft;
  private final WPI_TalonFX m_frontRight;
  private final WPI_TalonFX m_backLeft;
  private final WPI_TalonFX m_backRight;
  private final DoubleSolenoid m_shiftGearSolenoid;
  
  public Joystick driveStick = new Joystick(0);

  public DrivetrainSubsystem() {
    
    m_frontLeft = new WPI_TalonFX(0);
    m_frontRight = new WPI_TalonFX(1);
    m_backLeft = new WPI_TalonFX(2);
    m_backRight = new WPI_TalonFX(3);

    m_shiftGearSolenoid = new DoubleSolenoid(6, 7);

    SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_backLeft);
    SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight, m_backRight);
    m_drive = new DifferentialDrive(left, right);

    m_frontLeft.setNeutralMode(NeutralMode.Brake);
    m_frontRight.setNeutralMode(NeutralMode.Brake);
    m_backLeft.setNeutralMode(NeutralMode.Brake);
    m_backRight.setNeutralMode(NeutralMode.Brake);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void Drive(double y, double twist){
    m_drive.arcadeDrive(y,twist);
  }
  public void motorSpeed(){
    m_frontLeft.set(1);
  }

  public void overrideShiftGear(){
    if(m_frontLeft.getStatorCurrent() >= 55){
      m_shiftGearSolenoid.set(DoubleSolenoid.Value.kReverse);
      // check to see if double solenoid should be kReverse or kForward
    }
  }
  public void shiftGear(){ //ADD TO A BUTTON
    if(m_shiftGearSolenoid.get() == DoubleSolenoid.Value.kReverse){
      m_shiftGearSolenoid.set(DoubleSolenoid.Value.kForward);
    } else{
    m_shiftGearSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }
}
