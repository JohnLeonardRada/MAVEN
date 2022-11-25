package com.exist.app;
import java.io.FileNotFoundException;

import com.exist.service.controller.matrixController;

public class mainController {
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("    Java Exercise 2");
        
        if(args.length == 0){
            matrixController mc = new matrixController();
            mc.actionMenu();
        }else{
            matrixController mc = new matrixController(args[0]);
            mc.actionMenu();
        }
    }
}
