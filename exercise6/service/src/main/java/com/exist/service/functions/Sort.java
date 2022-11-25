package com.exist.service.functions;

import java.util.ArrayList;
import java.util.Collections;

import com.exist.model.Matrix;
import com.exist.service.utility.Helper;

public class Sort {
    
    public static void sortAscending(Matrix matrix){
        ArrayList<ArrayList<String>> stringValues = new ArrayList<ArrayList<String>>();
        Helper.concatString(stringValues, matrix);

        for (int rowIndex = 0; rowIndex < matrix.getArrayMatrix().size(); rowIndex++){
            Collections.sort(stringValues.get(rowIndex));
            Helper.saveValues(stringValues, matrix);
        }
    }
    
    public static void sortDescending(Matrix matrix){
        ArrayList<ArrayList<String>> stringValues = new ArrayList<ArrayList<String>>();
        Helper.concatString(stringValues, matrix);

        for (int rowIndex = 0; rowIndex < matrix.getArrayMatrix().size(); rowIndex++){
            Collections.sort(stringValues.get(rowIndex), Collections.reverseOrder());
            Helper.saveValues(stringValues, matrix);
        }
    }
}
