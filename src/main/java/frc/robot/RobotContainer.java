/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.analog.adis16470.frc.ADIS16470_IMU;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.BallManipulateCommand;
import frc.robot.commands.BallOverrideCommand;
import frc.robot.commands.ClimberLowerCommand;
import frc.robot.commands.ClimberRaiseCommand;
import frc.robot.commands.ColorSpinNumberOfTimes;
import frc.robot.commands.ColorSpinToColor;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveShiftGearCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeBallCommand;
import frc.robot.commands.IntakeLiftCommand;
import frc.robot.commands.ShootBallCommand;
import frc.robot.subsystems.BallCounterSubsystem;
import frc.robot.subsystems.BallManipulatorSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ColorSensorSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LevelerSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TurretSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public final BallCounterSubsystem m_ballCounterSubsystem = new BallCounterSubsystem();
  public final BallManipulatorSubsystem m_ballManipulatorSubsystem = new BallManipulatorSubsystem();
  public final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
  public final ColorSensorSubsystem m_colorSensorSubsystem = new ColorSensorSubsystem();
  public final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  public final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  public final LevelerSubsystem m_levelerSubsystem = new LevelerSubsystem();
  public final LimelightSubsystem m_limelightSubsystem = new LimelightSubsystem();
  public final ShooterSubsystem m_shooterSubsystem  = new ShooterSubsystem();
  public final TurretSubsystem m_turretSubsystem = new TurretSubsystem();

  //public final AutoDriveCommand m_autoDriveCommand = new AutoDriveCommand(m_drivetrainSubsystem);
  public final BallOverrideCommand m_ballOverrideCommand = new BallOverrideCommand(m_ballManipulatorSubsystem, m_ballCounterSubsystem, m_intakeSubsystem);
  public final BallManipulateCommand m_ballManipulateCommand = new BallManipulateCommand(m_ballManipulatorSubsystem, m_ballCounterSubsystem);
  public final ClimberLowerCommand m_climberLowerCommand = new ClimberLowerCommand(m_climberSubsystem);
  public final ClimberRaiseCommand m_climberRaiseCommand = new ClimberRaiseCommand(m_climberSubsystem);
  public final ColorSpinNumberOfTimes m_colorSpinNumberOfTimes = new ColorSpinNumberOfTimes(m_colorSensorSubsystem);
  public final ColorSpinToColor m_colorSpinToColor = new ColorSpinToColor(m_colorSensorSubsystem);
  public final DriveCommand m_driveCommand = new DriveCommand(m_drivetrainSubsystem);
  public final DriveShiftGearCommand m_driveShiftGearCommand = new DriveShiftGearCommand(m_drivetrainSubsystem);
  public final IntakeBallCommand m_intakeBallCommand = new IntakeBallCommand(m_intakeSubsystem, m_ballCounterSubsystem);
  public final IntakeLiftCommand m_intakeLiftCommand = new IntakeLiftCommand(m_intakeSubsystem);
  public final ShootBallCommand m_shootBallCommand = new ShootBallCommand(m_shooterSubsystem, 
      m_ballManipulatorSubsystem, m_ballCounterSubsystem, m_intakeSubsystem, m_limelightSubsystem, m_turretSubsystem);
  // public final TurretSetAngleCommand m_turretSetAngleCommand = new TurretSetAngleCommand(m_limelightSubsystem, m_turretSubsystem);
  // public final TurretSpinCommand m_turretSpinCommand = new TurretSpinCommand(m_turretSubsystem);
    
    public Joystick driveStick = new Joystick(0);
    public XboxController xboxController = new XboxController(1);

    public Button driveStick1Button = new JoystickButton(driveStick, 1);
    public Button driveStick2Button = new JoystickButton(driveStick, 2);
    public Button driveStick3Button = new JoystickButton(driveStick, 3);
    public Button driveStick4Button = new JoystickButton(driveStick, 4);
    public Button driveStick5Button = new JoystickButton(driveStick, 5);
    public Button driveStick6Button = new JoystickButton(driveStick, 6);
    public Button driveStick7Button = new JoystickButton(driveStick, 7);
    public Button driveStick8Button = new JoystickButton(driveStick, 8);
    public Button driveStick9Button = new JoystickButton(driveStick, 9);
    public Button driveStick10Button = new JoystickButton(driveStick, 10);
    public Button driveStick11Button = new JoystickButton(driveStick, 11);
    public Button driveStick12Button = new JoystickButton(driveStick, 12);  
  
    public Button xboxControllerAButton = new JoystickButton(xboxController, 1);
    public Button xboxControllerBButton = new JoystickButton(xboxController, 2);
    public Button xboxControllerXButton = new JoystickButton(xboxController, 3);
    public Button xboxControllerYButton = new JoystickButton(xboxController, 4);
    public Button xboxControllerLBButton = new JoystickButton(xboxController, 5);
    public Button xboxControllerRBButton = new JoystickButton(xboxController, 6);  
    public Button xboxControllerBackButton = new JoystickButton(xboxController, 7);
    public Button xboxControllerStartButton = new JoystickButton(xboxController, 8);
    public Button xboxControllerLeftStickButton = new JoystickButton(xboxController, 9);
    public Button xboxControllerRightStickButton = new JoystickButton(xboxController, 10);
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();    
    CommandScheduler.getInstance().setDefaultCommand(m_drivetrainSubsystem, m_driveCommand);
    CommandScheduler.getInstance().setDefaultCommand(m_ballManipulatorSubsystem, m_ballManipulateCommand);
  }

/**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    xboxControllerAButton.whenPressed(m_colorSpinToColor);
    xboxControllerBButton.whenPressed(m_shootBallCommand);
    xboxControllerXButton.whenPressed(m_intakeLiftCommand);
    xboxControllerYButton.whenPressed(m_colorSpinNumberOfTimes);
    xboxControllerLBButton.whenPressed(m_climberLowerCommand);
    xboxControllerRBButton.whenPressed(m_climberRaiseCommand);
    xboxControllerStartButton.whenPressed(m_ballOverrideCommand);

    driveStick2Button.whenPressed(m_driveShiftGearCommand);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous00
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
