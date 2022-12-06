package com.example.crm_project.Services;

import com.example.crm_project.utils.Commands;
import com.example.crm_project.utils.ConsoleColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.example.crm_project.utils.Prints.exitApp;
import static com.example.crm_project.utils.TypeWriter.typewriterFromString;
@Component
public class Menu {


    //Pk no va con autowired??????????????
//    private static CrmService crmService = new CrmService();
    @Autowired
    private CrmService crmService;
    @Autowired
    private ConsoleColors consoleColors;
    @Autowired
    private LoginService loginService;
    public void mainMenu() {

        loginService.login();

        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Welcome to your favorite CRM system. How can I help you today?");

        Scanner sc = new Scanner(System.in);
        String input;

        do {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + " 🤔 What do you wanna do? 🤔" + ConsoleColors.RESET );
            input = sc.nextLine().trim().toLowerCase();
            if (input.equals(crmService.getEXIT())){
                exitApp();
                System.exit(0);
            }
            crmService.executeCommand(input, sc);


        } while (true);

    }
}
