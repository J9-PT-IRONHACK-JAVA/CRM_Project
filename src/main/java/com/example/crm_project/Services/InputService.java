package com.example.crm_project.Services;

// Aqui van todos los switches y los derivados de esos switches. (Andres)

import com.example.crm_project.Enums.Product;
import com.example.crm_project.utils.ConsoleColors;

import java.io.IOException;
import java.util.Scanner;

import static com.example.crm_project.utils.ConsoleColors.printWithColor;
import static com.example.crm_project.utils.Prints.exitApp;

public class InputService {

    public static final String REPORT = "report";
    public static final String NEW_LEAD = "new lead";
    public static final String SHOW_LEADS = "show leads";
    public static final String LOOKUP_LEAD = "lookup lead";
    public static final String CONVERT = "convert";
    public static final String CLOSE_LOST_OPPORTUNITY = "close-lost";
    public static final String CLOSE_WON_OPPORTUNITY = "close-won";
    public static final String NEW_SALESREP = "new salesrep";


    public static final String EXIT = "exit";
    public static final String BACK = "back";
    public static final String YES = "yes";
    public static final String NO = "no";

    private static final String BACK_STRING = """
            ====================            
            BACK - go back
            ====================""";
    private final Scanner prompt;

    public InputService() {
        this.prompt = new Scanner(System.in);
    }

    public void executeCommand(String input){

        switch (input) {
            case REPORT -> {
                executeReportCommand();
            }
            case NEW_LEAD -> {
//                TODO createNewLead();
                var i = 0;
            }
            case SHOW_LEADS -> {
//                TODO showLeads();
            }
            case LOOKUP_LEAD -> {
                var id = askLeadId();
//                TODO lookUpLead(id); should check if lead exists and, if so, should print the lead's information
            }
            case CONVERT -> {
                var id = askLeadId();
                var opportunityInfo = askOpportunityInfo();
                var accountInfo = askAccountInfo();
//                TODO convertLead(id, opportunityInfo, accountInfo); creates new contact + deletes lead + creates new opportunity + creates new account


            }
            case CLOSE_LOST_OPPORTUNITY -> {
                var id = askOpportunityId();
//                TODO closeLostOpportunity(id); edites opportunity status to enum CLOSED_LOST
            }
            case CLOSE_WON_OPPORTUNITY -> {
                var id = askOpportunityId();
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

    private void askSalesRepInfo() {
    }

    private int askOpportunityId() {
        clearConsole("");

        var question = "Please enter the id of the opportunity you want to close";

        do {
            printWithColor(question, ConsoleColors.WHITE_BRIGHT);
            var id = prompt.nextLine();
            if (isValidId(id)) {
                return Integer.parseInt(id);
            }
            printWithColor("Please try a valid id (integer number)", ConsoleColors.RED);
        } while (true);
    }

    private String[] askAccountInfo() {
        clearConsole("");
        var questionIndustry = "Please enter the industry associated to the contact's organization";
        var questionCountry = "Now enter the country associated to this new opportunity";
        var questionCity = "Now enter the city associated to this new opportunity";
        var questionNumberOfEmployees = "Please enter the number of employees associated to the contact's organization";

        printWithColor(questionIndustry, ConsoleColors.WHITE_BRIGHT);
        var industry = chooseIndustry();
        printWithColor(questionCountry, ConsoleColors.WHITE_BRIGHT);
        var country = prompt.nextLine();
        printWithColor(questionCity, ConsoleColors.WHITE_BRIGHT);
        var city = prompt.nextLine();

        do {
            printWithColor(questionNumberOfEmployees, ConsoleColors.WHITE_BRIGHT);
            var numOfEmployees = prompt.nextLine();
            if (isValidNumOfEmployees(numOfEmployees)) {
                return new String[] {industry,country, city, numOfEmployees};
            }
            printWithColor("Please try a valid number (integer number)", ConsoleColors.RED);
        } while (true);
    }

    private boolean isValidNumOfEmployees(String numOfEmployees) {
        return numOfEmployees.matches("^\\d+$");
    }

    private String chooseIndustry() {
        return "";
    }

    private String[] askOpportunityInfo() {
        clearConsole("");
        var questionProduct = "Please enter the product associated to this new opportunity";
        var questionNumberOfTrucks = "Now enter the number of trucks associated to this new opportunity";

        printWithColor(questionProduct, ConsoleColors.WHITE_BRIGHT);
        var product = chooseProduct();

        do {
            printWithColor(questionNumberOfTrucks, ConsoleColors.WHITE_BRIGHT);
            var numOfTrucks = prompt.nextLine();
            if (isValidNumOfTrucks(numOfTrucks)) {
                return new String[] {product,numOfTrucks};
            }
            printWithColor("Please try a valid number (integer number)", ConsoleColors.RED);
        } while (true);
    }

    private boolean isValidNumOfTrucks(String numOfTrucks) {
        return numOfTrucks.matches("^\\d+$");
    }

    private String chooseProduct() {
        //    TODO method that displays a menu with the different product options
//        var product = prompt.nextLine();
//
//        switch (product){
//            case Product.HYBRID, Product.FLATBED -> {
//                return product;
//            }
//        }
        return "";
    }

    private void executeReportCommand() {
    }

    private int askLeadId(){
        clearConsole("");

        var question = "Please enter the id of the lead you want to recover";

        do {
            printWithColor(question, ConsoleColors.WHITE_BRIGHT);
            var id = prompt.nextLine();
            if (isValidId(id)) {
                return Integer.parseInt(id);
            }
            printWithColor("Please try a valid id (integer number)", ConsoleColors.RED);
        } while (true);
    }

    private boolean isValidId(String id) {
        return id.matches("^\\d+$");
    }

    public static void clearConsole(String header) {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {exitApp();}

        System.out.println(header);
    }

}
