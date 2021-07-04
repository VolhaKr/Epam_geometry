package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.data.DataReader;
import com.epam.geometry.model.Triangle;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class DirectorTest {
    private Director director;
    DataReader dataReader;
    StringTo3PointsSieve stringTo3PointsSieve;
    TriangleCreator triangleCreator;
    ArrayList expectedList = null;
    Triangle triangle;

    @Test
    public void testPointsLieOnOneLineShouldThrowException() throws DataException {
        expectedList = new ArrayList<Triangle>();
        triangle = new Triangle(new double[]{12.5, -45.78, 6, 7, -8, 0});
        expectedList.add(triangle);

        StringTo3PointsSieve stringTo3PointsSieve = new StringTo3PointsSieve();
        TriangleCreator triangleCreator = new TriangleCreator();
        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.readLines(anyString())).thenReturn(Arrays.asList("1 2 3 5 6 7,8 9", "12.5 -45.78 6 7 -8 0", "1 1 0 78 -89",
                "as iouiu 12 4 6 7.8", "1 2 3", "23 67 78 89 -9 -67 678 89 898", "5 0 7 0 1 0", "23 67 78 89 -9 -67 678 89 898"));
        director = new Director(dataReader, stringTo3PointsSieve, triangleCreator);

        List<Triangle> resultList = director.process("src/resources/file.txt");
        Assert.assertArrayEquals(new List[]{resultList}, new List[]{expectedList});

    }
}
