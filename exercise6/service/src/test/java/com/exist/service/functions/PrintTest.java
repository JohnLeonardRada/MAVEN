package com.exist.service.functions;

import java.util.ArrayList;

import com.exist.model.Content;
import com.exist.model.Matrix;

import org.junit.Test;

public class PrintTest {
    
    @Test
    public void printMatrixTest(){
        ArrayList<ArrayList<Content>> arrayMatrix = new ArrayList<ArrayList<Content>>();
        Matrix matrix = new Matrix(arrayMatrix, 3, 3);

        Print.printMatrix(matrix);
    }
}
