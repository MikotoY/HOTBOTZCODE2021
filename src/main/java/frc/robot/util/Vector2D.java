package frc.robot.util;

/**
 * 2D Mathematical Vector
 */
public class Vector2D {
    public double x = 0, y = 0;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getAngle() {
        return Math.atan2(y, x);
    }

    public double getMagnitude() {
        return Math.hypot(x, y);
    }

    public Vector2D scale(double scalar) {
        x *= scalar;
        y *= scalar;
        return this;
    }

    public Vector2D add(Vector2D v) {
        x += v.x;
        y += v.y;
        return this;
    }

    public Vector2D subtract(Vector2D v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    public Vector2D makePerpendicular() {
        double temp = x;
        x = y;
        y = -temp;
        return this;
    }

    public String toString() {
        return x + " " + y;
    }
}
