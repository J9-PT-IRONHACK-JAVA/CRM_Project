package com.example.crm_project.Services;

// Aqui van todos los switches y los derivados de esos switches. (Andres)

import com.example.crm_project.Enums.Industry;
import com.example.crm_project.Enums.Product;
import com.example.crm_project.utils.ConsoleColors;
import com.example.crm_project.utils.Validate;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

import static com.example.crm_project.utils.ConsoleColors.printWithColor;
import static com.example.crm_project.utils.Prints.exitApp;

@Data
@Component
public class InputService {

    private final Scanner prompt;



    @Autowired
    private Validate validate;

    public InputService() {
        this.prompt = new Scanner(System.in);
    }




    private void askSalesRepInfo() {
    }

    public int askOpportunityId() {

        var questionOpportunityId = "Please enter the id of the opportunity you want to close";

        do {
            printWithColor(questionOpportunityId, ConsoleColors.WHITE_BRIGHT);
            var id = prompt.nextLine();
            if (validate.isValidIntInput(id)) {
                return Integer.parseInt(id);
            }
            printWithColor("Please try a valid id (integer number)", ConsoleColors.RED);
        } while (true);
    }

    public String[] askAccountInfo() {
        var questionIndustry = "Please select the industry associated to the contact's organization:\n" +
                "1) PRODUCE\n" +
                "2) ECOMMERCE\n" +
                "3) MANUFACTURING\n" +
                "4) MEDICAL\n" +
                "5) OTHER";
        var questionCountry = "Now enter the country associated to this new opportunity";
        var questionCity = "Now enter the city associated to this new opportunity";
        var questionNumberOfEmployees = "Please enter the number of employees associated to the contact's organization";

        var industry = chooseIndustry(questionIndustry);
        printWithColor(questionCountry, ConsoleColors.WHITE_BRIGHT);
        var country = prompt.nextLine();
        printWithColor(questionCity, ConsoleColors.WHITE_BRIGHT);
        var city = prompt.nextLine();

        String numOfEmployees;
        do {
            printWithColor(questionNumberOfEmployees, ConsoleColors.WHITE_BRIGHT);
            numOfEmployees = prompt.nextLine();
            if (validate.isValidIntInput(numOfEmployees)) {
                return new String[]{industry, country, city, numOfEmployees};
            }
            printWithColor("Please try a valid number (integer number)", ConsoleColors.RED);
        } while (true);
    }


    private String chooseIndustry(String questionIndustry) {
        String input;
        do {
            printWithColor(questionIndustry, ConsoleColors.WHITE_BRIGHT);
            input = prompt.nextLine();
            switch (input){
                case "1" -> {
                    input = "produce";
                    return input;
                }
                case "2" -> {
                    input = "ecommerce";
                    return input;
                }
                case "3" -> {
                    input = "manufacturing";
                    return input;
                }
                case "4" -> {
                    input = "medical";
                    return input;
                }
                case "5" -> {
                    input = "other";
                    return input;
                }
                default -> printWithColor("Please try a valid option (1, 2, 3, 4 or 5)", ConsoleColors.RED);
            }
        }while (true);
    }

    public String[] askOpportunityInfo() {
        var questionProduct = "Please select the product associated to this new opportunity:\n" +
                "1) HYBRID\n" +
                "2) FLATBED\n" +
                "3) BOX";
        var questionNumberOfTrucks = "Now enter the number of trucks associated to this new opportunity";
        boolean isValidNumberOfTrucks;

        String product = chooseProduct(questionProduct);

        String numOfTrucks;
        do {
            printWithColor(questionNumberOfTrucks, ConsoleColors.WHITE_BRIGHT);
            numOfTrucks = prompt.nextLine();
            isValidNumberOfTrucks = validate.isValidIntInput(numOfTrucks);
            if (isValidNumberOfTrucks == false) {
                printWithColor("Please try a valid number (integer number)", ConsoleColors.RED);
            }
        } while (isValidNumberOfTrucks == false);

        return new String[]{product, numOfTrucks};
    }

    private String chooseProduct(String questionProduct) {
        String input;
        do {
            printWithColor(questionProduct, ConsoleColors.WHITE_BRIGHT);
            input = prompt.nextLine();
            switch (input){
                case "1" -> {
                    input = "hybrid";
                    return input;
                }
                case "2" -> {
                    input = "flatbed";
                    return input;
                }
                case "3" -> {
                    input = "box";
                    return input;
                }
                default -> printWithColor("Please try a valid option (1, 2 or 3)", ConsoleColors.RED);
            }
        }while (true);
    }



    public int askLeadId(){
        var question = "Please enter the id of the lead you want to recover";

        do {
            printWithColor(question, ConsoleColors.WHITE_BRIGHT);
            var id = prompt.nextLine();
            if (validate.isValidIntInput(id) && validate.leadIdExists(id)) {
                return Integer.parseInt(id);
            }
            printWithColor("Please try a valid id (integer number)", ConsoleColors.RED);
        } while (true);
    }

    public String[] askNewLeadInfo() {
        var questionNewLeadName = "Please enter the new lead's name";
        var questionNewLeadPhoneNumber = "Please enter the new lead's phone number";
        var questionNewLeadEmail = "Please enter the new lead's email";
        var questionNewLeadCompanyName = "Please enter the new lead's company name";
        boolean isPhoneNumberValid;
        boolean isEmailValid;

        printWithColor(questionNewLeadName, ConsoleColors.WHITE_BRIGHT);
        var newLeadName = prompt.nextLine();

        String newLeadPhoneNumber;
        do {
            printWithColor(questionNewLeadPhoneNumber, ConsoleColors.WHITE_BRIGHT);
            newLeadPhoneNumber = prompt.nextLine();
            isPhoneNumberValid = Validate.validatePhone(newLeadPhoneNumber);
            if (isPhoneNumberValid == false) {
                printWithColor("Invalid phone number, try again.", ConsoleColors.RED);
            }
        } while (isPhoneNumberValid == false);

        String newLeadEmail;
        do {
            printWithColor(questionNewLeadEmail, ConsoleColors.WHITE_BRIGHT);
            newLeadEmail = prompt.nextLine();
            isEmailValid = Validate.validateEmailAddress(newLeadEmail);
            if (isPhoneNumberValid == false) {
                printWithColor("Invalid email address, try again.", ConsoleColors.RED);
            }
        } while (isPhoneNumberValid == false);

        printWithColor(questionNewLeadCompanyName, ConsoleColors.WHITE_BRIGHT);
        var newLeadCompanyName = prompt.nextLine();

        return new String[]{newLeadName, newLeadPhoneNumber, newLeadEmail, newLeadCompanyName};
    }
}
