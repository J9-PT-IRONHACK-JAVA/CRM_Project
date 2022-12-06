package com.example.crm_project.Services;

import com.example.crm_project.Model.Lead;
import com.example.crm_project.Repository.LeadRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public void createNewLead(String[] newLeadInfo) {

    }

    public void showLeads() {
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
