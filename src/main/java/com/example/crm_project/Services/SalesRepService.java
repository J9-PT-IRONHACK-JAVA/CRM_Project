package com.example.crm_project.Services;

import com.example.crm_project.Repository.SalesRepRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class SalesRepService {

    @Autowired
    private SalesRepRepository salesRepRepository;

    public void createNewSalesRep() {
    }

    public void showSalesRep() {
        System.out.println(salesRepRepository.getAllSalesrep());
    }
}
