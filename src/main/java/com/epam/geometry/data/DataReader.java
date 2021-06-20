package com.epam.geometry.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
public void readDataLineByLine(String directoryPath, String INPUT_FILE) {
        String inputFilePath = String.valueOf(Paths.get(directoryPath + INPUT_FILE));
        String INPUT_FILE;
        try {
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(1).build();
        String[] nextRecord = new String[0];

        // we are going to read data line by line
        while ((nextRecord = csvReader.readNext()) != null) {
        System.out.print(nextRecord[COUNTRY_COLUMN] + "\t");
        System.out.print(nextRecord[COMPANY_COLUMN] + "\t");
        System.out.println();
        putToCountryCompanies(nextRecord[COUNTRY_COLUMN], nextRecord[COMPANY_COLUMN]);
        }
        } catch (Exception e) {
        e.printStackTrace();
        }
        }
public class DataReader {

    //TODO: implement this method using BufferedReader, do not throw original IOException, wrap it with your own
    public List<String> readLines(String filename) throws DataException {
        final String INPUT_FILE= null;

        {
//            FileReader fr = new FileReader(INPUT_FILE);
//            BufferedReader br = new BufferedReader(fr);
            String line = null;
            System.out.println("Reading fom file");
            BufferedReader reader =
                    null;
            try {
                reader = new BufferedReader(new FileReader(System.getProperty("user.dir") +
                        "\\src\\com\\jcg\\test-file.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // Reading data using readLine
            while (true) {
                try {
                    if (!((line = reader.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                // Printing the read line
//                System.out.println(line);
            }
            System.out.println("Finished reading file");
        }
//^(?:[+\-]{0,1}[\d]+(?:\.[\d]+)*\s*){2}$


            throw new UnsupportedOperationException();
        }
    }
}
