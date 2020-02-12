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
import frc.robot.commands.DriveCommand;

public class DrivetrainSubsystem extends SubsystemBase {
  /**
   * Creates a new DrivetrainSubystem.
   */
  private final WPI_TalonFX m_frontLeft = new WPI_TalonFX(20);
  private final WPI_TalonFX m_frontRight = new WPI_TalonFX(21);
  private final WPI_TalonFX m_backLeft = new WPI_TalonFX(23);
  private final WPI_TalonFX m_backRight = new WPI_TalonFX(22);
  private final DoubleSolenoid m_shiftGearSolenoid = new DoubleSolenoid(6, 7);
  
  
  DifferentialDrive m_drive;

  private final Joystick driveStick = new Joystick(0);

  public DrivetrainSubsystem() {

    final SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_backLeft);
    final SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight, m_backRight);
    m_drive = new DifferentialDrive(left, right);
    m_drive.setSafetyEnabled(false);    

    // m_frontLeft.setNeutralMode(NeutralMode.Brake);
    // m_frontRight.setNeutralMode(NeutralMode.Brake);
    // m_backLeft.setNeutralMode(NeutralMode.Brake);
    // m_backRight.setNeutralMode(NeutralMode.Brake);
    m_drive.arcadeDrive(driveStick.getY(), driveStick.getTwist());

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //Drives the robot based on joystick values
  public void drive(double x, double twist){
    // y = y * y * y;
    // x = x * x * x;
    //Might need to create a dead band for the direction and rotation
    m_drive.arcadeDrive(x, twist);
  }

  //Sets the motor to a certain speed without the joystick 
  //Used for Autonomous Code
  public void motorSpeed(){
    m_drive.arcadeDrive(.5,0);
  }

  //Makes sure that if the drivetrain motors ever exceed 55 Amps the gear will automatically shift to low gear
  public void overrideShiftGear(){
    if(m_frontLeft.getStatorCurrent() >= 55){
      m_shiftGearSolenoid.set(DoubleSolenoid.Value.kReverse);
      // check to see if double solenoid should be kReverse or kForward
    }
  }

  //Allows the driver to switch between high and low gear
  public void shiftGear(){ //ADD TO A BUTTON
    if(m_shiftGearSolenoid.get() == DoubleSolenoid.Value.kReverse){
      m_shiftGearSolenoid.set(DoubleSolenoid.Value.kForward);
    } else{
    m_shiftGearSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }

  //Gets the position of one of the drivetrain motors from the encoder
  public int getEncoderCount(){
    return m_backLeft.getSelectedSensorPosition();
  }
}
