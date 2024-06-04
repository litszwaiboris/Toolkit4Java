package com.litszwaiboris.Toolkit;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> Arguments = Arrays.asList(args);

        if (args.length > 0) {
            if (Arguments.contains("-h") || Arguments.contains("--help")) {
                Methods.DisplayHelp();
                System.exit(0);
            }
            else if (Arguments.get(0).equals("-l") || Arguments.get(0).equals("--launchpad")) {
                    if (args.length > 2) {
                        if (Arguments.get(1).equals("-n") || Arguments.get(1).equals("--name")) {
                            Methods.del_launchpad_apps(Arguments.get(2));
                        }
                    }
                    else {
                        throw new IllegalArgumentException("Please specify app name.");
                    }

            }
            else if (Arguments.get(0).equals("-r") || Arguments.get(0).equals("--reset")) {
                Methods.reset_launchpad();
            }
            else if (Arguments.contains("-d") || Arguments.contains("--desktop")) {
                if (args.length > 1) {
                    if (Arguments.get(1).equals("--disable")) {
                        Methods.desktop_icons("disable");
                    } else if (Arguments.get(1).equals("--enable")) {
                        Methods.desktop_icons("enable");
                    }
                }
                else {
                    throw new IllegalArgumentException("Please use arguments --enable/--disable to modify desktop icons settings.");
                }
            }
        }
        else {
            Methods.DisplayHelp();
        }
    }
}

