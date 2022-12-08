package com.example.crm_project.Services;

import com.example.crm_project.Model.SalesRep;
import com.example.crm_project.Repository.SalesRepRepository;
import com.example.crm_project.utils.Prints;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class SalesRepService {

    @Autowired
    private SalesRepRepository salesRepRepository;
    @Autowired
    private Prints prints;

    public void createNewSalesRep(String[] salesRepInfo) {
        var newSalesRep = new SalesRep(salesRepInfo[0], salesRepInfo[1]);
        salesRepRepository.save(newSalesRep);
        prints.newSalesRepSuccessfullyCreated(newSalesRep);
    }

    public void showSalesRep() {
        var salesRepList = salesRepRepository.getAllSalesrep();
        prints.showSalesRep(salesRepList);
    }
}
