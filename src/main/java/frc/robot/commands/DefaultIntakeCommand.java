/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

import java.util.function.DoubleSupplier;

public class DefaultIntakeCommand extends CommandBase {
  private DoubleSupplier speed;
  private Intake intake;
  private Shooter shooter;
  /**
   * Moves the intake and conveyor based on joystick input. 
   * The shooter wheels spin the opposite way.
   * 
   * @param speed speed of the intake bar (*0.8) and conveyor (*0.82)
   * @param intake the intake subsystem used
   * @param shooter the shooter subsystem used
   */
  
  public DefaultIntakeCommand(DoubleSupplier speed, Intake intake, Shooter shooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.speed = speed;
    this.intake = intake;
    this.shooter = shooter;
    addRequirements(intake, shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.intakeBar(speed.getAsDouble() * 0.8);
    //if (intake.haveBall()) {
    //intake.conveyorControl(IntakeConstant.CONVEYOR_SPEED);
    //} else {
    //intake.conveyorControl(0);
    //}
    intake.conveyorControl(speed.getAsDouble() * 0.5);
    shooter.shoot(Math.abs(speed.getAsDouble()) * -0.3);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
