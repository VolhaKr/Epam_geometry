package com.epam.geometry.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    //TODO: implement this method using BufferedReader, do not throw original IOException, wrap it with your own

    public List<String> readLines(String filename) throws DataException {

        // final String INPUT_FILE = "src/file.txt";
        String line = null;
        BufferedReader reader = null;
        List<String> readLines = new ArrayList<String>();


        System.out.println("Reading fom file");

//
//
//        public class FileQuoteList {
//
//            final String fileName = "files/quote.txt";
//            final File file = getFileFromResource(fileName);
//
//            public List<String> getQuoteList() {
//
//                try (FileReader reader = new FileReader(file);
//                     BufferedReader br = new BufferedReader(reader)) {
//                    return br.lines().collect(Collectors.toList());
//                } catch (IOException e) {
//                    return new ArrayList<String>();
//                }
//            }
//
//            File getFileFromResource(String fileName) {
//
//                File quotes = null;
//                Resource resource = new ClassPathResource(fileName);
//
//                try {
//                    quotes = resource.getFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return quotes;
//                }
//
//                return quotes;
//            }
//        }

        try {
            FileReader fileReader = new FileReader(filename);
            System.out.println("FileReader " + fileReader.getClass());
            reader = new BufferedReader(fileReader);
            //reader = new BufferedReader(new FileReader(INPUT_FILE));
            System.out.println("Buffered reader created " + reader.getClass());
        } catch (FileNotFoundException e) {
            throw new DataException("File not found", e);
        }

        // Reading data using readLine

        try {
            while ((line = reader.readLine()) != null) {
                System.out.println("Line read " + line);
                readLines.add(line);
            }
        } catch (IOException e) {
            throw new DataException("IO Exception", e);
        }

        System.out.println("Finished reading file");
        int i = 0;
        for ( String line1 : readLines ) {
            System.out.println("Read LIne " + i + line1);
            i++;

        }
//^(?:[+\-]{0,1}[\d]+(?:\.[\d]+)*\s*){2}$
        return readLines;
    }

}
