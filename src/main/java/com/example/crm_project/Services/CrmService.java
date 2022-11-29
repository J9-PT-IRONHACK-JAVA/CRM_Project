package com.example.crm_project.Services;

import com.example.crm_project.utils.Commands;
import com.example.crm_project.utils.ConsoleColors;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Scanner;

import static com.example.crm_project.utils.ConsoleColors.printWithColor;
import static com.example.crm_project.utils.TypeWriter.typewriterFromString;

@Data
@Service
@NoArgsConstructor
public class CrmService {
    private final String HELP  = "help";
    private final String REPORT = "report";
    private final String NEW_LEAD = "new lead";
    private final String SHOW_LEADS = "show leads";
    private final String LOOKUP_LEAD = "lookup lead";
    private final String CONVERT = "convert";
    private final String CLOSE_LOST_OPPORTUNITY = "close-lost";
    private final String CLOSE_WON_OPPORTUNITY = "close-won";
    private final String NEW_SALESREP = "new salesrep";
    private final String EXIT = "exit";
    private final String BACK = "back";
    private final String YES = "yes";
    private final String NO = "no";
    @Autowired
    private InputService inputService;
    @Autowired
    private ReportIputService reportIputService;
    void executeReportCommand() {
    }

    public void executeCommand(String input){
        switch (input) {

            case HELP -> {
                typewriterFromString(Commands.InitialHelpMessage, 0);
            }
            case REPORT -> {
                executeReportCommand();
            }
            case NEW_LEAD-> {
//                TODO createNewLead();
                var i = 0;
            }
            case SHOW_LEADS -> {
//                TODO showLeads();
            }
            case LOOKUP_LEAD -> {
                var id = inputService.askLeadId();
//                TODO lookUpLead(id); should check if lead exists and, if so, should print the lead's information
            }
            case CONVERT -> {
                var id = inputService.askLeadId();
                var opportunityInfo = inputService.askOpportunityInfo();
                var accountInfo = inputService.askAccountInfo();
//                TODO convertLead(id, opportunityInfo, accountInfo); creates new contact + deletes lead + creates new opportunity + creates new account


            }
            case CLOSE_LOST_OPPORTUNITY -> {
                var id = inputService.askOpportunityId();
//                TODO closeLostOpportunity(id); edites opportunity status to enum CLOSED_LOST
            }
            case CLOSE_WON_OPPORTUNITY -> {
                var id = inputService.askOpportunityId();
//                TODO closeWonOpportunity(id); edites opportunity status to enum CLOSED_WON
            }
            case NEW_SALESREP -> {
//                TODO var salesRepInfo = askSalesRepInfo();
//                TODO createNewSalesRep();
            }
            default -> {
                printWithColor("Command not recognized!", ConsoleColors.RED);
            }
        }
    }

}
