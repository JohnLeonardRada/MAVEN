package com.exist.exercise2.controller;

import java.io.FileNotFoundException;

public class MainController {
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("    Java Exercise 2");
        MatrixController mc = new MatrixController();
        mc.actionMenu();
    }
}
