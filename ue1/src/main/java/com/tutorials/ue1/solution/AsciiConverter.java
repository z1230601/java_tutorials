package com.tutorials.ue1.solution;

import java.nio.charset.StandardCharsets;

public class AsciiConverter {
    public static void main(String[] args) {
        if (args == null || (args.length != 1 && args.length != 2)) {
            System.out.print("At least the input string has to be provided as string.\n");
            return; // optionally System.exit(-1);
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("-d")) {
            String input = args[1];
            String[] inputs = input.split(" ");
            byte[] binaryRepresentation = new byte[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                String numberAsString = inputs[i];
                binaryRepresentation[i] = Byte.parseByte(numberAsString);
            }
            String completeString = new String(binaryRepresentation);
            System.out.println(completeString);
        } else if (args.length == 1) {
            String input = args[0];
            byte[] inputAsByteArray = input.getBytes(StandardCharsets.UTF_8);
            for (int i=0; i < inputAsByteArray.length; i++) {
                System.out.print(inputAsByteArray[i]);
                if ( i != inputAsByteArray.length - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
