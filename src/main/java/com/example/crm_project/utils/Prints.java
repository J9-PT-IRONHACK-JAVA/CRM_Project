package com.example.crm_project.utils;

import com.example.crm_project.Model.Lead;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Prints {

    public static void newLeadSuccessfullyCreated(Lead newLead) {
        System.out.printf("""
                *Lead specifications*
                Lead Id: %d%n
                Name: %s
                Phone number: %s
                Email: %s
                Company name: %s
                Sales Rep: %s
                
                New lead was successfully created!
             
                """,
                newLead.getId(),
                newLead.getName(),
                newLead.getPhoneNumber(),
                newLead.getEmail(),
                newLead.getCompanyName(),
                newLead.getSalesRep().getName());
    }


    public void showLeads(List<Lead> leadsList) {
        var count = 0;
        for(Lead lead: leadsList){
            System.out.printf("""
                Lead Id: %d%n
                Name: %s
                Phone number: %s
                Email: %s
                Company name: %s
                Sales Rep: %s
                =========================
             
                """,
                lead.getId(),
                lead.getName(),
                lead.getPhoneNumber(),
                lead.getEmail(),
                lead.getCompanyName(),
                lead.getSalesRep().getName());
            count++;
        }
        System.out.println("Lead total: " + count);
    }




    public void lookUpLead(Optional<Lead> lead) {
        System.out.printf("""
                *Lead specifications*
                Lead Id: %d%n
                Name: %s
                Phone number: %s
                Email: %s
                Company name: %s
                Sales Rep: %s
                """,
                lead.get().getId(),
                lead.get().getName(),
                lead.get().getPhoneNumber(),
                lead.get().getEmail(),
                lead.get().getCompanyName(),
                lead.get().getSalesRep().getName());
    }



    public static void exitApp() {
        System.out.println("""
                Ok, see you soon!

                """);
    }
}
