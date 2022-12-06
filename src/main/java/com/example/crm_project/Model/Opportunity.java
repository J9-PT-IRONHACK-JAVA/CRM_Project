package com.example.crm_project.Model;

import com.example.crm_project.Enums.Product;
import com.example.crm_project.Enums.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@Data
@Entity
@Table (name = "opportunities")
public class Opportunity {

    @Id
    //@NotNull
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
    private Account account;

    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    // Constructor => Create Opportunity with status OPEN by default
    public Opportunity() {
        setStatus(Status.OPEN);
    }

    public Opportunity(Product product, long quantity, Contact decisionMaker, Status status, Account accountId, SalesRep salesRep) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.account = accountId;
        this.salesRep = salesRep;
    }

    // Constructor => Without ID (lombok is importing a full constructor with ID if needed)
    public Opportunity(Product product, long quantity, Contact decisionMaker, Account account, SalesRep salesRep) {
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        this.status = Status.OPEN;
        setAccount(account);
        setSalesRep(salesRep);
    }

    //Oportunity to check the count by product
    public Opportunity(Product product){
        this.product = product;
    }

    // Constructor => Without account
    public Opportunity(Product product, long quantity, Contact decisionMaker, SalesRep salesRep) {
        this.product= product;
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        this.status = Status.OPEN;
        setSalesRep(salesRep);
    }

    @Override
    public String toString() {
        return "Opportunity: id = " + getId() + ", product = " + getProduct() + ", trucks quantity = " + getQuantity() + ", " +
               "status" +
               " = " + getStatus() +
               "\n Decision maker " + getDecisionMaker() +
                "\n Sales rep " + this.salesRep;
    }
}
