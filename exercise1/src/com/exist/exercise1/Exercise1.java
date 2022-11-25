package com.exist.exercise1;

import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
    static Scanner sc = new Scanner(System.in); 
    static String [][] arrayValues;

    public static void main(String[] args) throws Exception {
        System.out.println("    Java Exercise 1");
        userInput();
        sc.close();
    }

    //Generate Values
    //Reference: https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
    public static String getSaltString() {
        String saltChars = "!#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~␡";
        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        while (salt.length() < 3) { // length of the random string.
            int index = (int) (random.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    //Dimension User input method
    public static void userInput(){
        String firstDimension;
        String secondDimension;
        
        //User input for dimension of the array
        System.out.print("Enter 1st Dimension: ");
        firstDimension = sc.nextLine();
        System.out.print("Enter 2nd Dimension: ");
        secondDimension = sc.nextLine();
        
        try {
            if(Integer.parseInt(firstDimension) > 0 && Integer.parseInt(secondDimension) > 0){
                arrayValues = new String[Integer.parseInt(firstDimension)][Integer.parseInt(secondDimension)];
       
                initilizeArray(arrayValues);
                actionMenu(arrayValues); 
            }else{
                userInput();
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Try Again!");
            userInput();
        }
        
    }
    //Generate values to the array
    public static String[][] initilizeArray(String[][] array){
        //Input values in the array
        for (int row = 0; row < array.length; row++){
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = getSaltString();
            }
        }
        return array;
    }

    //Action Menu 
    public static String actionMenu(String[][] array){
        String action;

        System.out.println("---------MENU---------" );
        System.out.println("[S]=[Search]\n[E]=[Edit]\n[P]=[Print]\n[R]=[Reset]\n[X]=[Exit]");

        System.out.print("What's your action? ");
        action = sc.nextLine();

        if(action.toLowerCase().equals("s")){
            searchString(array);
        }else if(action.toLowerCase().equals("e")){
            editIndex(array);
        }else if(action.toLowerCase().equals("p")){
            printArray(array);
        }else if(action.toLowerCase().equals("r")){
            array = resetDimension(array);
        }else if(action.toLowerCase().equals("x")){
            System.out.println("Thank you! Come back again!");
            System.exit(0);
        }else{
            System.out.println("Invalid Input! Try Again!\n");
        }
        return actionMenu(array);
    }

    //Search string method
    public static void searchString(String[][] array){
        String search;
        
        System.out.println("--------Search--------");
        System.out.print("Search: ");
            int ctr = 0;
            search = sc.nextLine();

            for(int row = 0; row < array.length; row++){
                for(int col = 0; col < array[row].length; col++){
                    if(array[row][col].contains(search.toUpperCase())){
                        ctr++;
                        System.out.println("Found " + search + " on [" + (Integer.toString(row)+","+Integer.toString(col)) + "]");
                    }
                }
            }
            System.out.println("Number of matches: " + ctr);
    }

    //Edit index in the 2d Array
    public static void editIndex(String[][] array){
        String searchIndex;
        String newValue;

        System.out.println("--------Edit--------");
        System.out.print("Enter index: (x,y) ");
        searchIndex = sc.nextLine();

        String[] indexArray = searchIndex.split(",");
        int indexRow = Integer.parseInt(indexArray[0]);
        int indexCol = Integer.parseInt(indexArray[1]);

        System.out.println("Found index at (" + indexRow + "," + indexCol + ") with a value of " + array[indexRow][indexCol]);
        System.out.print("Enter new value: ");
        newValue = sc.nextLine();

        if(newValue.length() > 3 || newValue.length() < 3){
            System.out.println("Invalid input! Try Again!");
            editIndex(array);
        }else {
            array[indexRow][indexCol] = newValue;
            System.out.println("Updated Value: " + newValue + " at index (" + indexRow + "," + indexCol + ")");
        }
    }

    //Print array table method
    public static void printArray(String[][] array){
        System.out.println("--------Matrix--------");
        for (int row = 0; row < array.length; row++){
            for (int col = 0; col < array[row].length; col++) {
                System.out.print("["+ array[row][col] + "]");
            }
            System.out.println();
        }
    }

    //Reset dimension array method
    public static String[][] resetDimension(String[][] array){
        String new1stDimension;
        String new2ndDimension;
        
        System.out.println("--------Reset--------");
        System.out.print("Enter new 1st Dimension: ");
        new1stDimension = sc.nextLine();
        System.out.print("Enter new 2nd Dimension: ");
        new2ndDimension = sc.nextLine();

        try {
            if(Integer.parseInt(new1stDimension) > 0 && Integer.parseInt(new2ndDimension) > 0){
                array = new String[Integer.parseInt(new1stDimension)][Integer.parseInt(new2ndDimension)];
                return initilizeArray(array);
            }else{
                return resetDimension(array);
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Try Again!");
            return resetDimension(array);
        }
    }
}
