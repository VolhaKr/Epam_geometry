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
    public static final String INPUT_FILE = "src/resources/file.txt";


    public List<String> readLines(String fileName) throws DataException {
               Path path = Paths.get(fileName);
        System.out.println("path " + path);
//String inputFilePath = String.valueOf(Paths.get(directoryPath + INPUT_FILE));

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





       // System.out.println("Reading fom file");
        try {
            
            fileReader = new FileReader(String.valueOf(path));
            System.out.println(String.valueOf(path));
          //  System.out.println("FileReader " + fileReader.getClass());
            reader = new BufferedReader(fileReader);
            //reader = new BufferedReader(new FileReader(INPUT_FILE));
            System.out.println("Buffered reader created " + reader.getClass());
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

//        System.out.println("Finished reading file");
//        int i = 0;
//        for ( String line1 : readLines ) {
//            System.out.println("Read Line " + i + line1);
//            i++;
////        }

        try {
            fileReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLines;
    }
}
