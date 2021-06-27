package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.logic.Logic;
import com.epam.geometry.model.Triangle;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StringTo3PointsSieveTest {
    private StringTo3PointsSieve stringTo3PointsSieve;

    @Before
    public void prepare() {
        stringTo3PointsSieve = new StringTo3PointsSieve();
    }

    @Test
    public void testNotEnoughDataShouldThrowException() {
        boolean thrown = false;
        String notEnoughDataString = "1 2 45,67";
        try {
            stringTo3PointsSieve.validateFor3Points(notEnoughDataString);
        } catch (DataException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testExtraDataShouldThrowException() {
        boolean thrown = false;
        String tooMuchDataString = "1 2 45,67 90 78,89 -234 -567 0";
        try {
            stringTo3PointsSieve.validateFor3Points(tooMuchDataString);
        } catch (DataException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testNotDoubleDataShouldThrowException() {
        boolean thrown = false;
        String withNotDoubleDataString = "1 2a 45,67 90 78,89 -234";
        try {
            stringTo3PointsSieve.validateFor3Points(withNotDoubleDataString);
        } catch (DataException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testSieveShouldReturnArrayOfCoordinates() {
        String threePointsCoordinates = "1 2 -45.67 0 1e-15 -234";
        double[] expectedCoordinates = new double[]{1, 2, -45.67, 0, 1e-15, -234};
        double[] gottenCoordinates = new double[6];
        //how to test positive flow of a method throwing an exception?
        try {
            gottenCoordinates = stringTo3PointsSieve.validateFor3Points(threePointsCoordinates);
        } catch (DataException e) {
            e.printStackTrace();
        }
        assertTrue(Arrays.equals(gottenCoordinates, expectedCoordinates));
    }
}