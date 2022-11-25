package com.exist.model;

import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;

public class Matrix {
    int row;
    int col;
    ArrayList<ArrayList<Content>> arrayMatrix;

    public Matrix(ArrayList<ArrayList<Content>> arrayMatrix, int row, int col){
        this.row = row;
        this.col = col;
        this.arrayMatrix = arrayMatrix;

        for (int rowIndex = 0 ; rowIndex < row; rowIndex++){
            ArrayList<Content> listContent = new ArrayList<Content>();
            for (int colIndex = 0; colIndex < col; colIndex++){
                Content content = new Content(asciiGenerator(), asciiGenerator());
                listContent.add(content);
            }
            this.arrayMatrix.add(listContent);
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public ArrayList<ArrayList<Content>> getArrayMatrix() {
        return arrayMatrix;
    }

    public void setArrayMatrix(ArrayList<ArrayList<Content>> arrayMatrix) {
        this.arrayMatrix = arrayMatrix;
    }

    
    public static String asciiGenerator(){
        String randomString = RandomStringUtils.randomAlphanumeric(3);
        return randomString;
    }
}
