package com.exist.service.functions;

import java.util.ArrayList;

import com.exist.model.Content;
import com.exist.model.Matrix;

import org.junit.Assert;
import org.junit.Test;

public class ResetTest {
    
    @Test
    public void resetMatrixTest(){
        ArrayList<ArrayList<Content>> arrayMatrix = new ArrayList<ArrayList<Content>>();
        Matrix matrix = new Matrix(arrayMatrix, 3, 3);

        int newRow = 4;
        int newCol = 4;

        Reset.resetMatrix(matrix, newRow, newCol);
        Assert.assertEquals(matrix.getArrayMatrix().get(newRow).size(), 4);
        Assert.assertEquals(matrix.getArrayMatrix().get(newCol).size(), 4);
    }
}
