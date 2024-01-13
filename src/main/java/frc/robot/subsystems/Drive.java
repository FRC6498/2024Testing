// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  /** Creates a new Drive. */
  CANSparkMax sparkMax;
  SparkPIDController controller;
  public Drive() {
    sparkMax = new CANSparkMax(0, MotorType.kBrushless);
    controller = sparkMax.getPIDController();
    controller.setP(0);
    controller.setI(0);
    controller.setD(0);
  }
  public Command RunAtVelocity(double velocity) {
    return this.runOnce(()-> controller.setReference(velocity, ControlType.kVelocity));
  }
  public Command RunAtPercent(double percent){
    return this.runOnce(()->sparkMax.set(percent));
  }
  public Command Stop(){
    return this.runOnce(()->sparkMax.set(0));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
