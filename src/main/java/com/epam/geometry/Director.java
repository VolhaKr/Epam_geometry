package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.data.DataReader;
import com.epam.geometry.model.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Director {

    //TODO: uncomment
    private final DataReader dataReader;
    private final StringTo3PointsSieve stringTo3PointsSieve;
    private final TriangleCreator triangleCreator;

    public Director(DataReader reader, StringTo3PointsSieve stringTo3PointsSieve, TriangleCreator triangleCreator) {
        this.dataReader = reader;
        this.stringTo3PointsSieve = stringTo3PointsSieve;
        this.triangleCreator = triangleCreator;
    }

//public Director(DataReader reader, StringTo3PointsSieve stringTo3PointsSieve, TriangleCreator triangleCreator) {

    //TODO: inject you dependencies here
    //}

    // Input file contains multiple lines, each line a geometry object
    // i.e. each line contains all necessary data to create object in a simple format like: 1.0 2.0 3.0
    // some line
    public List<Triangle> process(String filename) {
        List<String> readLines = new ArrayList<String>();
        double[] pointCoordinates = new double[0];
        List<Triangle> triangles = new ArrayList<Triangle>();
        //List<Triangle> triangleList = new ArrayList<Triangle>();
        // DataReader dataReader = new DataReader();
        try {
            readLines = dataReader.readLines(filename);
        } catch (DataException e) {
            e.printStackTrace();
        }
        for ( String readLine : readLines ) {
            try {
                pointCoordinates = stringTo3PointsSieve.validateFor3Points(readLine);
            } catch (DataException e) {
                e.printStackTrace();
            }
            try {
                Triangle triangle = triangleCreator.createTriangle(pointCoordinates);
                triangles.add(triangle);

            } catch (DataException e) {
                e.printStackTrace();
            }
        }
        return triangles;
    }
}
