package com.exist.service.functions;

import com.exist.model.Matrix;
import com.exist.service.utility.Helper;
import com.exist.service.view.MatrixView;

import org.apache.commons.lang3.StringUtils;

public class Search {
    static MatrixView matrixView = new MatrixView();
    public static void searchString(Matrix matrix, String search, int total){
        for (int rowIndex = 0 ; rowIndex < matrix.getArrayMatrix().size(); rowIndex++){
            for (int colIndex = 0 ; colIndex < matrix.getArrayMatrix().get(rowIndex).size(); colIndex++){
                if(StringUtils.containsAny(matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey(), search)){
                    int StringCtr = Helper.countString(matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey(), search);
                    System.out.println("Found " + search + " on [" + rowIndex + "," + colIndex + "] with " + StringCtr + " occurences on key field");
                    ++total;
                }else if(matrix.getArrayMatrix().get(rowIndex).get(colIndex).getValue().contains(search)){
                    int StringCtr = Helper.countString(matrix.getArrayMatrix().get(rowIndex).get(colIndex).getValue(), search);
                    System.out.println("Found " + search + " on [" + rowIndex + "," + colIndex + "] with " + StringCtr + " occurences on value field");
                    ++total;
                }
            }
        }
        matrixView.searchCtr(total);
    }
}
