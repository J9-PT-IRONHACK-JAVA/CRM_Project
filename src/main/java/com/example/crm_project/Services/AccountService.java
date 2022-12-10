package com.example.crm_project.Services;

import com.example.crm_project.Repository.AccountRepository;
import com.example.crm_project.utils.Commands;
import com.example.crm_project.utils.ConsoleColors;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Data
@NoArgsConstructor
@Component
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public void mainOppByCity(Scanner sc){

        boolean back;
        String input;

        back = false;

        do {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Report by city, enter a command...");
            input = sc.nextLine();
            back = OppByCitySwitch(input);
        }while(!back);
    }

    public boolean OppByCitySwitch(String input) {

        boolean back = false;

        switch (input) {
            case "help":
                System.out.println(Commands.OppByCityReportMessage);
                break;
            case "Report Opportunity by City":
                showCountOfOpportunitiesByCity() ;
                break;
            case "Report CLOSED-WON by City":
                showCountClosedWonOppByCity();
                break;
            case "Report CLOSED-LOST by City":
                showCountClosedLostOppByCity();
                break;
            case "Report OPEN by City":
                showCountOpenOppByCity();
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

    ///////////////////////////////////////////////////////////
    void showCountOfOpportunitiesByCity(){

        String string;

        var result = accountRepository.countOpportunitiesByCity();

        var city = result.get(0)[0];
        var quantityPro = result.get(0)[1];

        var city2 = result.get(1)[0];
        var quantityPro2 = result.get(1)[1];

        var city3 = result.get(2)[0];
        var quantityPro3 = result.get(2)[1];

        string = city + "\t" + quantityPro + "\n"
                + city2 + "\t" + quantityPro2 + "\n"
                + city3 + "\t" + quantityPro3 + "\n"
        ;

        System.out.println(string);
    }

    void showCountClosedWonOppByCity(){

        String string;

        var result = accountRepository.countClosedWonOpportunitiesByCity();

        var quantity = result.get(0)[0];
        var  product= result.get(0)[1];

        string = product + "\t" + " CLOSED-WON " + quantity + "\n"

        ;
        System.out.println(string);

    }

    void showCountClosedLostOppByCity(){

        String string;

        var result = accountRepository.countClosedLostOpportunitiesByCity();

        var quantity = result.get(0)[0];
        var  product= result.get(0)[1];

        string = product + "\t" + " CLOSED-LOST " + quantity + "\n"

        ;
        System.out.println(string);

    }

    void showCountOpenOppByCity(){

        String string;

        var result = accountRepository.countOpenOpportunitiesByCity();

        var quantity = result.get(0)[0];
        var  product= result.get(0)[1];

        string = product + "\t" + " OPEN " + quantity + "\n"

        ;
        System.out.println(string);

    }

    public void mainOppByIndustry(Scanner sc){

        boolean back;
        String input;

        back = false;

        do {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Report opportunity by industry, enter a command...");
            input = sc.nextLine();
            back = OppByindustrySwitch(input);
        }while(!back);
    }

    public boolean OppByindustrySwitch(String input) {

        boolean back = false;

        switch (input) {
            case "help":
                System.out.println(Commands.OppByIndustryReportMessage);
                break;
            case "Report Opportunity by Industry":
                showCountOfOpportunitiesByIndustry() ;
                break;
            case "Report CLOSED-WON by Industry":
                showCountClosedWonOppByIndustry();
                break;
            case "Report CLOSED-LOST by Industry":
                showCountClosedLostOppByIndustry();
                break;
            case "Report OPEN by Industry":
                showCountOpenOppByIndustry();
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

    void showCountOfOpportunitiesByIndustry(){

        String string;

        var result = accountRepository.countOpportunitiesByIndustry();

        var city = result.get(0)[0];
        var quantityPro = result.get(0)[1];

        var city2 = result.get(1)[0];
        var quantityPro2 = result.get(1)[1];

        var city3 = result.get(2)[0];
        var quantityPro3 = result.get(2)[1];

        string = city + "\t" + quantityPro + "\n"
                + city2 + "\t" + quantityPro2 + "\n"
                + city3 + "\t" + quantityPro3 + "\n"
        ;

        System.out.println(string);
    }

    void showCountClosedWonOppByIndustry(){

        String string;

        var result = accountRepository.countClosedWonOpportunitiesByIndustry();

        var quantity = result.get(0)[0];
        var  product= result.get(0)[1];

        string = product + "\t" + " CLOSED-WON " + quantity + "\n"

        ;
        System.out.println(string);

    }

    void showCountClosedLostOppByIndustry(){

        String string;

        var result = accountRepository.countClosedLostOpportunitiesByIndustry();

        var quantity = result.get(0)[0];
        var  product= result.get(0)[1];

        string = product + "\t" + " CLOSED-LOST " + quantity + "\n"

        ;
        System.out.println(string);

    }

    void showCountOpenOppByIndustry(){

        String string;

        var result = accountRepository.countOpenOpportunitiesByIndustry();

        var quantity = result.get(0)[0];
        var  product= result.get(0)[1];

        string = product + "\t" + " OPEN " + quantity + "\n"

        ;
        System.out.println(string);

    }
}
