/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallCounterSubsystem extends SubsystemBase {
  /**
   * Creates a new BallCounterSubsystem.
   */
  private DigitalInput entryBallSensor;
  private DigitalInput indexerBallSensor;
  private DigitalInput shooterBallSensor;
  public int ballCount;
  private boolean ballInShooter;
  private boolean ballInIndexer;
  private int ballsInConveyer;
  private boolean previousEntryBallValue;
  private boolean previousShooterBallValue;
  private boolean indexerSensor;

  public BallCounterSubsystem() {
    entryBallSensor = new DigitalInput(1);
    indexerBallSensor = new DigitalInput(0);
    shooterBallSensor = new DigitalInput(2);

    ballCount = 0;
    ballInShooter = false;
    ballInIndexer = false;
    indexerSensor = false;
  }

  //Gets a value for the ball sensors every 50 ms
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Timer.delay(50);
    previousEntryBallValue = entryBallSensor.get();
    previousShooterBallValue = shooterBallSensor.get();
    indexerSensor = indexerBallSensor.get();
  }
  
  //returns the entry ball sensors value
  public boolean getEntryBallSensorValue(){
    return entryBallSensor.get();
  }

  //returns the shooter ball sensors value
  public boolean getShooterBallSensorValue(){
    return shooterBallSensor.get();
  }
  public void getIndexerBallSensorValue(){
    System.out.println(indexerSensor);
    //return indexerBallSensor.get();
  }


  //Determines how many balls are inside the robot by comparing the current sensor value to the previous sensor value with a 50 ms delay
  public void ballsInRobot(){
    if(getEntryBallSensorValue() && !previousEntryBallValue){
      ballCount++;
    }
    if(!shooterBallSensor.get() && previousShooterBallValue){
      ballCount--;
    }
  }

  //Returns the ball count inside the robot
  public int getBallsInRobot(int ballCount){
    return ballCount;
  }

  //Determines if there is a ball in the shooter 
  public boolean isBallInShooter(){
    if(shooterBallSensor.get()){
      ballInShooter = true;
    }else{
      ballInShooter = false;
    }
    return ballInShooter;
  }
  //Determines if there is a ball in the indexer 
  public boolean isBallInIndexer(){
    if(indexerBallSensor.get()){
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
