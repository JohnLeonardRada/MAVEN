package com.exist.app;
import java.io.FileNotFoundException;

import com.exist.service.controller.MatrixController;

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
