package com.example.crm_project.Services;

import com.example.crm_project.utils.Commands;
import com.example.crm_project.utils.ConsoleColors;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.example.crm_project.utils.TypeWriter.typewriterFromString;

@Data
@NoArgsConstructor
@Component
public class ReportInputService {

    public void mainRepo(Scanner sc){

        boolean exit;
        String input;
        exit = false;
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Enter Kind of functionality to report");
        do{
            input = sc.nextLine().trim().toLowerCase();
            exit = mainRepoSwitch(input);
        }while(!exit);

    }
    public boolean mainRepoSwitch(String input){
        boolean exit = false;
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
                case "EmployeeCount States":
                    break;
                case "Quantity States":
                    break;
                case "Opportunity States":
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Please Enter a correct command or enter ( help ) to see the avaible commands");
                    break;
            }
            return exit;
    }
}
