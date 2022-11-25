package com.exist.service.view;

public class MatrixView {

    public MatrixView(){}
    
    public String actionMenu(){
        System.out.println("--------MENU--------");
        return "--------MENU--------";
    }

    public String addRow(){
        System.out.println("-------Add Row-------");
        return "-------Add Row-------";
    }

    public String addCol(){
        System.out.println("-------Add Col-------");
        return "-------Add Col-------";
    }

    public String searchString(){
        System.out.println("-------Search-------");
        return "-------Search-------";
    }

    public String searchCtr(int ctr){
        System.out.println("\nNumber of matches: " + ctr);  
        return "\nNumber of matches: ";
    }

    public String editString(){
        System.out.println("-------Edit-------");
        return "-------Edit-------";
    }

    public String printMatrix(){
        System.out.println("-------Matrix-------");
        return "-------Matrix-------";
    }

    public String sortMatrix(){
        System.out.println("-------Sort-------");
        return "-------Sort-------";
    }

    public String resetMatrix(){
        System.out.println("-------Reset-------");
        return "-------Reset-------";
    }

    public String invallidInput(){
        System.out.println("Invalid Input! Try Again!");
        return "Invalid Input! Try Again!";
    }

    public String displayAction(){
        System.out.println("[1]=[Add Row]");
        System.out.println("[2]=[Add Col]");
        System.out.println("[3]=[Search]");
        System.out.println("[4]=[Edit]");
        System.out.println("[5]=[Print]");
        System.out.println("[6]=[Sort]");
        System.out.println("[7]=[Reset]");
        System.out.println("[0]=[Exit]");
        return "\n[1]=[Add Row]\n[2]=[Add Col]\n[3]=[Search]\n[4]=[Edit]\n[5]=[Print]\n[6]=[Sort]\n[7]=[Reset]\n[0]=[Exit]";
    }
}
