
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorSensorSubsystem;

public class ColorSpinNumberOfTimes extends CommandBase {
  /**
   * Creates a new ColorValueCommand.
   */
  private char color;
  private final ColorSensorSubsystem m_colorValueSubsystem;
  public ColorSpinNumberOfTimes(ColorSensorSubsystem colorValueSubsystem) {
    m_colorValueSubsystem = colorValueSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(colorValueSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //set the run motor to some speed
    color = m_colorValueSubsystem.getColor();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_colorValueSubsystem.spinNumberOfTimes(color);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_colorValueSubsystem.stopMotor();
    m_colorValueSubsystem.resetColorCounter(); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
