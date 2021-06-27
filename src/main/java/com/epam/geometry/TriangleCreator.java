package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.model.Triangle;

public class TriangleCreator {
    private static final double DELTA = 1e-15;
    Triangle createTriangle(double[] coordinates) throws DataException {
        if (coordinates.length != 6) {
            throw new DataException("String contains not enought values");
        }
        validate3PointsForTriangle(coordinates);
        return new Triangle(coordinates);
    }

   boolean validate3PointsForTriangle(double[] points) throws DataException {
        if ((points[0] - points[4]) * (points[3] - points[5]) - (points[2] - points[4]) * (points[1] - points[5]) < DELTA) {
            throw new DataException("Points lay at one line");
        }
        return true;
    }
}
