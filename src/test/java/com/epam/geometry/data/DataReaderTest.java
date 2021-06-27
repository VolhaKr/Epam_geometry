package com.epam.geometry.data;

import com.epam.geometry.logic.Logic;
import com.epam.geometry.model.Triangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {


    private DataReader dataReader;
    private List readList = new ArrayList();

    @Before
    public void prepare() {
        dataReader = new DataReader();
    }


    @Test
    public void testDataReaderShouldReturnReadList() {
        final String INPUT_FILE = "src/resources/filefortest.txt";
        List<String> expectedReadLines = new ArrayList(Arrays.asList(new String[]{
                "this is test for reading lines",
                "1 2 3 465,78"}));
        try {
            readList = dataReader.readLines(INPUT_FILE);
        } catch (DataException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expectedReadLines, readList);
    }

    @Test
    public void testDataReaderShouldThrowException() {
        final String INPUT_FILE = "src/resources/notexistingfile.txt";
        boolean thrown = false;
        try {
            readList = dataReader.readLines(INPUT_FILE);
        } catch (DataException e) {
            thrown = true;
        }
        thrown = true;
        Assert.assertTrue(thrown);
    }
}
