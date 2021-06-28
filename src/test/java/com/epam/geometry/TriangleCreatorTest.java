package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.model.Triangle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TriangleCreatorTest {
    private TriangleCreator triangleCreator;

    @Before
    public void prepare() {
        triangleCreator = new TriangleCreator();
    }

    @Test
    public void testPointsLieOnOneLineShouldThrowException() {
        boolean thrown = false;
        double[] oneLineCoord = {0, 6, 0, 7, 0, 56.67};
        try {
            triangleCreator.createTriangle(oneLineCoord);
        } catch (DataException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testCreateTriangleShouldReturnTriangle() {
        double[] triangleLineCoord = {0, 6, 1, 7, 0, 56.67};
        Triangle receivedTriangle = null;
        Triangle expectedTriangle = new Triangle(new double[]{0, 6, 1, 7, 0, 56.67});
        try {
            receivedTriangle = triangleCreator.createTriangle(triangleLineCoord);
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertEquals(expectedTriangle, receivedTriangle);
    }
}
