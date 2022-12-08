package com.example.crm_project.Services;

import com.example.crm_project.Enums.Status;
import com.example.crm_project.Repository.OpportunityRepository;
import com.example.crm_project.utils.Prints;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

}
