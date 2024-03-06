package com.litszwaiboris.Toolkit;

import java.io.*;
import java.util.*;

// Class Initialization
public class Main {

    // Main function
    public static void main(String[] arg) throws IOException, InterruptedException {

        // Run Check
        Methods.check();

        // Clear screen
        System.out.println("\033[H\033[2J");
        System.out.flush();

        // Main Menu
        System.out.println("Boris' Toolkit for Mac Java Special Edition");
        System.out.println("Congrats for this dumb mf to finally learn java");
        System.out.println();
        System.out.println("Hello user. Please choose your choice of function");
        System.out.println("1. Delete Launchpad Apps");
        System.out.println("2. Reset Launchpad");
        System.out.println("3. Enable/Disable Hide Desktop Icons");
        System.out.println("4. Exit Toolkit");

        // Menu navigation
        Scanner userInput = new Scanner(System.in);
        String answer = userInput.nextLine();
        switch (answer) {
            case "1":
                Methods.del_launchpad_apps();
                break;
            case "2":
                Methods.reset_launchpad();
                break;
            case "3":
                Methods.desktop_icons();
                break;
            case "4":
                break;
        }
    }

}
