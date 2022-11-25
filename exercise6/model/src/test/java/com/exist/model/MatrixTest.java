package com.exist.model;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class MatrixTest extends TestCase{
    
    @Test
    public void testMatrixOnInitial(){
        final int testRow = 3;
        final int testCol = 3;

        ArrayList<ArrayList<Content>> arrayMatrix = new ArrayList<ArrayList<Content>>();
        Matrix matrix = new Matrix(arrayMatrix, testRow, testCol);

        Assert.assertTrue(matrix.getArrayMatrix() != null);
        Assert.assertTrue(matrix.getRow() == 3);
        Assert.assertTrue(matrix.getCol() == 3);
        //For array index row assertion
        Assert.assertTrue(matrix.getArrayMatrix().get(0) != null);
        //For array index col assertion
        Assert.assertTrue(matrix.getArrayMatrix().get(0).get(0) != null);
    }

    @Test
    public void testMatrixOnCreate(){
        final int testRow = 3;
        final int testCol = 3;

        ArrayList<ArrayList<Content>> arrayMatrix = new ArrayList<ArrayList<Content>>();
        Matrix matrix = new Matrix(arrayMatrix, testRow, testCol);

        matrix.setArrayMatrix(arrayMatrix);
        matrix.setRow(testRow);
        matrix.setCol(testCol);
        
        Assert.assertTrue(matrix.getArrayMatrix() != null);
        Assert.assertTrue(matrix.getRow() == 3);
        Assert.assertTrue(matrix.getCol() == 3);
        //For array index row assertion
        Assert.assertTrue(matrix.getArrayMatrix().get(0) != null);
        //For array index col assertion
        Assert.assertTrue(matrix.getArrayMatrix().get(0).get(0) != null);
    }
}
