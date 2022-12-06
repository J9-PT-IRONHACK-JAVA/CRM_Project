package com.example.crm_project.utils;

import com.example.crm_project.Model.Lead;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Prints {

    public static void newLeadSuccessfullyCreated(Lead newLead) {
        System.out.printf("""
                *Lead specifications*
                Name: %s
                Phone number: %s
                Email: %s
                Company name: %s
                Sales Rep: %s
                
                New lead was successfully created!
             
                """, newLead.getName(),
                newLead.getPhoneNumber(),
                newLead.getEmail(),
                newLead.getCompanyName(),
                newLead.getSalesRep().getName());
    }


    public void showLeads(List<Lead> leadsList) {
        var count = 0;
        for(Lead lead: leadsList){
            System.out.printf("""
                *Lead specifications*
                Lead Id: %s
                Name: %s
                Phone number: %s
                Email: %s
                Company name: %s
                Sales Rep: %s
                
                New lead was successfully created!
             
                """, lead.getId(),
                    lead.getName(),
                    lead.getPhoneNumber(),
                    lead.getEmail(),
                    lead.getCompanyName(),
                    lead.getSalesRep().getName());
            count++;
        }
        System.out.println("Total: " + count);
    }


    public static void exitApp() {
        System.out.println("""
                Ok, see you soon!

                """);
    }

}
