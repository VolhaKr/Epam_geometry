package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.data.DataReader;
import com.epam.geometry.model.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private final DataReader dataReader;
    private final StringTo3PointsSieve stringTo3PointsSieve;
    private final TriangleCreator triangleCreator;

    public Director(DataReader reader, StringTo3PointsSieve stringTo3PointsSieve, TriangleCreator triangleCreator) {
        this.dataReader = reader;
        this.stringTo3PointsSieve = stringTo3PointsSieve;
        this.triangleCreator = triangleCreator;
    }

    public List<Triangle> process(String filename) {
        List<String> readLines = null;
        double[] pointCoordinates = null;
        List<Triangle> triangles = new ArrayList<Triangle>();

        try {
            readLines = dataReader.readLines(filename);
        } catch (DataException e) {
            readLines = null;
            e.printStackTrace();
            System.out.println("Data are corrupted, reading is impossible");
        }

        if (readLines != null) {
            for ( String readLine : readLines ) {
                try {
                    pointCoordinates = stringTo3PointsSieve.validateFor3Points(readLine);
                } catch (DataException e) {
                    pointCoordinates = null;
                    System.out.println("line " + readLine + " is not a triangle");
                    e.printStackTrace();
                }

                if (pointCoordinates != null) {
                    try {
                        Triangle triangle = triangleCreator.createTriangle(pointCoordinates);
                        triangles.add(triangle);
                        System.out.println("Triangle added " + triangle.toString());
                    } catch (DataException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return triangles;
    }
}

