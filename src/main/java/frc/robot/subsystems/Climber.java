/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  // Motors
  private CANSparkMax gantryMotor;
  private CANSparkMax climbMotor;

  // Sensors
  private CANDigitalInput climbMotorMinSwitch;

  /**
   * Creates a new Climber.
   */
  public Climber() { 
    // For initalization code
    gantryMotor = new CANSparkMax(Constants.CANIds.Gantry_Motor_Address, MotorType.kBrushless); // Creates a new motor
    gantryMotor.restoreFactoryDefaults();

    climbMotor = new CANSparkMax(Constants.CANIds.Lift_Motor_Address, MotorType.kBrushless); // Creates a new motor
    climbMotor.restoreFactoryDefaults(); // Sets the controller back to the factory defaults
    climbMotorMinSwitch = climbMotor.getReverseLimitSwitch(LimitSwitchPolarity.kNormallyOpen); // Configures the reverse limit switch
    climbMotorMinSwitch.enableLimitSwitch(true); // Enables the switch
  }

  /**
   * sets the speed and does nothing else
   * @author Joe Sedutto
   * @param speed
   */
  public void GantryManualControl(double speed){
    gantryMotor.set(speed);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Lift location", climbMotorMinSwitch.get()); // .get can return the value of that input
  }
}
