package com.exist.service.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.exist.model.Content;
import com.exist.model.Matrix;
import com.exist.service.functions.*;
import com.exist.service.utility.Helper;
import com.exist.service.view.MatrixView;
import com.exist.utility.Reader;

public class matrixController {
    int row;
    int col;
    String readFileLocation;
    String saveFileLocation;
    String defSaveLocation;

    Matrix matrix;
    MatrixView matrixView;
    ArrayList<ArrayList<Content>> arrayMatrix;

    public matrixController() throws FileNotFoundException{
        this.arrayMatrix = new ArrayList<ArrayList<Content>>();
        this.matrix = new Matrix(arrayMatrix, this.row, this.col);
        this.matrixView = new MatrixView();
        this.readFileLocation = "C:\\Users\\user\\Desktop\\PracticeMaven\\TextFile\\readSample.txt";
        this.saveFileLocation = "C:\\Users\\user\\Desktop\\PracticeMaven\\TextFile\\saveSample.txt";
        this.defSaveLocation = new File("C:\\Users\\user\\Desktop\\PracticeMaven\\TextFile").getAbsolutePath();
        try {
            Helper.readFile(this.defSaveLocation + "/readSample.txt", this.matrix);
        } catch (Exception e) {
            System.out.println("File Not Found! Saving to resources.");
            Helper.saveToFIle(this.defSaveLocation + "/saveSample.txt", this.matrix);
        }
    }

    public matrixController(String args){
        this.arrayMatrix = new ArrayList<ArrayList<Content>>();
        this.matrix = new Matrix(arrayMatrix, this.row, this.col);
        this.matrixView = new MatrixView();
        this.readFileLocation = args + "\\readSample.txt";
        this.saveFileLocation = args + "\\saveSample.txt";
        this.defSaveLocation = new File("C:\\Users\\user\\Desktop\\PracticeMaven\\exercise5-maven\\exercise5-maven\\app\\target").getAbsolutePath();
        try {
            Helper.readFile(this.defSaveLocation + "\\readSample.txt", this.matrix);
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found! Saving to resources.");
            Helper.saveToFIle(this.defSaveLocation + "\\saveSample.txt", this.matrix);
        }
    }

    // public void userInput(){
    //     try {
    //         this.row = Reader.readInt("Enter Row Dimension");
    //         this.col = Reader.readInt("Enter Column Dimension");
    //     } catch (Exception e) {
    //         e.getLocalizedMessage();
    //     }
    // }

    public void actionMenu(){
        Helper.saveToFIle(this.saveFileLocation, this.matrix);
        this.matrixView.actionMenu();
        this.matrixView.displayAction();
        int action;
        action = Reader.readInt("What's your action?");

        if(action == 1){
            addRow();
        }else if(action == 2){
            addCol();
        }else if(action == 3){
            searchString();
        }else if(action == 4){
            editString();
        }else if(action == 5){
            printMatrix();
        }else if(action == 6){
            sortMatrix();
        }else if(action == 7){
            resetMatrix();
        }else if(action == 0){
                
        }
        actionMenu();
    }

    public void addRow(){
        matrixView.addRow();
        
        try {
            int addRowInput;
            int colIndexInput;

            colIndexInput = Reader.readInt("Select Column");
            addRowInput = Reader.readInt("Add Row");
            
            Add.addRow(matrix, addRowInput, colIndexInput);
            
            fileSave();
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }

    public void addCol(){
        matrixView.addCol();

        int addColInput;
        int rowIndexInput;

        rowIndexInput = Reader.readInt("Select Row");
        addColInput = Reader.readInt("Add Column");

        if(addColInput <= 0){
            addColInput = this.matrix.getCol();
        }
        Add.addCol(matrix, addColInput, rowIndexInput);
        fileSave();
    }

    public void searchString(){
        matrixView.searchString();
        
        int total = 0;
        String search;
        search = Reader.readString("Search");

        Search.searchString(matrix, search, total);
    }

    public void editString(){
        matrixView.editString();
        
        String choice;
        String searchKey = "";
        String newValue = "";

        choice = Reader.readString("[K]Key || [V]Value");
        if(choice.toUpperCase().equals("K")){
            searchKey = Reader.readString("Enter key index");
            Edit.editStringKey(matrix, searchKey, newValue);
            fileSave();
        }else if(choice.toUpperCase().equals("V")){
            searchKey = Reader.readString("Enter key index");
            Edit.editStringValue(matrix, searchKey, newValue);
            fileSave();
        }else{
            matrixView.invallidInput();
            editString();
        }

    }

    public void printMatrix(){
        matrixView.printMatrix();
        try {
            Print.printMatrix(matrix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortMatrix(){
        matrixView.sortMatrix();
        
        String sortMatrix;
        sortMatrix = Reader.readString("[A]Ascending || [D]Descending");
        ArrayList<ArrayList<String>> stringValues = new ArrayList<ArrayList<String>>();
        Helper.concatString(stringValues, this.matrix);

        if(sortMatrix.toUpperCase().equals("A")){
            Sort.sortAscending(matrix);
            fileSave();
        }else if(sortMatrix.toUpperCase().equals("D")){
            Sort.sortDescending(matrix);
            fileSave();
        }else{
            matrixView.invallidInput();
            sortMatrix();
        }  
    }

    public void resetMatrix(){
        matrixView.resetMatrix();

        int newRow = 0;
        int newCol = 0;

        this.matrix.getArrayMatrix().clear();
        newRow = Reader.readInt("Enter new row dimension");
        newCol = Reader.readInt("Enter new column dimension");

        Reset.resetMatrix(matrix, newRow, newCol);
        fileSave();
    }

    public void fileSave(){
        Helper.saveToFIle(this.saveFileLocation, this.matrix);
        Helper.saveToFIle(this.defSaveLocation + "/saveSample.txt", this.matrix);
    }
}
