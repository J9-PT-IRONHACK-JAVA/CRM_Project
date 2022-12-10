package com.example.crm_project.Services;

import com.example.crm_project.Enums.Status;

import com.example.crm_project.Repository.AccountRepository;
import com.example.crm_project.Model.Lead;
import com.example.crm_project.Model.Opportunity;
import com.example.crm_project.Repository.OpportunityRepository;
import com.example.crm_project.utils.Commands;
import com.example.crm_project.utils.ConsoleColors;
import com.example.crm_project.utils.Prints;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Scanner;
import java.util.List;


@Data
@Component
public class OpportunityService {
    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private Prints prints;
    public void closeOpportunity(long id, Status lostORwon) {
        var opportunityToEdit = opportunityRepository.findById(id);
        opportunityToEdit.get().setStatus(lostORwon);
        opportunityRepository.save(opportunityToEdit.get());
        prints. oppotunitySuccessfullyClosed(opportunityToEdit.get());
    }

    public void showOpportunities() {
//        var count = 0;
//        var oppList = opportunityRepository.findAll();
//        for(Opportunity opportunity: oppList){
//            System.out.printf("""
//                *Lead specifications*
//                Lead Id: %s
//                Name: %s
//                Phone number: %s
//                Email: %s
//                Company name: %s
//                Sales Rep: %s
//                =======================
//                """, lead.getId(),
//                    lead.getName(),
//                    lead.getPhoneNumber(),
//                    lead.getEmail(),
//                    lead.getCompanyName(),
//                    lead.getSalesRep().getName());
//            count++;
//        }
//        System.out.println("Total: " + count);
    }

    public void mainOpp(String logedUser, Scanner sc){

        boolean back;
        String input;

        back = false;

        do {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Report by product, enter a command...");
            input = sc.nextLine();
            back = OppByProductSwitch(logedUser, input);
        }while(!back);
    }

    public boolean OppByProductSwitch(String logedUser, String input) {

        boolean back = false;

        switch (input) {
            case "help":
                System.out.println(Commands.OppByProductReportMessage);
                break;
            case "Report Opportunity by the product":
                showCountOfOpportunitiesByProduct() ;
                break;
            case "Report CLOSED-WON by the product":
                showCountClosedWonOppByProduct();
                break;
            case "Report CLOSED-LOST by the product":
                showCountClosedLostOppByProduct();
                break;
            case "Report OPEN by the product":
                showCountOpenOppByProduct();
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

    public void mainOppByCountry(Scanner sc){

        boolean back;
        String input;

        back = false;

        do {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Report opportunnity by country , enter a command...");
            input = sc.nextLine();
            back = OppByCountrySwitch(input);
        }while(!back);
    }

    public boolean OppByCountrySwitch(String input) {

        boolean back = false;

        switch (input) {
            case "help":
                System.out.println(Commands.OppByCountryReportMessage);
                break;
            case "Report Opportunity by Country":
                showCountOfOpportunitiesByCountry() ;
                break;
            case "Report CLOSED-WON by Country":
                showCountClosedWonOppByCountry();
                break;
            case "Report CLOSED-LOST by Country":
                showCountClosedLostOppByCountry();
                break;
            case "Report OPEN by the Country":
                showCountOpenOppByCountry();
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

    public void mainCountEmploye(Scanner sc){

        boolean back;
        String input;

        back = false;

        do {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "EmployeeCount States, enter a command...");
            input = sc.nextLine();
            back = employeeCountSwitch(input);
        }while(!back);
    }

    public boolean employeeCountSwitch(String input) {

        boolean back = false;

        switch (input) {
            case "help":
                System.out.println(Commands.employeeCountReportMessage);
                break;
            case "Median EmployeeCount":
                showMedianEmployeeCount() ;
                break;
            case "Max EmployeeCount":
                showMaxEmployeeCount();
                break;
            case "Min EmployeeCount":
                showMinEmployeeCount();
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

    void showMedianEmployeeCount(){
        Long employee = accountRepository.medianEmployeeCount();
        System.out.println("Average of employees " + employee);
    }

    void showMaxEmployeeCount(){
        Long employee = accountRepository.maxEmployeeCount();
        System.out.println("Max of employees " + employee);
    }
    void showMinEmployeeCount(){
        Long employee = accountRepository.minEmployeeCount();
        System.out.println("Min of employees " + employee);
    }

    public void mainCountProduct(Scanner sc){

        boolean back;
        String input;

        back = false;

        do {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "ProductCount States, enter a command...");
            input = sc.nextLine();
            back = productCountSwitch(input);
        }while(!back);
    }

    public boolean productCountSwitch(String input) {

        boolean back = false;

        switch (input) {
            case "help":
                System.out.println(Commands.productCountReportMessage);
                break;
            case "Media Quantity":
                showMedianProducts() ;
                break;
            case "Max Quantity":
                showMaxProducts();
                break;
            case "Min Quantity":
                showMinProducts();
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

    void showMedianProducts(){
        Long product = accountRepository.medianEmployeeCount();
        System.out.println("Average of products " + product);
    }

    void showMaxProducts(){
        var result = opportunityRepository.countMaxOfProducts();
        var product = result.get(0)[0];
        var quantityPro = result.get(0)[1];
        System.out.println(product + " max = " + quantityPro);
    }
    void showMinProducts(){
        var result = opportunityRepository.countMinOfProducts();
        var product = result.get(0)[0];
        var quantityPro = result.get(0)[1];
        System.out.println(product + " min = " + quantityPro);
    }

    void showCountOfOpportunitiesByProduct(){

        String string;

        var result = opportunityRepository.countOfOpportunitiesByProduct();

        var product = result.get(0)[0];
        var quantityPro = result.get(0)[1];

        var product2 = result.get(1)[0];
        var quantityPro2 = result.get(1)[1];

        var product3 = result.get(2)[0];
        var quantityPro3 = result.get(2)[1];

        string = product + "\t" + quantityPro + "\n"
                + product2 + "\t" + quantityPro2 + "\n"
                + product3 + "\t" + quantityPro3 + "\n"
        ;

        System.out.println(string);
    }

    void showCountClosedWonOppByProduct(){

        String string;

        var result = opportunityRepository.countClosedWonOppByProduct();

        var quantity = result.get(0)[0];
        var  product= result.get(0)[1];

        string = product + "\t" + " CLOSED-WON " + quantity + "\n"

        ;
        System.out.println(string);

    }

    void showCountClosedLostOppByProduct(){

        String string;

        var result = opportunityRepository.countClosedLostOppByProduct();

        var quantity = result.get(0)[0];
        var  product= result.get(0)[1];

        string = product + "\t" + " CLOSED-LOST " + quantity + "\n"

        ;
        System.out.println(string);

    }

    void showCountOpenOppByProduct(){

        String string;

        var result = opportunityRepository.countOpenOppByProduct();

        var quantity = result.get(0)[0];
        var  product= result.get(0)[1];

        string = product + "\t" + " OPEN " + quantity + "\n"

        ;
        System.out.println(string);

    }
    ////////////  COUNTRY ////////////////////////////////
    void showCountOfOpportunitiesByCountry(){

        String string;

        var result = opportunityRepository.countOppByCountry();

        var country = result.get(0)[0];
        var quantityPro = result.get(0)[1];

        var country2 = result.get(1)[0];
        var quantityPro2 = result.get(1)[1];

        var country3 = result.get(2)[0];
        var quantityPro3 = result.get(2)[1];

        string = country + "\t" + quantityPro + "\n"
                + country2 + "\t" + quantityPro2 + "\n"
                + country3 + "\t" + quantityPro3 + "\n"
        ;

        System.out.println(string);
    }

    void showCountClosedWonOppByCountry(){

        String string;

        var result = opportunityRepository.countClosedWonOppByCountry();

        var quantity = result.get(0)[0];
        var  product= result.get(0)[1];

        string = product + "\t" + " CLOSED-WON " + quantity + "\n"

        ;
        System.out.println(string);

    }

    void showCountClosedLostOppByCountry(){

        String string;

        var result = opportunityRepository.countClosedLostOppByCountry();

        var quantity = result.get(0)[0];
        var  product= result.get(0)[1];

        string = product + "\t" + " CLOSED-LOST " + quantity + "\n"

        ;
        System.out.println(string);

    }

    void showCountOpenOppByCountry(){

        String string;

        var result = opportunityRepository.countOpenOppByCountry();

        var quantity = result.get(0)[0];
        var  product= result.get(0)[1];

        string = product + "\t" + " OPEN " + quantity + "\n"

        ;
        System.out.println(string);

    }

}
