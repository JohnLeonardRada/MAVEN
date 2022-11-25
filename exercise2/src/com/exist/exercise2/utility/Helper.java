package com.exist.exercise2.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exist.exercise2.model.Content;
import com.exist.exercise2.model.Matrix;

public class Helper {
    static String ASCII = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String asciiGenerator(){
        Random random = new Random();
        StringBuilder asciiBuilder = new StringBuilder();

        while (asciiBuilder.length() < 3) { // length of the random string.
            int index = (int) (random.nextFloat() * ASCII.length());
            asciiBuilder.append(ASCII.charAt(index));
        }
        String asciiString = asciiBuilder.toString();
        return asciiString;
    }

    
    public static int countString(String str, String searchString){
        int count = 0;    
        
        String countString [] = str.split("");

        //Counts each character except space    
        for(int i = 0; i < countString.length; i++) {    
            if(searchString.contains(countString[i])){
                count++;    
            } 
        }    
        return count;
    }

    public static void concatString(ArrayList<ArrayList<String>> concatStringValues, Matrix matrix){
        for (int rowIndex = 0; rowIndex < matrix.getArrayMatrix().size(); rowIndex++){
            ArrayList<String> rowContent = new ArrayList<String>();
            for(int colIndex = 0; colIndex < matrix.getArrayMatrix().get(rowIndex).size(); colIndex++){
                String concatValues = matrix.getArrayMatrix().get(rowIndex).get(colIndex).getValue();
                rowContent.add(concatValues);
            }
            concatStringValues.add(rowContent);
        }
    }

    public static void saveValues(ArrayList<ArrayList<String>> concatStringValues, Matrix matrix){
        for (int rowIndex = 0; rowIndex < matrix.getArrayMatrix().size(); rowIndex++){
            for(int colIndex = 0; colIndex < matrix.getArrayMatrix().get(rowIndex).size(); colIndex++){
                matrix.getArrayMatrix().get(rowIndex).get(colIndex).setValue(concatStringValues.get(rowIndex).get(colIndex));
            }
        }
    }

    public static void readFile(String filepath, Matrix matrix) throws FileNotFoundException{
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        Scanner scanner = new Scanner(br);
        ArrayList<Content> listContent = new ArrayList<Content>();

        while(scanner.hasNext()){    
            String line = scanner.next();

            Matcher match = Pattern.compile("\\(([^)]+)\\)").matcher(line);
            while(match.find()){
                String key = Helper.asciiGenerator();
                String value = match.group(1);
                listContent.add(new Content(key, value));
            }
            
            if(scanner.hasNextLine()){
                matrix.getArrayMatrix().add(listContent);
                listContent = new ArrayList<Content>();
            }
            //System.out.println(line);
        }                      
       scanner.close();
    }

    public static void readFile2(String filepath, Matrix matrix) throws FileNotFoundException{
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Scanner sc = new Scanner(br);
            ArrayList<Content> listContent = new ArrayList<Content>();

            while(sc.hasNext()){
                String line = sc.next();
                String[] details = line.split(":");

                String key = details[0];
                String value = details[1];
                Content content = new Content(key, value);
                listContent.add(content);
                
                if(sc.hasNextLine()){  
                    matrix.getArrayMatrix().add(listContent);
                    listContent = new ArrayList<Content>();
                }
            }
            for (int indexRow = 0; indexRow < matrix.getArrayMatrix().size(); indexRow++) {
                matrix.getArrayMatrix().get(indexRow).stream().forEach((content)->
                    System.out.printf(content.getKey() + ":" + content.getValue())
                );
                System.out.println();
            }       
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
