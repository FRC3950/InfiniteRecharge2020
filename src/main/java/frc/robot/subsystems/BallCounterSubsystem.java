/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallCounterSubsystem extends SubsystemBase {
  /**
   * Creates a new BallCounterSubsystem.
   */
  private final AnalogInput entryBallSensor;
  private final AnalogInput indexerBallSensor;
  private final AnalogInput shooterBallSensor;
  private int ballCount;
  private boolean ballInShooter;
  private boolean ballInIndexer;
  private int ballsInConveyer;

  public BallCounterSubsystem() {
    entryBallSensor = new AnalogInput(0);
    indexerBallSensor = new AnalogInput(1);
    shooterBallSensor = new AnalogInput(2);

    ballCount = 0;
    ballInShooter = false;
    ballInIndexer = false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  //Determines how many balls are inside the robot
  public int ballsInRobot(){
    if(entryBallSensor.getVoltage() >= 4){
      ballCount++;
    }
    if(shooterBallSensor.getVoltage() >= 4){
      ballCount--;
    }
    return ballCount;
  }

  //Determines if there is a ball in the shooter 
  public boolean isBallInShooter(){
    if(shooterBallSensor.getVoltage() >= 4){
      ballInShooter = true;
    }else{
      ballInShooter = false;
    }
    return ballInShooter;
  }
  //Determines if there is a ball in the indexer 
  public boolean isBallInIndexer(){
    if(indexerBallSensor.getVoltage() >= 4){
      ballInIndexer = true;
    }else{
      ballInIndexer = false;
    }
    return ballInIndexer;
  }

  //Determines how many balls are in the conveyer belt 
  public int ballsInConveyer(){
    ballsInConveyer = ballCount;
    if(isBallInShooter()){
      ballsInConveyer--;
    }
    if(isBallInIndexer()){
      ballsInConveyer--;
    }
    return ballsInConveyer;
  }
}
