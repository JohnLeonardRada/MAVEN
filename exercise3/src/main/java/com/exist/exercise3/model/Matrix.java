package com.exist.exercise3.model;

import java.util.ArrayList;

import com.exist.exercise3.utility.Helper;

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
                Content content = new Content(Helper.asciiGenerator(), Helper.asciiGenerator());
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
}
