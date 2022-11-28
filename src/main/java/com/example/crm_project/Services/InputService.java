package com.example.crm_project.Services;

// Aqui van todos los switches y los derivados de esos switches. (Andres)

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
        clearConsole("");

        var question = "Please enter the id of the opportunity you want to close";

        do {
            printWithColor(question, ConsoleColors.WHITE_BRIGHT);
            var id = prompt.nextLine();
            if (validate.isValidIntInput(id)) {
                return Integer.parseInt(id);
            }
            printWithColor("Please try a valid id (integer number)", ConsoleColors.RED);
        } while (true);
    }

    public String[] askAccountInfo() {
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
            if (validate.isValidIntInput(numOfEmployees)) {
                return new String[] {industry,country, city, numOfEmployees};
            }
            printWithColor("Please try a valid number (integer number)", ConsoleColors.RED);
        } while (true);
    }

    private String chooseIndustry() {
        return "";
    }

    public String[] askOpportunityInfo() {
        clearConsole("");
        var questionProduct = "Please enter the product associated to this new opportunity";
        var questionNumberOfTrucks = "Now enter the number of trucks associated to this new opportunity";

        printWithColor(questionProduct, ConsoleColors.WHITE_BRIGHT);
        var product = chooseProduct();

        do {
            printWithColor(questionNumberOfTrucks, ConsoleColors.WHITE_BRIGHT);
            var numOfTrucks = prompt.nextLine();
            if (validate.isValidIntInput(numOfTrucks)) {
                return new String[] {product,numOfTrucks};
            }
            printWithColor("Please try a valid number (integer number)", ConsoleColors.RED);
        } while (true);
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



    public int askLeadId(){
        clearConsole("");

        var question = "Please enter the id of the lead you want to recover";

        do {
            printWithColor(question, ConsoleColors.WHITE_BRIGHT);
            var id = prompt.nextLine();
            if (validate.isValidIntInput(id)) {
                return Integer.parseInt(id);
            }
            printWithColor("Please try a valid id (integer number)", ConsoleColors.RED);
        } while (true);
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
