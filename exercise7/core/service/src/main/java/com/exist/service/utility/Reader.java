package com.exist.service.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Reader {

    public static BufferedReader getReader() {
		BufferedReader reader= new BufferedReader (new InputStreamReader(System.in));
		return reader;
	}

    public static String readString(String message) {
		String input= null;
		try {
			System.out.print(message + ": ");
			input= getReader().readLine();
		}
		catch(Exception e) {
		}
		return input;
	}

	public static boolean readBoolean(String message){
		String input = readString(message + "[Y]|[N]");

		if(input.equals("y".toUpperCase())){
			return true;
		}else if(input.equals("n".toUpperCase())){
			return false;
		}else {
			System.out.println("Must be [Y]|[N] only.");
            return readBoolean(message);
		}
	}
	
    public static int readInt(String message) {
        //ISSUE, this not working, value is null when wrong input then good input
        int input = 0;
		try {
			System.out.print(message + ": ");
			input= Integer.parseInt(getReader().readLine());
            return input;
		}
        catch(NumberFormatException  e){
            System.out.println("Must be an integer ");
            return readInt(message);
        }
		catch(Exception e) {
            System.out.println("Must be an integer ");
            return readInt(message);
		}
	}
	
	public static float readFloat(String message) {
		float input= (float) 0.00;
		try {
			System.out.print(message + ": ");
			input= Float.parseFloat(getReader().readLine());
		}
		catch(Exception e) {
		}
		return input;
	}
	
	public static double readDouble(String message) {
		double input= 0.00;
		try {
			System.out.print(message + ": ");
			input= Double.parseDouble(getReader().readLine());
		}
		catch(Exception e) {
		}
		return input;
	}

	public static LocalDate readLocalDate(String message){
        int day = Reader.readInt("Enter Day");
        int month = Reader.readInt("Enter Month");
        int year = Reader.readInt("Enter Year");

        try{
            LocalDate date = LocalDate.of(year, month, day);
            return date;
        }catch(DateTimeException e){
            System.out.println("Invalid date please try again ");
            return readLocalDate(message);
        }
    }
	
}