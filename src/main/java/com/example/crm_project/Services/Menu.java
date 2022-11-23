package com.example.crm_project.Services;

import com.example.crm_project.utils.Commands;

import java.util.Scanner;

import static com.example.crm_project.Services.InputService.EXIT;
import static com.example.crm_project.Services.InputService.YES;
import static com.example.crm_project.utils.Prints.exitApp;
import static com.example.crm_project.utils.TypeWriter.typewriterFromString;

public class Menu {
    private static InputService inputSVC;
    public static void mainMenu() {

        String input;
        do {
            typewriterFromString(Commands.MenuMessage, 0);
            input = new Scanner(System.in).nextLine();
            inputSVC.executeCommand(input);

        } while (input.equals(EXIT));

        exitApp();
        System.exit(0);
    }
}
