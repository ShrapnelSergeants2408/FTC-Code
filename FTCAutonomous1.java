package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class FTCAutonomous1 extends LinearOpMode {
    DcMotor LM;
    DcMotor RM;
    DcMotor IM;
    DcMotor LT;
    boolean L1 = true; // change this
    int TicksToInches = 155; // edit

    private ElapsedTime runtime = new ElapsedTime();
    private ElapsedTime intakeTimer = new ElapsedTime();
    @Override
    public void runOpMode(){
        LM = hardwareMap.dcMotor.get("LM");
        RM = hardwareMap.dcMotor.get("RM");
        IM = hardwareMap.dcMotor.get("IM");
        LT = hardwareMap.dcMotor.get("LT");

        LM.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()){
            if(L1){
                /*//descend(1, 1);
                driveBack(1);
                turnLeft(1); // turns robot in 360
                drive(10);
                turnLeft(4);
                drive(10);
                turnRight(4);
                drive(10);
                turnRight(10);
                drive(10);
                spit(10);
                driveBack(10);
                turnRight(10);
                drive(10);
                turnLeft(10);
                drive(10);
                turnRight(10);
                drive(10);*/
                driveBack(12);
            } else {
                //descend(1, 1);
                driveBack(1);
                turnLeft(5); // turns robot in 360
                drive(5);
                turnLeft(5);
                drive(5);
                turnLeft(5);
                drive(5);
                spit(5);
                driveBack(5);
            }
            stopbot();
            break;
        }
    }


    private void drive(int Inches){
        LM.setTargetPosition(Inches*TicksToInches);
        RM.setTargetPosition(Inches*TicksToInches);
        LM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(RM.isBusy() && LM.isBusy()) {
            LM.setPower(0.5);
            RM.setPower(0.5);
            telemetry.addData("Inches Parameter", Inches);
            telemetry.addData("LM Distance", LM.getCurrentPosition());
            telemetry.addData("RM Distance", RM.getCurrentPosition());
            telemetry.addData("LM Target Distance", LM.getTargetPosition());
            telemetry.addData("RM Target Distance", RM.getTargetPosition());
            telemetry.addData("Conversion Rate", TicksToInches);
            telemetry.addData("Timer", runtime.seconds());
            telemetry.addData("Drive ", "Straight Forward");
            telemetry.addData("Ticks to travel ", Inches * TicksToInches);
            telemetry.addData("Inches to travel ", (double)((Inches*TicksToInches) - LM.getCurrentPosition())/TicksToInches);
            telemetry.addData("Motor Power", "LM: " + LM.getPower() + "/" + "RM: " + RM.getPower());
            telemetry.update();
        }
        LM.setPower(0.0);
        RM.setPower(0.0);
        LM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    private void driveBack(int Inches){
        LM.setTargetPosition(Inches*TicksToInches);
        RM.setTargetPosition(Inches*TicksToInches);
        LM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(RM.isBusy() && LM.isBusy()) {
            LM.setPower(-0.5);
            RM.setPower(-0.5);
            telemetry.addData("Inches Parameter", Inches);
            telemetry.addData("LM Distance", LM.getCurrentPosition());
            telemetry.addData("RM Distance", RM.getCurrentPosition());
            telemetry.addData("Conversion Rate", TicksToInches);
            telemetry.addData("Timer", runtime.seconds());
            telemetry.addData("Drive ", "Straight Forward");
            telemetry.addData("Ticks to travel ", Inches * TicksToInches);
            telemetry.addData("Inches to travel ", (double)((Inches*TicksToInches) - LM.getCurrentPosition())/TicksToInches);
            telemetry.addData("Motor Power", "LM: " + LM.getPower() + "/" + "RM: " + RM.getPower());
            telemetry.update();
        }
        LM.setPower(0.0);
        RM.setPower(0.0);
        LM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    private void turnLeft(int Inches){
        LM.setTargetPosition(Inches*TicksToInches);
        RM.setTargetPosition(Inches*TicksToInches);
        LM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(RM.isBusy() && LM.isBusy()) {
            LM.setPower(-0.25);
            RM.setPower(0.25);
            telemetry.addData("Timer", runtime.seconds());
            telemetry.addData("Drive ", "Turning Left");
            telemetry.addData("Inches to travel ", (double)((Inches*TicksToInches) - LM.getCurrentPosition())/TicksToInches);
            telemetry.addData("Motor Power", "LM: " + LM.getPower() + "/" + "RM: " + RM.getPower());
            telemetry.update();
        }
        LM.setPower(0.0);
        RM.setPower(0.0);
        LM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    private void turnRight(int Inches){
        LM.setTargetPosition(Inches*TicksToInches);
        RM.setTargetPosition(Inches*TicksToInches);
        LM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(RM.isBusy() && LM.isBusy()) {
            LM.setPower(0.25);
            RM.setPower(-0.25);
            telemetry.addData("Timer", runtime.seconds());
            telemetry.addData("Drive ", "Turning Right");
            telemetry.addData("Inches to travel ", (double)((Inches*TicksToInches) - LM.getCurrentPosition())/TicksToInches);
            telemetry.addData("Motor Power", "LM: " + LM.getPower() + "/" + "RM: " + RM.getPower());
            telemetry.update();
        }
        LM.setPower(0.0);
        RM.setPower(0.0);
        LM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    private void intake(int Seconds){
        intakeTimer.reset();
        while(intakeTimer.seconds() < Seconds) {
            IM.setPower(0.5);
            telemetry.addData("Timer", runtime.seconds());
            telemetry.addData("Drive ", "Intaking");
            telemetry.addData("Motor Power", "Intake Motor : " + IM.getPower());
            telemetry.update();
        }
        IM.setPower(0.0);
    }
    private void spit(int Seconds){
        intakeTimer.reset();
        while(intakeTimer.seconds() < Seconds) {
            IM.setPower(-0.5);
            telemetry.addData("Timer", runtime.seconds());
            telemetry.addData("Drive ", "Spitting out");
            telemetry.addData("Motor Power", "Intake Motor : " + IM.getPower());
            telemetry.update();
        }
        IM.setPower(0.0);
    }
    private void ascend(int Inches){
        LT.setTargetPosition(Inches*TicksToInches);
        LT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(LT.isBusy()) {
            LT.setPower(0.5);
            telemetry.addData("Timer", runtime.seconds());
            telemetry.addData("Drive ", "Ascending");
            telemetry.addData("Inches to travel ", (double)((Inches*TicksToInches) - LT.getCurrentPosition())/TicksToInches);
            telemetry.addData("Motor Power", "Lift Motor : " + LT.getPower());
            telemetry.update();
        }
        LT.setPower(0.0);
        LT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    private void descend(int Inches, int Inches2){
        LT.setTargetPosition(Inches*TicksToInches);
        LT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(LT.isBusy()) {
            LT.setPower(0.5);
            telemetry.addData("Timer", runtime.seconds());
            telemetry.addData("Drive ", "Descending");
            telemetry.addData("Inches to travel ", (double)((Inches*TicksToInches) - LT.getCurrentPosition())/TicksToInches);
            telemetry.addData("Motor Power", "Lift Motor : " + LT.getPower());
            telemetry.update();
        }
        LT.setPower(0.0);
        LT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LM.setTargetPosition(Inches2*TicksToInches);
        RM.setTargetPosition(Inches2*TicksToInches);
        LM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(RM.isBusy() && LM.isBusy()) {
            LM.setPower(0.1);
            RM.setPower(-0.1);
            telemetry.addData("Timer", runtime.seconds());
            telemetry.addData("Drive ", "Turning Right");
            telemetry.addData("Inches to travel ", (double)((Inches2*TicksToInches) - LM.getCurrentPosition())/TicksToInches);
            telemetry.addData("Motor Power", "LM: " + LM.getPower() + "/" + "RM: " + RM.getPower());
            telemetry.update();
        }
        LM.setPower(0.0);
        RM.setPower(0.0);
        LM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    private void pause(double seconds){
        LM.setPower(0.0);
        RM.setPower(0.0);
        LM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        telemetry.addData("Timer", runtime.seconds());
        telemetry.addData("Drive ", "Paused");
        telemetry.update();
        sleep((long)(seconds*1000));
    }
    private void stopbot(){
        LM.setPower(0.0);
        RM.setPower(0.0);
        LM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        telemetry.clearAll();
        runtime.reset();
    }
}
