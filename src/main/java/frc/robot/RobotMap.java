package frc.robot;

public class RobotMap {
    public static double acc = 50;
    public static double vCruise = 60;

    public static class SwerveDrive {
        // These numbers control the Swerve PID
        public static final double SWERVE_STEER_P = .55;
        public static final double SWERVE_STEER_I = 0;
        public static final double SWERVE_STEER_D = .035;
        public static final double SWERVE_STEER_CAP = 1;
        //P=.9
        //I=.001
        //D=.8
        // Port which the drive motors are plugged into
        public static final int BR_DRIVE = 4;
        public static final int FR_DRIVE = 2;
        public static final int FL_DRIVE = 1;
        public static final int BL_DRIVE = 3;

        // Port which the steering motors are plugged into
        public static final int FL_STEER = 5;
        public static final int FR_STEER = 6;
        public static final int BL_STEER = 7;
        public static final int BR_STEER = 8;

        // Port which the steering encoders are plugged into
        public static final int FL_ENCODER = 1;
        
        public static final int FR_ENCODER = 0;
        public static final int BR_ENCODER = 3;
        public static final int BL_ENCODER = 2;

        // Offset of the encoders to correct the orientation of installation
        // Encoder offsets for ???
        // public final static double FL_ENC_OFFSET = 116;
        // public final static double FR_ENC_OFFSET = 203;
        // public final static double BL_ENC_OFFSET = 173;
        // public final static double BR_ENC_OFFSET = 72;

        public final static double FL_ENC_OFFSET = 107;
        public final static double FR_ENC_OFFSET = 105;
        public final static double BL_ENC_OFFSET = 44;
        public final static double BR_ENC_OFFSET = 46;

        // public final static double FL_ENC_OFFSET = 0;
        // public final static double FR_ENC_OFFSET = 0;
        // public final static double BL_ENC_OFFSET = 0;
        // public final static double BR_ENC_OFFSET = 0;

        // Whether or not the encoders are reversed
        public static final boolean ENCODERS_REVERSED = false;

        // Cad Wheel Base information for ???
        // public static final double WHEEL_BASE_WIDTH = 22.5;
        // public static final double WHEEL_BASE_LENGTH = 24.5

        // Cad Wheel Base information for Croton
        public static final double WHEEL_BASE_WIDTH = 21;
        public static final double WHEEL_BASE_LENGTH = 26;

    }

    public static class Controller {
        public final static int X = 3;
        public final static int A = 1;
        public final static int B = 2;
        public final static int Y = 4;
        public final static int LEFT_BUMPER = 5;
        public final static int RIGHT_BUMPER = 6;
        public final static int BACK = 7;
        public final static int START = 8;
        // public final static int START = 8;
        // public final static int BACK = 9;
        public final static int VisionLock = 10;
        

    }
    public static class Logitech {
        public final static int high = 6;
        public final static int four = 4;
        public final static int five = 5;
        // public final static int mid = 8;
        public final static int trigger = 1;
        public final static int two = 2;
        public final static int balltilt = 1;
        public final static int autolift = 10;
        public final static int three = 3;
        // public final static int down = 2;
    }
}