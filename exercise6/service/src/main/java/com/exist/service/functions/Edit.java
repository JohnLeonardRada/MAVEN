package com.exist.service.functions;

import com.exist.model.Matrix;
import com.exist.utility.Reader;

public class Edit {
    public static void editStringKey(Matrix matrix, String searchKey, String newValue){
        for(int rowIndex = 0; rowIndex < matrix.getArrayMatrix().size(); rowIndex++){
            for (int colIndex = 0; colIndex < matrix.getArrayMatrix().get(rowIndex).size(); colIndex++) {
                if(matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey().equals(searchKey)){
                    newValue = Reader.readString("Enter new value");
                    matrix.getArrayMatrix().get(rowIndex).get(colIndex).setKey(newValue);
                    System.out.println("Updated value at [" + rowIndex + "," + colIndex + "] = " + newValue);
                }
            }
        }
    }

    public static void editStringValue(Matrix matrix, String searchKey, String newValue){
        for(int rowIndex = 0; rowIndex < matrix.getArrayMatrix().size(); rowIndex++){
            for (int colIndex = 0; colIndex < matrix.getArrayMatrix().get(rowIndex).size(); colIndex++) {
                if(matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey().equals(searchKey)){
                    newValue = Reader.readString("Enter new value");
                    matrix.getArrayMatrix().get(rowIndex).get(colIndex).setValue(newValue);
                    System.out.println("Updated value at [" + rowIndex + "," + colIndex + "] = " + newValue);
                }
            }
        }
    }
}
