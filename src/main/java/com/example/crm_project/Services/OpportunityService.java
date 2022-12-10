package com.example.crm_project.Services;

import com.example.crm_project.Enums.Status;
import com.example.crm_project.Model.Lead;
import com.example.crm_project.Model.Opportunity;
import com.example.crm_project.Repository.OpportunityRepository;
import com.example.crm_project.utils.Prints;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class OpportunityService {
    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private Prints prints;
    public void closeOpportunity(long id, Status lostORwon) {
        var opportunityToEdit = opportunityRepository.findById(id);
        opportunityToEdit.get().setStatus(lostORwon);
        opportunityRepository.save(opportunityToEdit.get());
        prints. oppotunitySuccessfullyClosed(opportunityToEdit.get());
    }

    public void showOpportunities() {
//        var count = 0;
//        var oppList = opportunityRepository.findAll();
//        for(Opportunity opportunity: oppList){
//            System.out.printf("""
//                *Lead specifications*
//                Lead Id: %s
//                Name: %s
//                Phone number: %s
//                Email: %s
//                Company name: %s
//                Sales Rep: %s
//                =======================
//                """, lead.getId(),
//                    lead.getName(),
//                    lead.getPhoneNumber(),
//                    lead.getEmail(),
//                    lead.getCompanyName(),
//                    lead.getSalesRep().getName());
//            count++;
//        }
//        System.out.println("Total: " + count);
    }

}
