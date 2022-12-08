package com.example.crm_project.utils;

import com.example.crm_project.Model.Lead;
import com.example.crm_project.Model.Opportunity;
import com.example.crm_project.Model.SalesRep;
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
                =======================             
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

    public void lookUpLead(Lead lead) {
        System.out.printf("""
                *Lead specifications*
                Lead Id: %d
                Name: %s
                Phone number: %s
                Email: %s
                Company name: %s
                Sales Rep: %s
                """,
                lead.getId(),
                lead.getName(),
                lead.getPhoneNumber(),
                lead.getEmail(),
                lead.getCompanyName(),
                lead.getSalesRep().getName());
    }


    public static void exitApp() {
        System.out.println("""
                Ok, see you soon!

                """);
    }

    public void printLogin() {
        System.out.println("""
                
                TruckyCRM Login
                """);
    }

    public void newSalesRepSuccessfullyCreated(SalesRep newSalesRep) {
        System.out.printf("""
                *SalesRep specifications*
                Name: %s
                Password: %s
                
                New SalesRep was successfully created!
                """, newSalesRep.getName(),
                newSalesRep.getPassword());
    }

    public void showSalesRep(List<SalesRep> salesRepList) {
        var count = 0;
        for(SalesRep salesRep: salesRepList){
            System.out.printf("""
                SalesRep Id: %s
                Name: %s
                ====================
                """,
                salesRep.getId(),
                salesRep.getName());
            count++;
        }
        System.out.println("Total: " + count);
    }

    public void oppotunitySuccessfullyClosed(Opportunity opportunity) {
        System.out.printf("""
                *Opportunity specifications*
                Opportunity Id: %s
                Product: %s
                Quantity: %d
                Decision maker: %s
                Account: %s
                SalesRep: %s
                Status: %s
                
                Opportunity was successfully closed!
             
                """,
                opportunity.getId(),
                opportunity.getProduct().name(),
                opportunity.getQuantity(),
                opportunity.getDecisionMaker().getName(),
                opportunity.getDecisionMaker().getCompanyName(),
                opportunity.getSalesRep().getName(),
                opportunity.getStatus().name());
    }
}
