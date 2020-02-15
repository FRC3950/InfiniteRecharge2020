/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallCounterSubsystem;
import frc.robot.subsystems.BallManipulatorSubsystem;

public class BallManipulateCommand extends CommandBase {
  /**
   * Creates a new BallManipulateCommand.
   */
  public BallManipulatorSubsystem m_ballManipulatorSubsystem;
  public BallCounterSubsystem m_ballCounterSubsystem;
  int ballCount;
  String sensors;

  public BallManipulateCommand(BallManipulatorSubsystem ballManipulatorSubsystem, BallCounterSubsystem ballCounterSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_ballManipulatorSubsystem = ballManipulatorSubsystem;
    m_ballCounterSubsystem = ballCounterSubsystem;
    addRequirements(ballManipulatorSubsystem);
    SmartDashboard.putString("test" ,"");
    SmartDashboard.putString("sensor string", "");

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ballCount = m_ballCounterSubsystem.getBallsInRobot();
    sensors = m_ballCounterSubsystem.getSensorValues();
    SmartDashboard.putString("test" ,m_ballManipulatorSubsystem.manipulate(ballCount, sensors));
    SmartDashboard.putString("sensor string", sensors);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
