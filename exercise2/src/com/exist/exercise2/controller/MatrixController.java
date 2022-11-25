package com.exist.exercise2.controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;

import com.exist.exercise2.model.Matrix;
import com.exist.exercise2.view.MatrixView;
import com.exist.exercise2.model.Content;
import com.exist.exercise2.utility.*;

public class MatrixController {
    int row;
    int col;
    String saveFileLocation;

    Matrix matrix;
    MatrixView matrixView;
    ArrayList<ArrayList<Content>> arrayMatrix;
    static String filePath = "C:/Users/user/Desktop/JavaExercises/sample.txt";

    public MatrixController() throws FileNotFoundException{
        this.arrayMatrix = new ArrayList<ArrayList<Content>>();
        this.matrix = new Matrix(arrayMatrix, this.row, this.col);
        this.matrixView = new MatrixView();
        Helper.readFile(filePath, this.matrix);
        this.saveFileLocation = Reader.readString("Enter save file location");
    }

    public void userInput(){
        try {
            this.row = Reader.readInt("Enter Row Dimension");
            this.col = Reader.readInt("Enter Column Dimension");
        } catch (Exception e) {
            return;
        }
    }

    public void actionMenu(){
        saveToFIle();
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
            System.exit(0);
        }
        actionMenu();
    }

    public void addRow(){
        matrixView.addRow();
        
        try {
            int add;
            int colInput;
            colInput = Reader.readInt("Select Column");
            add = Reader.readInt("Add Row");
            
            for (int rowIndex = 0 ; rowIndex < add; rowIndex++){
                ArrayList<Content> listContent = new ArrayList<Content>();
                for (int colIndex = 0; colIndex < colInput+1; colIndex++){
                    Content content = new Content(Helper.asciiGenerator(), Helper.asciiGenerator());
                    listContent.add(content);
                }
                this.arrayMatrix.add(listContent);
            }
            
            saveToFIle();
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
        
    }

    public void addCol(){
        matrixView.addCol();

        int addCol;
        int rowIndexInput;

        rowIndexInput = Reader.readInt("Select Row");
        addCol = Reader.readInt("Add Column");

        if(addCol <= 0){
            addCol = this.matrix.getCol();
        }
        for (int colIndex = 0; colIndex < addCol; colIndex++) {
            this.arrayMatrix.get(rowIndexInput).add(new Content(Helper.asciiGenerator(), Helper.asciiGenerator()));
        }
    }

    public void searchString(){
        matrixView.searchString();
        
        int total = 0;
        String search;
        search = Reader.readString("Search");

        for (int rowIndex = 0 ; rowIndex < this.matrix.getArrayMatrix().size(); rowIndex++){
            for (int colIndex = 0 ; colIndex < this.matrix.getArrayMatrix().get(rowIndex).size(); colIndex++){
                if(this.matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey().contains(search)){
                    int StringCtr = Helper.countString(this.matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey(), search);
                    System.out.println("Found " + search + " on [" + rowIndex + "," + colIndex + "] with " + StringCtr + " occurences on key field");
                    ++total;
                }else if(this.matrix.getArrayMatrix().get(rowIndex).get(colIndex).getValue().contains(search)){
                    int StringCtr = Helper.countString(this.matrix.getArrayMatrix().get(rowIndex).get(colIndex).getValue(), search);
                    System.out.println("Found " + search + " on [" + rowIndex + "," + colIndex + "] with " + StringCtr + " occurences on value field");
                    ++total;
                }
            }
        }
        matrixView.searchCtr(total);
    }

    public void editString(){
        matrixView.editString();
        
        String choice;
        String searchKey;
        String newValue;

        choice = Reader.readString("[K]Key || [V]Value");
        if(choice.toUpperCase().equals("K")){
            searchKey = Reader.readString("Enter key index");
        
            for(int rowIndex = 0; rowIndex < this.matrix.getArrayMatrix().size(); rowIndex++){
                for (int colIndex = 0; colIndex < this.matrix.getArrayMatrix().get(rowIndex).size(); colIndex++) {
                    if(this.matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey().equals(searchKey)){
                        newValue = Reader.readString("Enter new value");
                        this.matrix.getArrayMatrix().get(rowIndex).get(colIndex).setKey(newValue);
                        System.out.println("Updated value at [" + rowIndex + "," + colIndex + "] = " + newValue);
                    }
                }
            }
            saveToFIle();
        }else if(choice.toUpperCase().equals("V")){
            searchKey = Reader.readString("Enter key index");
        
            for(int rowIndex = 0; rowIndex < this.matrix.getArrayMatrix().size(); rowIndex++){
                for (int colIndex = 0; colIndex < this.matrix.getArrayMatrix().get(rowIndex).size(); colIndex++) {
                    if(this.matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey().equals(searchKey)){
                        newValue = Reader.readString("Enter new value");
                        this.matrix.getArrayMatrix().get(rowIndex).get(colIndex).setValue(newValue);
                        System.out.println("Updated value at [" + rowIndex + "," + colIndex + "] = " + newValue);
                    }
                }
            }
            saveToFIle();
        }else{
            matrixView.invallidInput();
            editString();
        }

    }

    public void printMatrix(){
        matrixView.printMatrix();
        try {
            for(int rowIndex = 0; rowIndex < this.matrix.getArrayMatrix().size(); rowIndex++){
                for (int colIndex = 0; colIndex < this.matrix.getArrayMatrix().get(rowIndex).size(); colIndex++) {
                    System.out.print("[" + this.matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey() + ":(" + this.matrix.getArrayMatrix().get(rowIndex).get(colIndex).getValue() + ")]");
                }
                System.out.println();
            }
        } catch (Exception e) {
            return;
        }
    }

    public void sortMatrix(){
        matrixView.sortMatrix();
        
        String sortMatrix;
        sortMatrix = Reader.readString("[A]Ascending || [D]Descending");
        ArrayList<ArrayList<String>> stringValues = new ArrayList<ArrayList<String>>();
        Helper.concatString(stringValues, this.matrix);

        for (int rowIndex = 0; rowIndex < this.matrix.getArrayMatrix().size(); rowIndex++){
            if(sortMatrix.toUpperCase().equals("A")){
                Collections.sort(stringValues.get(rowIndex));
                Helper.saveValues(stringValues, this.matrix);
                saveToFIle();
            }else if(sortMatrix.toUpperCase().equals("D")){
                Collections.sort(stringValues.get(rowIndex), Collections.reverseOrder());
                Helper.saveValues(stringValues, this.matrix);
                saveToFIle();
            }else{
                matrixView.invallidInput();
                sortMatrix();
            }
        }
    }

    public void resetMatrix(){
        matrixView.resetMatrix();

        int newRow = 0;
        int newCol = 0;

        newRow = Reader.readInt("Enter new row dimension");
        newCol = Reader.readInt("Enter new column dimension");

        this.matrix.getArrayMatrix().clear();
        for(int rowIndex = 0; rowIndex < newRow; rowIndex++){
            ArrayList<Content> listContent = new ArrayList<Content>();
            for (int colIndex = 0; colIndex < newCol; colIndex++) {
                Content content = new Content(Helper.asciiGenerator(), Helper.asciiGenerator());
                listContent.add(content);
            }
            this.arrayMatrix.add(listContent);
        }
        saveToFIle();
    }

    public void saveToFIle(){
        try {
            FileWriter fw = new FileWriter(this.saveFileLocation +"\\sampleSaveFile.txt");
            Writer output = new BufferedWriter(fw);
            
            for(int rowIndex = 0; rowIndex < this.matrix.getArrayMatrix().size(); rowIndex++){
                for (int colIndex = 0; colIndex < this.matrix.getArrayMatrix().get(rowIndex).size(); colIndex++) {
                    output.write("[" + this.matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey() + ":(" + this.matrix.getArrayMatrix().get(rowIndex).get(colIndex).getValue() + ")]");
                }
                output.write("\n");
            }
            
            output.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.getLocalizedMessage();
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }
}
