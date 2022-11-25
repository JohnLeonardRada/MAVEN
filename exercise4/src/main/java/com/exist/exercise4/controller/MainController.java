package com.exist.exercise4.controller;

import java.io.FileNotFoundException;

public class MainController {
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("    Java Exercise 2");
        
        if(args.length == 0){
            MatrixController mc = new MatrixController();
            mc.actionMenu();
        }else{
            MatrixController mc = new MatrixController(args[0]);
            mc.actionMenu();
        }
    }
}
