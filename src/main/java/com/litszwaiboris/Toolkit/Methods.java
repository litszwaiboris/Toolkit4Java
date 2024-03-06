package com.litszwaiboris.Toolkit;

import java.io.*;
import java.util.*;
import static java.lang.Thread.*;
import org.apache.commons.lang3.*;

// Class initialization
public class Methods {
    // Check if Toolkit is compatible
    public static void check() throws NullPointerException, InterruptedException {
        // Command line colors
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";
        final String ANSI_BOLD = "\u001B[1m";

        String os = SystemUtils.OS_NAME;
        System.out.println("Checking Environment:");
        System.out.println("OS: " + os);
        System.out.print("OS Supported: ");
        if (SystemUtils.IS_OS_MAC) {
            System.out.println(ANSI_BOLD + ANSI_GREEN + "Yes" + ANSI_RESET);
        }
        else {
            System.out.println(ANSI_BOLD + ANSI_RED + "No" + ANSI_RESET);
            System.out.println();
            System.out.println("This operating system does not support Boris' Toolkit, press Enter to exit");

            // Detect enter
            Scanner detect = new Scanner(System.in);
            String keyPressed = detect.nextLine();
            detect.close();

            if (Objects.equals(keyPressed, "")) {
                return;
            }
        }
        sleep(1000);
    }

    // Method to invoke shell commands
    private static void command(String arg) throws IOException {
        String[] command = {"bash", "-c", arg};
        Process a = new ProcessBuilder(command).start();
        String line = null;
        BufferedReader is = new BufferedReader(new InputStreamReader(a.getInputStream()));
        while ((line = is.readLine()) != null) {
            System.out.println(line);
        }
    }

    // Delete Launchpad Apps Function
    public static void del_launchpad_apps() throws IOException, InterruptedException {

        // Run confirmation
        System.out.println("Run? yes/no");
        Scanner firstConfirm = new Scanner(System.in);
        String firstAnswer = firstConfirm.nextLine();

        if (Objects.equals(firstAnswer, "yes")) {
            // Ask for app name
            System.out.println("What is the name of the application?");
            Scanner AppName = new Scanner(System.in);
            String appName = AppName.nextLine();

            // Final chance before execution
            System.out.println("Confirm? yes/no");
            Scanner userInput = new Scanner(System.in);
            String secondAnswer = userInput.nextLine();
            userInput.close();

            if (Objects.equals(secondAnswer, "yes")) {
                command("sqlite3 $(getconf DARWIN_USER_DIR)com.apple.dock.launchpad/db/db \"DELETE FROM apps WHERE title='" + appName + "'" + '"');
                System.out.println("Completed.");
                sleep(1000);
            }
            return;
        }
    }

    // Reset Launchpad Layout
    public static void reset_launchpad() throws IOException, InterruptedException {

        // Run confirmation
        System.out.println("Run? yes/no");
        Scanner firstConfirm = new Scanner(System.in);
        String firstAnswer = firstConfirm.nextLine();

        if (Objects.equals(firstAnswer, "yes")) {
            // Final chance before execution
            System.out.println("Confirm? yes/no");
            Scanner userInput = new Scanner(System.in);
            String secondAnswer = userInput.nextLine();
            userInput.close();

            if (Objects.equals(secondAnswer, "yes")) {
                command("defaults write com.apple.dock ResetLaunchPad -bool true");
                command("killall Dock");
                System.out.println("Completed.");
                sleep(1000);
            }
            return;
        }
        return;
    }

    // Disable/Enable Desktop Icons
    public static void desktop_icons() throws IOException, InterruptedException {

        // Run confirmation
        System.out.println("Run? yes/no");
        Scanner firstConfirm = new Scanner(System.in);
        String firstAnswer = firstConfirm.nextLine();

        if (Objects.equals(firstAnswer, "yes")) {

            // Enable or Disable
            System.out.println("Enable/Disable Desktop Icons?");
            Scanner eORd = new Scanner(System.in);
            String eORdReturn = eORd.nextLine();

            if (Objects.equals(eORdReturn, "Enable")) {

                // Final chance before execution
                System.out.println("Confirm? yes/no");
                Scanner userInput = new Scanner(System.in);
                String secondAnswer = userInput.nextLine();
                userInput.close();

                if (Objects.equals(secondAnswer, "yes")) {
                    command("defaults write com.apple.Finder CreateDesktop true");
                    command("killall Finder");
                    command("Killall Dock");
                    System.out.println("Completed.");
                    sleep(1000);
                }
                return;
            }
            else if (Objects.equals(eORdReturn, "Disable")) {

                // Final chance before execution
                System.out.println("Confirm? yes/no");
                Scanner userInput = new Scanner(System.in);
                String secondAnswer = userInput.nextLine();
                userInput.close();

                if (Objects.equals(secondAnswer, "yes")) {
                    command("defaults write com.apple.Finder CreateDesktop false");
                    command("killall Finder");
                    command("Killall Dock");
                    System.out.println("Completed.");
                    sleep(1000);
                }
                return;
            }
            return;

        }
        return;

    }
}