package com.litszwaiboris.Toolkit;

public enum ANSI {
    ANSI_RESET("\u001B[0m"),
    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_BOLD("\u001B[1m");

    public final String value;

    ANSI(String value) {
        this.value = value;
    }
}
