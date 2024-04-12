package com.litszwaiboris.Toolkit;

import java.io.*;
import java.util.*;
import org.apache.commons.lang3.SystemUtils;

// Class Initialization
public class Main {

    // Main function
    public static void main(String[] arg) throws IOException, InterruptedException {

        List<String> Arguments = Arrays.asList(arg);

        if (Arguments.contains("-h") || Arguments.contains("--help")) {
            Methods.DisplayHelp();
        }
        else if (Arguments.contains("-l")) {
            Methods.del_launchpad_apps();
        }
        else if (Arguments.contains("-r")) {
            Methods.reset_launchpad();
        }
        else if (Arguments.contains("-d")) {
            Methods.desktop_icons();
        }
        else {
            Methods.DisplayHelp();
        }
    }
}
