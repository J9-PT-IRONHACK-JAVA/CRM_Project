package com.example.crm_project.Model;

import com.example.crm_project.Enums.Product;
import com.example.crm_project.Enums.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor

@Entity
public class Opportunity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Product product;

    private long quantity;

    @Embedded
    private Contact decisionMaker;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account accountId;

    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
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

    //Oportunity to check the count by product
    public Opportunity(Product product){
        this.product = product;
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
