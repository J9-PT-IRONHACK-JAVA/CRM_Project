package com.example.crm_project.Services;

import com.example.crm_project.Model.SalesRep;
import com.example.crm_project.Repository.SalesRepRepository;
import com.example.crm_project.utils.ConsoleColors;
import com.example.crm_project.utils.Validate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.crm_project.utils.ConsoleColors.printWithColor;
@Component
@Data
@NoArgsConstructor
public class LoginService {
    private SalesRep currentSalesRep;
    private boolean isValidUserName = false;
    private boolean isValidPassword = false;

    @Autowired
    private InputService inputService;
    @Autowired
    private Validate validate;

    @Autowired
    private SalesRepRepository salesRepRepository;


    public void login(){
        String userName;
        String password;
        do {
            userName = inputService.askUserName();
            isValidUserName = validate.isValidUserName(userName);
            if (isValidUserName == false){
                printWithColor("Username does not exist. Please try again", ConsoleColors.RED);
            }
        }while (isValidUserName == false);

        do {
            password = inputService.askPassword();
            isValidPassword = validate.isValidPassword(userName, password);
            if (isValidPassword == false){
                printWithColor("Password does not match with username. Please try again", ConsoleColors.RED);
            }
        }while (isValidPassword == false);

        var loggedSalesRep = salesRepRepository.findSalesRepByNameAndPassword();
        this.setCurrentSalesRep(loggedSalesRep);
        System.out.println("Login successful");
    }



}
