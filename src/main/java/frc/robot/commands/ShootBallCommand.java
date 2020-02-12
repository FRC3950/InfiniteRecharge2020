/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallCounterSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootBallCommand extends CommandBase {
  /**
   * Creates a new ShootBallCommand.
   */

  private final ShooterSubsystem m_shooterSubsystem;
  BallCounterSubsystem m_ballCounterSubsystem;
  LimelightSubsystem m_limelightSubsytem;

  public ShootBallCommand(ShooterSubsystem shooterSubsystem) {
    m_shooterSubsystem = shooterSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooterSubsystem);
    // addRequirements(ballCounterSubsystem);
    // addRequirements(limelightSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // boolean ballInShooter = m_ballCounterSubsystem.isBallInShooter();
    // double speed = m_shooterSubsystem.setShooterSpeed(m_limelightSubsytem.calculateDistance());
    // m_shooterSubsystem.shootBall(ballInShooter, speed);
    m_shooterSubsystem.shootBall(true, -1);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooterSubsystem.shootBall(false,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
