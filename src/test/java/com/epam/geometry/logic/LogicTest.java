package com.epam.geometry.logic;


import com.epam.geometry.model.Triangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogicTest {

    private Triangle trianglePositiveCoordinates;
    private Triangle triangleDifferentCoordinates;
    private Triangle triangleRight;
    private Logic logic;
    private double expectedSquare;
    private double calculatedSquare;
    private static final double DELTA = 1e-15;

    @Before
    public void prepare() {
        trianglePositiveCoordinates = new Triangle(1, 5, 2, 2, 6, 8);
        triangleDifferentCoordinates = new Triangle( 2, -4.5, 0, 0, -7.5, -14.3);
        triangleRight = new Triangle( 1,  1 , 1, 2 , 5, 1);
        logic = new Logic();
    }

    @Test
    public void testPositiveCoordinatesSquareShouldReturnTrue() {
        calculatedSquare = logic.calculateSquare(trianglePositiveCoordinates);
        expectedSquare = 9;
        Assert.assertEquals(expectedSquare, calculatedSquare, DELTA);
    }

    @Test
    public void testAllCoordinatesSquareShouldReturnTrue() {
        calculatedSquare = logic.calculateSquare(triangleDifferentCoordinates);
        expectedSquare = 31.175;
        Assert.assertEquals(expectedSquare, calculatedSquare, DELTA);
    }

    @Test
    public void testRightPositiveCoordinatesShouldReturnFalse() {
        Assert.assertFalse( logic.checkRight(trianglePositiveCoordinates));
    }

    @Test
    public void testRightDiifferentCoordinatesShouldReturnFalse() {
        System.out.println("test triangle ");
        Assert.assertFalse( logic.checkRight(triangleDifferentCoordinates));
    }

    @Test
    public void testRightShouldReturnTrue() {
        Assert.assertTrue( logic.checkRight(triangleRight));
    }
}

