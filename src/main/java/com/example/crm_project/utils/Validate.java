package com.example.crm_project.utils;

import com.example.crm_project.Model.SalesRep;
import com.example.crm_project.Repository.LeadRepository;
import com.example.crm_project.Repository.OpportunityRepository;
import com.example.crm_project.Repository.SalesRepRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@Component
public class Validate {

    @Autowired
    private SalesRepRepository salesRepRepository;
    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private OpportunityRepository opportunityRepository;

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
        var lead = leadRepository.findById(Long.valueOf(id));
        if(lead.isPresent()){
            return true;
        }
        return false;
    }

    public boolean opportunityIdExists(String id) {
        var opportunity = opportunityRepository.findById(Long.valueOf(id));
        if(opportunity.isPresent()){
            return true;
        }
        return false;
    }

    public boolean isValidUserName(String userName) {
        return salesRepRepository.existsByUsername(userName);
    }

    public boolean isValidPassword(String userName, String password) {
        return salesRepRepository.existsByPassword(userName,  password);
    }

}
