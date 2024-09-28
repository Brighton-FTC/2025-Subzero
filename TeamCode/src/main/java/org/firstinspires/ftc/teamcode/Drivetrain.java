package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class Drivetrain extends OpMode {

    private MecanumDrive mecanum;
    private GamepadEx gamepad;
    @Override
    public void init() {
        gamepad = new GamepadEx(gamepad1);
        Motor[] driveMotors = {
                new Motor(hardwareMap, "front_left_drive"),
                new Motor(hardwareMap, "front_left_drive"),
                new Motor(hardwareMap, "front_left_drive"),
                new Motor(hardwareMap, "front_left_drive"),
        };
        for (Motor motor: driveMotors) {
            motor.setInverted(true);
        }
        mecanum = new MecanumDrive(driveMotors[0], driveMotors[1], driveMotors[2], driveMotors[3]);
    }

    @Override
    public void loop() {
        mecanum.driveRobotCentric(-gamepad.getLeftX(), -gamepad.getLeftY(), -gamepad.getRightX());
        telemetry.addData("Joystick: LeftX", -gamepad.getLeftX() );
        telemetry.addData("Joystick: LeftY ", -gamepad.getLeftY() );
        telemetry.addData("Joystick: RightX", -gamepad.getRightX() );
        telemetry.addData("Joystick: RightY", -gamepad.getRightY() );


        telemetry.update();
    }
}
