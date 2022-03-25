package com.company;

public class Point {

    double x, y;

    // Constructors
    public Point(double xP, double yP) {
        x = xP;
        y = yP;
    }

    public Point(Point other) {
        x = other.getX();
        y = other.getY();
    }

    // Methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double num) {
        x = num;
    }

    public void setY(double num) {
        y = num;
    }

    public String toString()
    {
        return String.format("(%.1f,%.1f)", x, y);
    }

    public boolean equals(Point other) {
        return (other.getX() == x) && (other.getY() == y);
    }

    public boolean isAbove(Point other) {
        return (y > other.getY());
    }

    public boolean isUnder(Point other) {
        return !isAbove(other);
    }

    public boolean isLeft(Point other) {
        return (x < other.getX());
    }

    public boolean isRight(Point other) {
        return !isLeft(other);
    }

    public int whichQuadrand() {
        if (x > 0 && y > 0)
            return 1;
        if (x > 0 && y < 0)
            return 4;
        if (x < 0 && y < 0)
            return 3;
        return 2;
    }

    public double distance(Point p) {
        double xDiff = x - p.getX();
        double yDiff = y - p.getY();

        return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }

    public Point mirrorPoint(Point p) {
        return new Point(-p.getX(), -p.getY());
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }
}
