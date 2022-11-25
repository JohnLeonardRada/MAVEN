package com.exist.exercise4.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exist.exercise4.model.Matrix;

import org.apache.commons.lang3.RandomStringUtils;

import com.exist.exercise4.model.Content;

public class Helper {
    public static String asciiGenerator(){
        String randomString = RandomStringUtils.randomAlphanumeric(3);
        return randomString;
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
                String concatValues = matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey() + matrix.getArrayMatrix().get(rowIndex).get(colIndex).getValue();
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

    public static void saveToFIle(String filepath, Matrix matrix){
        try {
            FileWriter fw = new FileWriter(filepath);
            Writer output = new BufferedWriter(fw);
            
            for(int rowIndex = 0; rowIndex < matrix.getArrayMatrix().size(); rowIndex++){
                for (int colIndex = 0; colIndex < matrix.getArrayMatrix().get(rowIndex).size(); colIndex++) {
                    output.write("[" + matrix.getArrayMatrix().get(rowIndex).get(colIndex).getKey() + ":(" + matrix.getArrayMatrix().get(rowIndex).get(colIndex).getValue() + ")]");
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
