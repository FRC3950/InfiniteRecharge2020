/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallCounterSubsystem;
import frc.robot.subsystems.BallManipulatorSubsystem;

public class BallHorizontalManipulatorCommand extends CommandBase {
  /**
   * Creates a new BallHorizontalManipulator.
   */

  public BallManipulatorSubsystem m_ballManipulatorSubsystem;
  public BallCounterSubsystem m_ballCounterSubsystem;

  public BallHorizontalManipulatorCommand(BallManipulatorSubsystem ballManipulatorSubsystem, BallCounterSubsystem ballCounterSubsystem) {
    m_ballManipulatorSubsystem = ballManipulatorSubsystem;
    m_ballCounterSubsystem = ballCounterSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ballManipulatorSubsystem);
    addRequirements(ballCounterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = .5;
    int ballsInConveyer = m_ballCounterSubsystem.ballsInConveyer();
    boolean ballsInIndexer = m_ballCounterSubsystem.isBallInIndexer();
    m_ballManipulatorSubsystem.setHorizontalBallManipulator(speed, ballsInConveyer, ballsInIndexer);
    
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
