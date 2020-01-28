/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Yo look at this bot it's pretty cool my dude 

package frc.robot.commands;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class PIDShooterCommand extends PIDCommand {
  /**
   * Creates a new PIDShooterControl.
   */
  private final ShooterSubsystem m_shooterSubsystem;
  public PIDShooterCommand(ShooterSubsystem s) {
    super(
        // The controller that the command will use
        new PIDController(1.5, 7.5, .075),
        // This should return the measurement
        () -> -s.getEncoder(),
        // This should return the setpoint (can also be a constant)
        () -> 10000,
        // This uses the output
        output -> {
          // Use the output here
          //output *= .8;
          // if(output < 0){
          //   output *= -1;
          // }
          output = remap(output, -4096.0 * 3, 4096.0 * 3,-1.0,1.0);
          if(output > 1){
            output = 1;
          }
          if (output < -1){
            output = -1;
          }
          s.m_shooterMotor.set(output);
          
          System.out.println(output);
          System.out.println(s.getEncoder());
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    m_shooterSubsystem = s;
    addRequirements(m_shooterSubsystem);    
  }

  // Returns true when the command should end.
  public boolean isFinished() {
    return false;
  }
  @Override
  public void end(boolean interrupted){
    m_shooterSubsystem.m_shooterMotor.set(0);
  }
  public static double remap(double value, double  from1, double to1, double from2, double to2){
    return (value - from1) / (to1 - from1) * (to2 - from2) + from2;
  }
}
