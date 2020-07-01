package edu.ahs.robotics.java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void distanceToOrigin() {
        //structure of this method call:
        //expected output
        //constructor with given parameters + method tested
        //acceptable error?
        double accErr = 0.00001;
        assertEquals(5, new Point(3, 4).distanceToOrigin(), accErr);
        assertEquals(13, new Point(5, -12).distanceToOrigin(), accErr);
        assertEquals(25, new Point(-7, 24).distanceToOrigin(), accErr);
        assertEquals(Math.sqrt(2), new Point(-1, -1).distanceToOrigin(), accErr);
    }

    @Test
    public void getQuadrant() {
        assertEquals(1, new Point(3, 4).getQuadrant());
        assertEquals(2, new Point(-4.5, 6).getQuadrant());
        assertEquals(3, new Point(-1, -1).getQuadrant());
        assertEquals(4, new Point(19, -3.2215).getQuadrant());
        //points on an axis should return 0
        assertEquals(0, new Point(0, -7).getQuadrant());
        assertEquals(0, new Point(12, 0).getQuadrant());
        assertEquals(0, new Point(0, 0).getQuadrant());
    }
}