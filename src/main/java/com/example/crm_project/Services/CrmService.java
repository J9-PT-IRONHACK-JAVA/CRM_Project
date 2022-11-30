package com.example.crm_project.Services;

import com.example.crm_project.Enums.Status;
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
    private final String SHOW_SALESREP = "show salesrep";
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
    private ReportInputService reportInputService;
    @Autowired
    private LeadService leadService;
    @Autowired
    private SalesRepService salesRepService;
    @Autowired
    private OpportunityService opportunityService;


    void executeReportCommand() {
    }

    public void executeCommand(String input){

        switch (input) {

            case HELP -> {
                typewriterFromString(Commands.InitialHelpMessage, 0);
            }
            case REPORT -> {
                executeReportCommand();
                reportInputService.mainRepo();
            }
            case NEW_LEAD-> {
                var newLeadInfo = inputService.askNewLeadInfo();
                leadService.createNewLead(newLeadInfo);
            }
            case SHOW_LEADS -> {
                leadService.showLeads();
            }
            case SHOW_SALESREP -> {
                salesRepService.showSalesRep();
            }
            case LOOKUP_LEAD -> {
                var id = inputService.askLeadId("lookup");
                leadService.lookUpLead(id); // should check if lead exists and, if so, should print the lead's information
            }
            case CONVERT -> {
                var id = inputService.askLeadId("convert");
                var opportunityInfo = inputService.askOpportunityInfo();
                var accountInfo = inputService.askAccountInfo();
                leadService.convertLead(id, opportunityInfo, accountInfo); //creates new contact + deletes lead + creates new opportunity + creates new account
            }
            case CLOSE_LOST_OPPORTUNITY -> {
                var id = inputService.askOpportunityId();
                opportunityService.closeOpportunity(id, Status.CLOSED_LOST); //edites opportunity status to enum CLOSED_LOST
            }
            case CLOSE_WON_OPPORTUNITY -> {
                var id = inputService.askOpportunityId();
                opportunityService.closeOpportunity(id, Status.CLOSED_WON); //edites opportunity status to enum CLOSED_WON
            }
            case NEW_SALESREP -> {
                var salesRepInfo = inputService.askSalesRepInfo();
                salesRepService.createNewSalesRep();
            }
            default -> {
                printWithColor("Command not recognized! Enter 'help' to see available commands.", ConsoleColors.RED);
            }
        }
    }
}
