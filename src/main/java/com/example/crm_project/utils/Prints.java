package com.example.crm_project.utils;

import static com.example.crm_project.Services.InputService.clearConsole;

public class Prints {
    public static void exitApp() {
        clearConsole("");
        System.out.println("""
                Ok, see you soon!

                """);
    }
}
