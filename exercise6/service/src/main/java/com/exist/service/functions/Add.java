package com.exist.service.functions;

import com.exist.model.Matrix;
import com.exist.service.utility.Helper;

import java.util.ArrayList;

import com.exist.model.Content;

public class Add {
    public static void addRow(Matrix matrix, int addRowInput, int colIndexInput){
        for (int rowIndex = 0 ; rowIndex < addRowInput; rowIndex++){
            ArrayList<Content> listContent = new ArrayList<Content>();
            for (int colIndex = 0; colIndex < colIndexInput+1; colIndex++){
                Content content = new Content(Helper.asciiGenerator(), Helper.asciiGenerator());
                listContent.add(content);
            }
            matrix.getArrayMatrix().add(listContent);
        }
    }

    public static void addCol(Matrix matrix, int addColInput, int rowIndexInput){
        for (int colIndex = 0; colIndex < addColInput; colIndex++) {
            matrix.getArrayMatrix().get(rowIndexInput).add(new Content(Helper.asciiGenerator(), Helper.asciiGenerator()));
        }
    }
}
