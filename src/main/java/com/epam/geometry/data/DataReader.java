package com.epam.geometry.data;

import com.sun.org.apache.bcel.internal.util.ClassPath;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private String line = null;
    BufferedReader reader = null;
    FileReader fileReader;
    List<String> readLines = new ArrayList<String>();

    public List<String> readLines(String fileName) throws DataException {
        Path path = Paths.get(fileName);

        try {
            fileReader = new FileReader(String.valueOf(path));
            System.out.println("Reading fom file, path " + String.valueOf(path));
            reader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new DataException("File not found", e);
        }

        try {
            while ((line = reader.readLine()) != null) {
                System.out.println("Line read " + line);
                readLines.add(line);
            }
        } catch (IOException e) {
            throw new DataException("IO Exception", e);
        }

        try {
            fileReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return readLines;
    }
}
