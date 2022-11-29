package com.example.crm_project.Services;

import com.example.crm_project.Enums.Status;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class OpportunityService {
    public void closeOpportunity(int id, Status lostORwon) {
    }

}
