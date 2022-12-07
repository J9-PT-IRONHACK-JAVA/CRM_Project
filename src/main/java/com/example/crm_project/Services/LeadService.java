package com.example.crm_project.Services;

import com.example.crm_project.Enums.Industry;
import com.example.crm_project.Enums.Product;
import com.example.crm_project.Model.Account;
import com.example.crm_project.Model.Contact;
import com.example.crm_project.Model.Lead;
import com.example.crm_project.Model.Opportunity;
import com.example.crm_project.Repository.AccountRepository;
import com.example.crm_project.Repository.ContactRepository;
import com.example.crm_project.Repository.LeadRepository;
import com.example.crm_project.Repository.OpportunityRepository;
import com.example.crm_project.utils.Prints;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Data
@Component
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private Prints prints;
    @Autowired
    private LoginService loginService;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OpportunityRepository opportunityRepository;

    public void createNewLead(String[] newLeadInfo) {
        var newLead = new Lead(newLeadInfo[0],newLeadInfo[1],newLeadInfo[2],newLeadInfo[3], loginService.getCurrentSalesRep());
        leadRepository.save(newLead);
        prints.newLeadSuccessfullyCreated(newLead);
    }

    public void showLeads() {
        var leadsList = leadRepository.findAll();
        prints.showLeads(leadsList);
    }

    public void lookUpLead(long id) {
        var lead = leadRepository.findById(id);
        prints.lookUpLead(lead);
    }

    public void convertLead(Optional<Lead> leadToConvert, String[] opportunityInfo, String[] accountInfo) {

        var newContact = new Contact(
                leadToConvert.get().getName(),
                leadToConvert.get().getPhoneNumber(),
                leadToConvert.get().getEmail(),
                leadToConvert.get().getCompanyName());

//        accountInfo = {industry, country, city, numOfEmployees}
        var newAccount = new Account(
                leadToConvert.get().getCompanyName(),
                turnStringToIndustry(accountInfo[0]),
                Integer.parseInt(accountInfo[3]),
                accountInfo[2],
                accountInfo[1]);

        var newOpportunity = new Opportunity(
                turnStringToProduct(opportunityInfo[0]),
                Integer.parseInt(opportunityInfo[1]),
                newContact,
                newAccount,
                leadToConvert.get().getSalesRep());

        contactRepository.save(newContact);
        accountRepository.save(newAccount);
        opportunityRepository.save(newOpportunity);
        leadRepository.delete(leadToConvert.get());
    }

    public void convertLead(Optional<Lead> leadToConvert, String[] opportunityInfo, Account existingAccount) {

        var newContact = new Contact(
                leadToConvert.get().getName(),
                leadToConvert.get().getPhoneNumber(),
                leadToConvert.get().getEmail(),
                leadToConvert.get().getCompanyName());

        var newOpportunity = new Opportunity(
                turnStringToProduct(opportunityInfo[0]),
                Integer.parseInt(opportunityInfo[1]),
                newContact,
                existingAccount,
                leadToConvert.get().getSalesRep());

        existingAccount.addContact(newContact);
        existingAccount.addOpportunity(newOpportunity);

        contactRepository.save(newContact);
        accountRepository.save(existingAccount);
        opportunityRepository.save(newOpportunity);
        leadRepository.delete(leadToConvert.get());
    }

    public Product turnStringToProduct(String product){

        switch (product){
            case "1":{
                return Product.HYBRID;
            }
            case "2":{
                return Product.FLATBED;
            }
            case "3":{
                return Product.BOX;
            }
        }
        return null;
    }

    public Industry turnStringToIndustry(String industry){

        switch (industry) {
            case "1" -> {
                return Industry.PRODUCE;
            }
            case "2" -> {
                return Industry.ECOMMERCE;
            }
            case "3" -> {
                return Industry.MANUFACTURING;
            }
            case "4" -> {
                return Industry.MEDICAL;
            }
            case "5" -> {
                return Industry.OTHER;
            }
        }
        return null;
    }
}
