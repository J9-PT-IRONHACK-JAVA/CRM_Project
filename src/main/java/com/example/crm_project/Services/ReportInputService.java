package com.example.crm_project.Services;

import com.example.crm_project.Repository.AccountRepository;
import com.example.crm_project.utils.Commands;
import com.example.crm_project.utils.ConsoleColors;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.example.crm_project.utils.ConsoleColors.printWithColor;
import static com.example.crm_project.utils.TypeWriter.typewriterFromString;

@Data
@NoArgsConstructor
@Component
public class ReportInputService {

    @Autowired
    private SalesRepService salesRepService;
    @Autowired
    private OpportunityService opportunityService;
    @Autowired
    private AccountService accountService;
    public void mainRepo(String logedUser, Scanner sc){

        boolean back = false;
        String input;
        do{
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Enter Kind of functionality to report");
            input = sc.nextLine();
            back = mainRepoSwitch(logedUser, input, sc);
        }while(!back);

    }
    public boolean mainRepoSwitch(String logedUser, String input, Scanner sc){
        boolean back = false;
        switch(input){
                case "help":
                    typewriterFromString(Commands.mainReportMessage, 0);
                    break;
                case "sales rep":
                    salesRepService.mainRep(logedUser, sc);
                    break;
                case "product":
                    opportunityService.mainOpp(logedUser, sc);
                    break;
                case "country":
                    opportunityService.mainOppByCountry(sc);
                    break;
                case "city":
                    accountService.mainOppByCity(sc);
                    break;
                case "industry":
                    accountService.mainOppByIndustry(sc);
                    break;
                case "EmployeeCount States":
                    opportunityService.mainCountEmploye(sc);
                    break;
                case "Quantity States":
                    opportunityService.mainCountProduct(sc);
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
