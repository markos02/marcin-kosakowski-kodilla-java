package com.kodilla.stream.beautifier;

public class AdvancedDecorator {

    public static void frame(String string) {

        String frame = "*".repeat(string.length() + 4);

        System.out.println(frame);
        System.out.println("* " + string + " *");
        System.out.println(frame);
    }

    public static void addSpaces(String string) {
        System.out.println(string.replace("", " ").trim().toUpperCase());
    }
}
