/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import frc.robot.subsystems.ColorSensorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterPracticeCommand extends CommandBase {
  /**
   * Creates a new ShooterPracticeCommand.
   */
  
  private final ShooterSubsystem m_shooterSubsystem;
  public ShooterPracticeCommand(ShooterSubsystem shooterSubsystem) {
    m_shooterSubsystem = shooterSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
    m_shooterSubsystem.m_shooterMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0, 0);
    m_shooterSubsystem.m_shooterMotor.configMotionAcceleration(10000);
    m_shooterSubsystem.m_shooterMotor.configMotionCruiseVelocity(30000);
    m_shooterSubsystem.m_shooterMotor.selectProfileSlot(0, 0);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // int position = m_shooterSubsystem.getInitPos();
    // System.out.println(position);
    // m_shooterSubsystem.m_shooterMotor.setSelectedSensorPosition(position + 1024);
    //System.out.println("Expected Motor Velocity" + m_shooterSubsystem.m_shooterMotor.get());
    // m_shooterSubsystem.m_shooterMotor.set(1);
    System.out.println("Motor velocity: " + m_shooterSubsystem.getEncoder());
    //m_shooterSubsystem.m_shooterMotor.set(ControlMode.MotionMagic, -10000);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooterSubsystem.m_shooterMotor.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
