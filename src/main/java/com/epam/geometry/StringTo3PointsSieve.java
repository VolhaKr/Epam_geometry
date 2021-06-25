package com.epam.geometry;

import com.epam.geometry.data.DataException;

// TODO: make this name more specific (according to your task)
public class StringTo3PointsSieve {

    // Do validation using regexp
    // this method should not be long, just 1-2 lines
    // keep your line pattern as constant in this class

    public double[] validateFor3Points(String line) throws DataException {
        final int COORD_NUMBER = 6;
        double[] pointCoordinates = new double[COORD_NUMBER];
        String[] splittedMembers = line.split("\\s+");
        if (splittedMembers.length < COORD_NUMBER) {
            throw new DataException("String contains not enought values");
        }
        if (splittedMembers.length > COORD_NUMBER) {
            new DataException("String contains extra data");
        }
        for ( int i = 0; i < COORD_NUMBER - 1; i++ ) {
            try {
                pointCoordinates[i] = Double.parseDouble(splittedMembers[i]);
            } catch (NumberFormatException e) {
                throw new DataException("String contains not a double value");
            }
        }
//        throw new UnsupportedOperationException();
        return pointCoordinates;
    }

}