package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

    @Test

    public void testDistance() {
        Point p1 = new Point(5, 5);
        Point p2 = new Point(-5, -5);
        Assert.assertEquals(p1.distance(p2), 14.142135623730951);
    }
}