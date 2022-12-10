package com.example.crm_project.Services;

import com.example.crm_project.Model.SalesRep;
import com.example.crm_project.Repository.SalesRepRepository;
import com.example.crm_project.utils.Commands;
import com.example.crm_project.utils.ConsoleColors;
import com.example.crm_project.utils.Prints;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

import static com.example.crm_project.utils.TypeWriter.typewriterFromString;

@Data
@Component
public class SalesRepService {

    @Autowired
    private SalesRepRepository salesRepRepository;
    @Autowired
    private Prints prints;

    public void createNewSalesRep(String[] salesRepInfo) {
        var newSalesRep = new SalesRep(salesRepInfo[0], salesRepInfo[1]);
        salesRepRepository.save(newSalesRep);
        prints.newSalesRepSuccessfullyCreated(newSalesRep);
    }

    public void showSalesRep() {
        var salesRepList = salesRepRepository.getAllSalesrep();
        prints.showSalesRep(salesRepList);
    }

    public void mainRep(String logedUser, Scanner sc){

        boolean back;
        String input;

        back = false;

        do {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Sales Rep report, enter a command...");
            input = sc.nextLine();
            back = salesRepSwitch(logedUser, input);
        }while(!back);
    }
    public boolean salesRepSwitch(String logedUser, String input) {

        boolean back = false;

        switch (input) {
            case "help":
                System.out.println(Commands.salesReportMessage);
                break;
            case "Report Lead by SalesRep":
                showLeadsBySaleRep(logedUser) ;
                break;
            case "Report Opportunity by SalesRep":
                showOppBySalesRep(logedUser);
                break;
            case "Report CLOSED-WON by SalesRep":
                showOppByClosedWonStatus(logedUser);
                break;
            case "Report CLOSED-LOST by SalesRep":
                showOppByClosedLostStatus(logedUser);
                break;
            case "Report OPEN by SalesRep":
                showOppByOpenStatus(logedUser);
                break;
            case "back":
                back = true;
                break;
            default:
                System.out.println("No correct parameter");
                break;
        }
        return back;
    }

    public void showLeadsBySaleRep(String logedUser){

        String string;
        List<Object[]> result = salesRepRepository.countLeadsBySaleRep(logedUser);
        var  logedSaleRep = result.get(0)[0];
        var leadsCount = result.get(0)[1];

        string = (logedUser == null )?"Not leads found":"Sales Rep " + logedSaleRep + " has " + leadsCount + " leads";
        System.out.println(string) ;

    }

    public void showOppBySalesRep(String logedUser){
        String string;
        var result = salesRepRepository.countOpportunitiesBySalesRep(logedUser);
        var  logedSaleRep = result.get(0)[0];
        var oppCount = result.get(0)[1];

        string = (logedUser == null )?"Not opportunities found":"Sales Rep " + logedSaleRep + " has " + oppCount + " opportunities";
        System.out.println(string) ;
    }

    public void showOppByClosedWonStatus(String logedUser){
        String string;
        var result = salesRepRepository.findCountByStatusClosedWon(logedUser);
        var logedSaleRep = result.get(0)[0];
        var oppClosedWon = result.get(0)[1];

        string = (logedSaleRep == null )?"Not CLOSED-WON opportunities found":"Sales Rep " + logedSaleRep + " has " + oppClosedWon + " CLOSED_WON opportunities";
        System.out.println(string) ;
    }

    public void showOppByClosedLostStatus(String logedUser){
        String string;
        var result = salesRepRepository.findCountByStatusClosedLost(logedUser);
        var logedSaleRep = result.get(0)[0];
        var oppClosedlost = result.get(0)[1];

        string = (logedSaleRep == null )?"Not CLOSED-LOST opportunities found":"Sales Rep " + logedSaleRep + " has " + oppClosedlost + " CLOSED_LOST opportunities";
        System.out.println(string) ;
    }

    public void showOppByOpenStatus(String logedUser){
        String string;
        var result = salesRepRepository.findCountByOpenStatus(logedUser);
        var logedSaleRep = result.get(0)[0];
        var open = result.get(0)[1];

        string = (logedSaleRep == null )?"Not OPEN opportunities found":"Sales Rep " + logedSaleRep + " has " + open + " OPEN opportunities";
        System.out.println(string) ;
    }
}
