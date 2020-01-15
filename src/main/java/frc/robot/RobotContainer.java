/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LimelightSkewCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
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
  private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  private final LimelightSubsystem m_limelightSubsystem = new LimelightSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final DriveCommand m_driveCommand = new DriveCommand(m_drivetrainSubsystem);
  private final LimelightSkewCommand m_limelightSkewCommand = new LimelightSkewCommand(m_limelightSubsystem);

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
    
    
  }

/**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driveStick1Button.whenPressed(m_limelightSkewCommand);
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
