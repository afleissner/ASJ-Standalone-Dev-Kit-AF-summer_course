package edu.ahs.robotics.java;

public class LineSegment {
    private Point A;
    private Point B;

    public LineSegment(Point P, Point Q) {
        A = P;
        B = Q;
    }

    public Point[] subDivide(int numDivs) {
        //array of interior points to return
        Point[] ptList = new Point[numDivs - 1];
        //x- and y-intervals to add in subsequent linear combinations
        double xInt = (B.getX() - A.getX()) / numDivs;
        double yInt = (B.getY() - A.getY()) / numDivs;
        //x- and y-coordinates to initialize as point A
        //and iteratively creep towards point B
        double xCoord = A.getX();
        double yCoord = A.getY();

        //SCRAPPED THE FOLLOWING NOTES, BUT KEEPING THEM IN B/C I LIKE MATH
        //intentionally running i from 1 to full array length,
        //so it can be used as coefficient for linear combinations
        //of the endpoint coordinates
        for (int i = 0; i < ptList.length; i++) {
            //increment coordinates for subsequent linear combinations
            xCoord += xInt;
            yCoord += yInt;
            //AGAIN, SCRAPPED THESE NOTES, BUT I LIKE THE IDEA
            //now store these coordinates in the appropriate address
            //NB that the appropriate address is off-set from the indexing
            //ACTUALLY NB that we never created a Point object for the array, so we are doing that now
            ptList[i] = new Point(xCoord, yCoord);
        }
        return ptList;
    }

    public Point interpolate(double dist) {
        //workaround for a segment's length (not currently an internal method)
        double length = A.distanceTo(B);
        //will want to scale displacements by this coefficient
        double scaleCoeff = dist / length;
        //x- and y-intervals
        double xInt = B.getX() - A.getX();
        double yInt = B.getY() - A.getY();
        //scale these up
        double xDist = scaleCoeff * xInt;
        double yDist = scaleCoeff * yInt;
        //add them onto point A and send it back
        return new Point(A.getX() + xDist, A.getY() + yDist);
    }
}
