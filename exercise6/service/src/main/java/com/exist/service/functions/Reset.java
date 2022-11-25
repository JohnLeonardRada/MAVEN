package com.exist.service.functions;

import java.util.ArrayList;

import com.exist.model.Content;
import com.exist.model.Matrix;
import com.exist.service.utility.Helper;

public class Reset {
    public static void resetMatrix(Matrix matrix, int newRow, int newCol){
        for(int rowIndex = 0; rowIndex < newRow; rowIndex++){
            ArrayList<Content> listContent = new ArrayList<Content>();
            for (int colIndex = 0; colIndex < newCol; colIndex++) {
                Content content = new Content(Helper.asciiGenerator(), Helper.asciiGenerator());
                listContent.add(content);
            }
            matrix.getArrayMatrix().add(listContent);
        }
    }
}
