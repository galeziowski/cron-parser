package org.example;

import org.example.format.StandardFormat;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        if(args.length!=1) {
            throw new RuntimeException("Wrong command line input parameters number provided");
        }
        OutputGenerator.printOutput(new StandardFormat().parseInputString(args[0]));
    }



}
