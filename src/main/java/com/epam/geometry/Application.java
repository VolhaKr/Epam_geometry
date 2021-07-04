package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.data.DataReader;

public class Application {
    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        try {
            dataReader.readLines("src/resources/file.txt");
        } catch (DataException e) {
            e.printStackTrace();
        }
    //    Director director = new Director();

    }
}
