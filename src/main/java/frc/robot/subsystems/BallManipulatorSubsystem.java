/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallManipulatorSubsystem extends SubsystemBase {
  /**
   * Creates a new BallManipulatorSubsystem.
   */

  private final WPI_TalonSRX m_horizontalBallManipulatorMotor;
  private final WPI_TalonSRX m_ballIndexerMotor;

  public BallManipulatorSubsystem() {

    m_horizontalBallManipulatorMotor = new WPI_TalonSRX(5);
    m_ballIndexerMotor = new WPI_TalonSRX(5);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //Sets the conveyer belt to a certain speed
  public void setHorizontalBallManipulator(double speed, int ballsInConveyer, boolean ballsInIndexer){
    if(ballsInConveyer > 0 && ballsInIndexer == false){
      m_horizontalBallManipulatorMotor.set(speed);
    }
  }
  
  //Sets the part of the robot that moves the ball from the conveyer belt to the shooter to a certain speed
  public void setBallIndexerMotor(double speed){
    m_ballIndexerMotor.set(speed);
  }

  //If there is a ball in the robot, try to get one ball into the indexer
  public void putBallInShooter(boolean ballInShooter, boolean ballInIndexer, double speed, int ballCount){
    if(ballInShooter == true && ballCount > 0){
      setBallIndexerMotor(0);
    }else if(ballInShooter == false && ballInIndexer == true && ballCount > 0){
      setBallIndexerMotor(.5);
    }else if(ballInShooter == false && ballInIndexer == false && ballCount > 0 ){
      setBallIndexerMotor(.5);    
    }
  }


  
}
