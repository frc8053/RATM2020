/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoLeftShootCommandGroup extends SequentialCommandGroup {
  /**
   * Auto that starts and the Left side of the field and shoots into the high goal.
   * 
   * @param driveTrain the driveTrain subsystem used
   * @param intake the intake subsystem used
   * @param shooter the shooter subsystem used
   */
  public AutoLeftShootCommandGroup(DriveTrain driveTrain, Intake intake, Shooter shooter) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
        new DriveDistanceCommand(112, driveTrain),
        new DriveTurnCommand(46.888, driveTrain),
        new PidShootCommandGroup(2500, intake, shooter)
    );
  }
}
