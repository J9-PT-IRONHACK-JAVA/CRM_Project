package com.example.crm_project.Services;

import com.example.crm_project.utils.Commands;

import static com.example.crm_project.utils.TypeWriter.typewriterFromString;

public class Menu {
    public static void mainMenu() {
        typewriterFromString(Commands.MenuMessage, 0);
    }
}
