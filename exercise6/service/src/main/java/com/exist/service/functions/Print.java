package com.exist.service.functions;

import com.exist.model.Matrix;

public class Print {
    public static void printMatrix(Matrix matrix){
        for(int rowIndex = 0; rowIndex < matrix.getArrayMatrix().size(); rowIndex++){
            for (int colIndex = 0; colIndex < matrix.getArrayMatrix().get(rowIndex).size(); colIndex++) {
                System.out.print("[" + matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey() + ":(" + matrix.getArrayMatrix().get(rowIndex).get(colIndex).getValue() + ")]");
            }
            System.out.println();
        }
    }
}
