/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance; 

public class LimelightSubsystem extends SubsystemBase {
  /**
   * Creates a new LimelightSubsystem.
   */
  NetworkTable table;

  public LimelightSubsystem() {
    
    table = NetworkTableInstance.getDefault().getTable("limelight");
    

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    
    
  }
  public void getSkew(){
    
    NetworkTableEntry ts = table.getEntry("ts");
    double s = ts.getDouble(0);
    System.out.println("Skew: " + s);

  }

}
