/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorMatch;

public class ColorSensorSubsystem extends SubsystemBase {
  /**
   * Creates a new ColorSensorSubsystem.
   */

  private final WPI_TalonSRX m_wheelSpinnerMotor;
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  private final ColorMatch m_colorMatcher = new ColorMatch();

  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  char colorChar;
  int colorCounter;

  public ColorSensorSubsystem() {

    m_wheelSpinnerMotor = new  WPI_TalonSRX(4); //Need to Change to appropriate value
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);   

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //Gets the color seen by the color sensor
  public char getColor() {
    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    if (match.color == kBlueTarget) {
      colorChar = 'B';
    } else if (match.color == kRedTarget) {
      colorChar = 'R';
    } else if (match.color == kGreenTarget) {
      colorChar = 'G';
    } else if (match.color == kYellowTarget) {
      colorChar = 'Y';
    } else {
      colorChar = 'U';
    }
    return colorChar;
  }

  // public boolean isColorCorrect(char c){
  //   if (DriverStation.getInstance().getGameSpecificMessage().length() < 1) {
  //     System.out.println("Field not detected");
  //     return true;
  //   }
  //   System.out.printf("color target: %c\n", DriverStation.getInstance().getGameSpecificMessage().charAt(0)); 
  //   return c == DriverStation.getInstance().getGameSpecificMessage().charAt(0);
  // }

  // Gets the desired color from the field and tells the code what that color is 
  public char getDesiredColor(){
    return DriverStation.getInstance().getGameSpecificMessage().charAt(0);
  }

  //Turns off the motor that spins the color wheel 
  public void stopMotor(){
    m_wheelSpinnerMotor.set(0);
  }

  //Turns on the spinner motor to a certain speed until it has reached the desired color 
  //Which is recieved from the getDesiredColor() Method
  public boolean spinToColor(char desiredColor){
    if(desiredColor == getColor()){
      stopMotor();
      return true;
    }else{
      m_wheelSpinnerMotor.set(.1);
      return false;
    }
  }

  //Turns on the spinner motor to a certain speed until it has spun a specified number of times 
  public boolean spinNumberOfTimes(char initialColor){
    while(colorCounter <= 8){ //Might want to change the number of times it has seen a color based on testing
      m_wheelSpinnerMotor.set(.3);//Need to set speed once we actually test on robot
      if(initialColor == getColor()){
        colorCounter++;
      }
      return false;
    }
    return true;
  }
  
  //Sets the counter used to determine how many rotations the spinner has made back to zero
  public void resetColorCounter(){
    colorCounter = 0;
  }
}
