package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.model.Triangle;

public class TriangleCreator {
    private final double DELTA = 1e-15;

    Triangle createTriangle(double[] coordinates) throws DataException {
        if (validate3PointsForTriangle(coordinates)) {
            return new Triangle(coordinates);
        }
        else {
            throw new DataException("Points lay at one line");
        }
    }

    boolean validate3PointsForTriangle(double[] coordinates) {

        double deltaForLine1 = (coordinates[0] - coordinates[4]) * (coordinates[3] - coordinates[5]);
        double deltaForLine2 = (coordinates[2] - coordinates[4]) * (coordinates[1] - coordinates[5]);
        if (Math.abs(deltaForLine1 - deltaForLine2) > DELTA) {
            return true;
        }
        else {
            return false;
        }
    }
}
