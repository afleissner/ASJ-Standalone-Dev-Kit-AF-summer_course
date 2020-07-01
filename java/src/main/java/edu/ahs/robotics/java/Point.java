package edu.ahs.robotics.java;

public class Point {
    //fields / instance variables / attributes: x- and y-coordinates
    private double x;
    private double y;

    //constructor method
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //getters and setters
    public double getX() {return x;}
    public void setX(double newX) {x = newX;}
    public double getY() {return y;}
    public void setY(double newY) {y = newY;}
    public double[] getCoords() {return new double[] {x, y};}
    public void setCoords(double newX, double newY) {setX(newX); setY(newY);}

    //method for printing
    //turns out any call to print objects calls the .toString() method of any Object,
    //which this will override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    //other methods

    public double distanceTo(Point P) {
        double xDist = x - P.getX();
        double yDist = y - P.getY();
        return Math.sqrt(xDist * xDist + yDist * yDist);
    }

    public double distanceToOrigin() {
        return distanceTo(new Point(0, 0));
    } //this method has a test

    public int getQuadrant() {
        int q;
        if (x==0 || y==0) {q = 0;}
        else if (y > 0) {
            if (x > 0) {q = 1;}
            else {q = 2;}
        }
        else {
            if (x < 0) {q = 3;}
            else {q = 4;}
        }
        return q;
    } //this method has a test

    public Point closestPoint(Point[] ptList) {
        Point currClosest = ptList[0];
        double currClosestDist = distanceTo(currClosest);

        for (Point currPt : ptList) {
            double currDist = distanceTo(currPt);
            if (currDist < currClosestDist) {
                currClosest = currPt;
                currClosestDist = currDist;
            }
        }

        return currClosest;
    }

    public Point midpointWith(Point P) {
        double xMid = (x + P.getX())/2;
        double yMid = (y + P.getY())/2;
        return new Point(xMid, yMid);
    }
}