package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.model.Triangle;

public class TriangleCreator {
    Triangle createTriangle(double[] coordinates) throws DataException {
        if (coordinates.length != 6) {
            throw new DataException("String contains not enought values");
        }
        if (!validate3PointsForTriangle(coordinates)) {
            throw new DataException("All points lie on one line");
        }
        return new Triangle(coordinates);
    }

    private boolean validate3PointsForTriangle(double[] points) throws DataException {
        if ((points[0] - points[4]) * (points[3] - points[5]) - (points[2] - points[4]) * (points[1] - points[5]) < 0) {
            throw new DataException("Points lay at one line");
        }
        return true;
    }
}
