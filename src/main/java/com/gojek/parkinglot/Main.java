package com.gojek.parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        switch (args.length) {
            case 0:
                System.out.println("Input:");
                for (;;) {
                    try {
                        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                        String inputString = bufferRead.readLine();
                        if ((inputString == null) || (inputString.isEmpty())) {
                            // Do nothing
                        } else {
                            inputParser.parseTextInput(inputString.trim());
                        }
                    } catch(IOException e) {
                        System.out.println("Error reading the input");
                        e.printStackTrace();
                    }
                }
            case 1:
                inputParser.parseFileInput(args[0]);
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
}
