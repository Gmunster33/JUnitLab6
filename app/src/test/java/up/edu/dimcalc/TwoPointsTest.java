package up.edu.dimcalc;

import android.graphics.Point;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * BUGS
 * 1. After Copy, both values are locked together
 * 2. Values manually entered are reset to their previous values
 * 3. Wrong Slope formula - app crashes when slope is calculated due to div by zero.
 * 4. Distance is not rounded.
 */

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        //assertEquals(7, p2.y); //MINOR EDIT TO CAUSE FAILURE: should be 5
         assertEquals(5, p2.y);
    }

    //Verify that randomValue generates different numbers when it is called.
    @Test
    public void randomValue() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        Point p1 = testPoints.getPoint(0);
        assertTrue(p1.x + 10 <= 20);
        assertTrue(p1.y + 10 <= 20);
    }

    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setOrigin(0);
        Point p1 = testPoints.getPoint(0);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
    }

    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);
        testPoints.copy(0, 1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, p2.x);
        assertEquals(p1.y, p2.y);
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, 1, 1);
        double result = testPoints.distance();
        assertEquals(6, result, .0001); //value is not rounded
    }

    @Test
    public void slope() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, 10);
        testPoints.setPoint(1, 0, 0);
        double slope = testPoints.slope();
        assertEquals(2.00, slope, .001);
    }
}