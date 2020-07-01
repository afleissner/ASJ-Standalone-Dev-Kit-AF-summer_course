package edu.ahs.robotics.java;

import org.junit.Test;
import static org.junit.Assert.*;

public class LineSegmentTest {

    @Test
    public void subDivide() {
        double accErr = 0.000001;

        //first test: trisecting (0, 0) - (3, 3)

        //test points in trisecting A(0, 0) - B(3, 3)
        Point[] ptListExpect = new Point[2];
        ptListExpect[0] = new Point(1, 1);
        ptListExpect[1] = new Point(2, 2);

        //said line segment to test
        LineSegment seg1 = new LineSegment(new Point(0, 0), new Point(3, 3));
        Point[] ptListActual = seg1.subDivide(3);

        for (int i = 0; i < ptListActual.length; i++) {
            assertEquals(ptListExpect[i].getX(), ptListActual[i].getX(), accErr);
            assertEquals(ptListExpect[i].getY(), ptListActual[i].getY(), accErr);
        }


        //second test: trisecting (-4, 1) - (8, 7)

        //actual line segment
        LineSegment seg2 = new LineSegment(new Point(-4, 1), new Point(8, 7));
        ptListActual = seg2.subDivide(3);

        //test points
        ptListExpect[0] = new Point(0, 3);
        ptListExpect[1] = new Point(4, 5);

        for (int i = 0; i < ptListActual.length; i++) {
            assertEquals(ptListExpect[i].getX(), ptListActual[i].getX(), accErr);
            assertEquals(ptListExpect[i].getY(), ptListActual[i].getY(), accErr);
        }
    }
}