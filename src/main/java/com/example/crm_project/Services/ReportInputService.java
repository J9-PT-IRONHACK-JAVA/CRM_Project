package com.example.crm_project.Services;

import com.example.crm_project.utils.Commands;
import com.example.crm_project.utils.ConsoleColors;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.example.crm_project.utils.ConsoleColors.printWithColor;
import static com.example.crm_project.utils.TypeWriter.typewriterFromString;

@Data
@NoArgsConstructor
@Component
public class ReportInputService {

    public void mainRepo(Scanner sc){

        boolean back = false;
        String input;
        do{
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Enter Kind of functionality to report");
            input = sc.nextLine().trim().toLowerCase();
            back = mainRepoSwitch(input);
        }while(!back);

    }
    public boolean mainRepoSwitch(String input){
        boolean back = false;
        switch(input){
                case "help":
                    typewriterFromString(Commands.mainReportMessage, 0);
                    break;
                case "sales rep":
                    break;
                case "product":
                    break;
                case "country":
                    break;
                case "city":
                    break;
                case "industry":
                    break;
                case "employeeCount states":
                    break;
                case "quantity states":
                    break;
                case "opportunity states":
                    break;
                case "back":
                     back = true;
                    break;
                default:
                    printWithColor("Command not recognized! Enter 'help' to see available commands.", ConsoleColors.RED);
                    break;
            }
            return back;
    }
}
