package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
   * Contains methods to drive the robot
   */
public class Drivetrain extends SubsystemBase {
  private final TalonSRX portmotor = new TalonSRX(Constants.CANIds.TalonSRX_Port_ID); // Init the port motor at 1
  private final TalonSRX starboardmotor = new TalonSRX(Constants.CANIds.TalonSRX_Starboard_ID); // Init the starboard at 2
  
  /**
   * The drivetrain subsystem controls the movement of the robot.
   */
  public Drivetrain() {
    portmotor.setInverted(true); // Sets the output of the starboard motor backwards
  }

  /**
   * Using a joystick as input this method drives
   * the robot base.
   * @param DriverJoystick
   * @author Joe Sedutto
   */
  public void FlyByWireA(double steerage, double thro){
    starboardmotor.set(ControlMode.PercentOutput, (thro - (steerage / 1.2)) / -2); // Set the starboard motor to the sum of thro - steerage
    portmotor.set(ControlMode.PercentOutput, (thro + (steerage / 1.2)) / -2); // Set the port motor to the sum of thro + steerage
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}