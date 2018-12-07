package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class FTC_TeleOp extends OpMode { //Extends upon the built in OpMode code
    // Creates the variables
    DcMotor LM;
    DcMotor RM;
    DcMotor IM;
    DcMotor LT;
    float left;
    float right;
    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void init(){
        // Maps the code's motors to the robot's motors
        LM = hardwareMap.dcMotor.get("LM");
        RM = hardwareMap.dcMotor.get("RM");
        IM = hardwareMap.dcMotor.get("IM");
        LT = hardwareMap.dcMotor.get("LT");
        LM.setDirection(DcMotor.Direction.REVERSE);
    }
    @Override
    public void loop(){
        telemetry.addData("Timer",runtime.seconds());
        telemetry.addData("Debug", "Looping");
        float left = gamepad1.left_stick_y; // This gets the left joystick's direction in the y direction

        float right = gamepad1.right_stick_y; // This gets the right joystick's direction in the y direction
        telemetry.addData("Stick left value", gamepad1.left_stick_y);
        telemetry.addData("Stick right value", gamepad1.right_stick_y);
        telemetry.addData("Stick left", left);
        telemetry.addData("Stick right", right);
        LM.setPower(left*0.75); // This will set the power of the motor to half the joystick's upwards/downwards movement
        RM.setPower(right*0.75); // This will set the power of the motor to half the joystick's upwards/downwards movement
        if(gamepad2.x){ // If the "x" button is pressed, it will descend
            IM.setPower(1);
        } else{
            IM.setPower(0);
        }
        if(gamepad2.y){ // If the "y" button is pressed, it will ascend
            IM.setPower(-1);
        } else{
            IM.setPower(0);
        }
        if(gamepad2.a){ // If the "x" button is pressed, it will descend
            LT.setPower(0.5);
        } else{
            LT.setPower(0);
        }
        if(gamepad2.b){ // If the "y" button is pressed, it will ascend
            LT.setPower(-0.5);
        } else{
            LT.setPower(0);
        }
        if(gamepad1.left_bumper){ // If the "y" button is pressed, it will ascend
            LM.setPower(left); // This will set the power of the motor to half the joystick's upwards/downwards movement
            RM.setPower(right);
        }
        telemetry.addData("Left speed", LM.getPower());
        telemetry.addData("Right speed", RM.getPower());
        telemetry.addData("Intake speed", IM.getPower());
        telemetry.addData("Lift speed", LT.getPower());
    }

}
