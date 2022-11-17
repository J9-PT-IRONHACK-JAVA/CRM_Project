package com.example.crm_project.Model;

import com.example.crm_project.Enums.Product;
import com.example.crm_project.Enums.Status;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor

public class Opportunity {

    private Long id;
    private long quantity;
    private Product product;
    private Status status;
    private Contact decisionMaker;
    private Account accountId;
    private SalesRep salesRepId;

    // Constructor => Create Opportunity with status OPEN by default
    public Opportunity() {
        setStatus(Status.OPEN);
    }

    // Constructor => Without ID (lombok is importing a full constructor with ID if needed)
    public Opportunity(String product, long quantity, Contact decisionMaker, Account accountId, SalesRep salesRepId) {
        setProduct(Product.valueOf(product));
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        this.status = Status.OPEN;
        setAccountId(accountId);
        setSalesRepId(salesRepId);
    }

    // Constructor => Without account
    public Opportunity(String product, long quantity, Contact decisionMaker, SalesRep salesRepId) {
        setProduct(Product.valueOf(product));
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        this.status = Status.OPEN;
        setSalesRepId(salesRepId);
    }

    @Override
    public String toString() {
        return "Opportunity: id = " + getId() + ", product = " + getProduct() + ", trucks quantity = " + getQuantity() + ", " +
               "status" +
               " = " + getStatus() +
               "\n Decision maker " + getDecisionMaker();
    }
}
