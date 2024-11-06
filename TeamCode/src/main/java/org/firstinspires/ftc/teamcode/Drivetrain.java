package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Drivetrain Test", group = "test")
public class Drivetrain extends OpMode {

    private MecanumDrive mecanum;
    private GamepadEx gamepad;
    private Motor[] driveMotors;

    @Override
    public void init() {
        gamepad = new GamepadEx(gamepad1);
        driveMotors = new Motor[]{
                new Motor(hardwareMap, "front_left_drive"),
                new Motor(hardwareMap, "front_right_drive"),
                new Motor(hardwareMap, "back_left_drive"),
                new Motor(hardwareMap, "back_right_drive"),
        };
        for (Motor motor: driveMotors) {
            motor.setInverted(true);
        }
        driveMotors[0].getCorrectedVelocity();
        mecanum = new MecanumDrive(driveMotors[0], driveMotors[1], driveMotors[2], driveMotors[3]);
    }

    @Override
    public void loop() {
        mecanum.driveRobotCentric(-gamepad.getLeftX(), -gamepad.getLeftY(), -gamepad.getRightX());
        telemetry.addData("Joystick: LeftX", -gamepad.getLeftX() );
        telemetry.addData("Joystick: LeftY ", -gamepad.getLeftY() );
        telemetry.addData("Joystick: RightX", -gamepad.getRightX() );
        telemetry.addData("Joystick: RightY", -gamepad.getRightY() );
        telemetry.addData("Front Left Motor Velocity", driveMotors[0].getCorrectedVelocity());
        telemetry.addData("Front Right Motor Velocity", driveMotors[1].getCorrectedVelocity());
        telemetry.addData("Back Left Motor Velocity", driveMotors[2].getCorrectedVelocity());
        telemetry.addData("Back Right Motor Velocity", driveMotors[3].getCorrectedVelocity());
        telemetry.update();

    }
}