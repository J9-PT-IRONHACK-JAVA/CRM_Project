package com.example.crm_project.utils;

import com.example.crm_project.Model.SalesRep;
import com.example.crm_project.Repository.SalesRepRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@Component
public class Validate {

    @Autowired
    private SalesRepRepository salesRepRepository;

    public static final Pattern VALID_PHONENUMBER_REGEX =
            Pattern.compile("\\A[0-9]{3}[0-9]{3}[0-9]{3}\\z", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^(.+)@(.+)$", Pattern.CASE_INSENSITIVE);


    public boolean isValidIntInput(String input) {
        return input.matches("^\\d+$");
    }

    public static boolean validatePhone(String phoneStr) {
        Matcher matcher = VALID_PHONENUMBER_REGEX.matcher(phoneStr);
        return matcher.find();
    }

    public static boolean validateEmailAddress(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }


    public boolean leadIdExists(String id) {
//        TODO method that checks if lead id exists in current database
        return true;
    }

    public boolean opportunityIdExists(String id) {
//        TODO method that checks if opportunity id exists in current database
        return true;
    }

    public boolean isValidUserName(String userName) {

//        if(!salesRepRepository.checkIfUsernameExists()){
//            return false;
//        }
        return true;
//        return salesRepRepository.existsByUsername(userName);
    }

    public boolean isValidPassword(String userName, String password) {
//        SalesRep user = salesRepRepository.findByUsername(userName);
//        if(!password.equals(user.getPassword())){
//            return false;
//        }
        return true;
    }

}
