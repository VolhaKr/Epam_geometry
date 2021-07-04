package com.epam.geometry;

import com.epam.geometry.data.DataException;

public class StringTo3PointsSieve {

    public double[] validateFor3Points(String line) throws DataException {
        final int COORD_NUMBER = 6;
        double[] pointCoordinates = new double[COORD_NUMBER];

        String[] splittedMembers = line.split("\\s+");

        if (splittedMembers.length < COORD_NUMBER) {
            throw new DataException("String contains not enough values " + line);
        }

        if (splittedMembers.length > COORD_NUMBER) {
            pointCoordinates = null;
            throw new DataException("String contains extra data " + line);
        }

        if (splittedMembers.length == COORD_NUMBER) {
            for ( int i = 0; i < COORD_NUMBER; i++ ) {
                try {
                    pointCoordinates[i] = Double.parseDouble(splittedMembers[i]);
                } catch (NumberFormatException e) {
                    throw new DataException("String contains not a double value " + line, e);
                }
            }
        }
        //^(?:[+\-]{0,1}[\d]+(?:\.[\d]+)*\s*){2}$
        return pointCoordinates;
    }
}