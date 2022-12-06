package com.example.crm_project.Services;

import com.example.crm_project.Model.Lead;
import com.example.crm_project.Repository.LeadRepository;
import com.example.crm_project.utils.Prints;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Data
@Component
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private Prints prints;

    @Autowired
    private LoginService loginService;

    public void createNewLead(String[] newLeadInfo) {
        var newLead = new Lead(newLeadInfo[0],newLeadInfo[1],newLeadInfo[2],newLeadInfo[3], loginService.getCurrentSalesRep());
        leadRepository.save(newLead);
        prints.newLeadSuccessfullyCreated(newLead);
    }

    public void showLeads() {
        var leadsList = leadRepository.findAll();
        prints.showLeads(leadsList);
    }

    public void lookUpLead(int id) {
    }

    public void convertLead(int id, String[] opportunityInfo, String[] accountInfo) {
//        TODO
//        buscar
//        eliminar
//        update
    }

}
