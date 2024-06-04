package com.litszwaiboris.Toolkit;

import java.io.*;
import java.util.*;

import static com.litszwaiboris.Toolkit.ANSI.*;
import static java.lang.Thread.*;
import org.apache.commons.lang3.*;

public class Methods {

    public static void MacCheck() throws NullPointerException, InterruptedException {
        String os = SystemUtils.OS_NAME;
        System.out.println("Checking Environment:");
        System.out.println("OS: " + os);
        System.out.print("OS Supported: ");
        if (SystemUtils.IS_OS_MAC) {
            System.out.println(ANSI_BOLD.value + ANSI_GREEN.value + "Yes" + ANSI_RESET.value);
        }
        else {
            System.out.println(ANSI_BOLD.value + ANSI_RED.value + "No" + ANSI_RESET.value);
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

    private static void command(String arg) throws IOException {
        String[] command = {"bash", "-c", arg};
        Process a = new ProcessBuilder(command).start();
        String line = null;
        BufferedReader is = new BufferedReader(new InputStreamReader(a.getInputStream()));
        while ((line = is.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static int confirm() {
        System.out.println("Confirm? yes/no");
        Scanner userInput = new Scanner(System.in);
        String Answer = userInput.nextLine();
        userInput.close();

        if (Answer.equalsIgnoreCase("yes")) {
            return 0;
        }
        else { return 1; }
    }

    public static void DisplayHelp() {
        System.out.println("Boris' Toolkit for Mac Java Special Edition");
        System.out.println("Usage:");
        System.out.println("-l --launchpad  Delete Launchpad Apps");
        System.out.println("-r --reset      Reset Launchpad");
        System.out.println("-d --desktop    Enable/Disable Hide Desktop Icons");
    }

    public static void del_launchpad_apps(String appName) throws IOException, InterruptedException {
        MacCheck();
        int confirm = confirm();
        if (Objects.equals(confirm, 0)) {
            command("sqlite3 $(getconf DARWIN_USER_DIR)com.apple.dock.launchpad/db/db \"DELETE FROM apps WHERE title='" + appName + "'" + '\"');
            System.out.println("Completed.");
            sleep(1000);
            System.exit(0);
        }
    }

    public static void reset_launchpad() throws IOException, InterruptedException {
        MacCheck();
        int confirm = confirm();
        if (Objects.equals(confirm, 0)) {
            command("defaults write com.apple.dock ResetLaunchPad -bool true");
            command("killall Dock");
            System.out.println("Completed.");
            sleep(1000);
            System.exit(0);
        }
    }

    public static void desktop_icons(String selection) throws IOException, InterruptedException {
        MacCheck();
        int confirm = confirm();
        if (selection.equals("enable")) {
            if (Objects.equals(confirm, 0)) {
                command("defaults write com.apple.Finder CreateDesktop true");
                command("killall Finder");
                command("Killall Dock");
                System.out.println("Completed.");
                sleep(1000);
                System.exit(0);
            }
        }
        else if (selection.equals("disable")) {
            if (Objects.equals(confirm, 0)) {
                command("defaults write com.apple.Finder CreateDesktop false");
                command("killall Finder");
                command("Killall Dock");
                System.out.println("Completed.");
                sleep(1000);
                System.exit(0);
            }
            return;
        }
    }
}
