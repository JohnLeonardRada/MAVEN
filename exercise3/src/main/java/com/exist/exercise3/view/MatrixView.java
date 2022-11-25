package com.exist.exercise3.view;

public class MatrixView {
    
    public void actionMenu(){
        System.out.println("--------MENU--------" );
    }

    public void addRow(){
        System.out.println("-------Add Row-------");
    }

    public void addCol(){
        System.out.println("-------Add Col-------");
    }

    public void searchString(){
        System.out.println("-------Search-------");
    }

    public void searchCtr(int ctr){
        System.out.println("\nNumber of matches: " + ctr);  
    }

    public void editString(){
        System.out.println("-------Edit-------");
    }

    public void printMatrix(){
        System.out.println("-------Matrix-------");
    }

    public void sortMatrix(){
        System.out.println("-------Sort-------");
    }

    public void resetMatrix(){
        System.out.println("-------Reset-------");
    }

    public void invallidInput(){
        System.out.println("Invalid Input! Try Again!");
    }

    public void displayAction(){
        System.out.println("[1]=[Add Row]");
        System.out.println("[2]=[Add Col]");
        System.out.println("[3]=[Search]");
        System.out.println("[4]=[Edit]");
        System.out.println("[5]=[Print]");
        System.out.println("[6]=[Sort]");
        System.out.println("[7]=[Reset]");
        System.out.println("[0]=[Exit]");
    }
}
