package com.exist.service.functions;

import java.util.ArrayList;

import com.exist.model.Content;
import com.exist.model.Matrix;

import org.junit.Assert;
import org.junit.Test;

public class AddTest {
    
    @Test
    public void addRowTest(){
        ArrayList<ArrayList<Content>> arrayMatrix = new ArrayList<ArrayList<Content>>();
        Matrix matrix = new Matrix(arrayMatrix, 3, 3);

        int testColInput = 0;
        int testAddRowInput = 1;

        Add.addRow(matrix, testAddRowInput, testColInput);
        Assert.assertEquals(matrix.getArrayMatrix().get(testColInput).size(), 3);
    }

    @Test
    public void addColTest(){
        ArrayList<ArrayList<Content>> arrayMatrix = new ArrayList<ArrayList<Content>>();
        Matrix matrix = new Matrix(arrayMatrix, 3, 3);

        int testRowInput = 0;
        int testAddColInput = 1;

        Add.addCol(matrix, testAddColInput, testRowInput);
        Assert.assertEquals(matrix.getArrayMatrix().get(testRowInput).size(), 4);
    }
}
