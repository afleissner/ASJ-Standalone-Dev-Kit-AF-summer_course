package edu.ahs.robotics.java;

public class Main {
    public static double distance(Point A, Point B) {
        return A.distanceTo(B);
    }

    public static Point midpoint(Point A, Point B) {
        return A.midpointWith(B);
    }

    public static void main(String[] args)
    {
        //testing out .println() statements
        System.out.println("Hello World! My name is Boris!");
        System.out.print("2 + 7 = ");
        System.out.println(2 + 7);
        System.out.println(2 > 7); //should evaluate to false

        //playing with different numerical types
        int num1 = 7/4;
        System.out.println(num1);
        int num2 = 4/7;
        System.out.println(num2);
        double num3 = 7/4; //still computes with integer division before storing in a double's place
        System.out.println(num3);
        double num4 = 7.0/4;
        System.out.println(num4);

        //generating some instances of Point
        Point P = new Point(1, 2);
        System.out.println("x + y = " + (P.getX() + P.getY()));
        System.out.println(P.getCoords()); //attempt to print an array
        System.out.println(P); //attempt to print the Point object itself
        System.out.println(P.distanceToOrigin());
        System.out.println(P.getQuadrant());
        Point Q = new Point(3, 5);
        LineSegment PQ = new LineSegment(P, Q);
        Point[] ptList = PQ.subDivide(4);
        for (Point pt : ptList) {
            System.out.println(pt);
        }
    }
}