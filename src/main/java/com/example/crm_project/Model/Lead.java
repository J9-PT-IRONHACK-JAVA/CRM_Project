package com.example.crm_project.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private long phoneNumber;
    private String email;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    // Constructor => Without ID (lombok is importing a full constructor with ID if needed)
    public Lead(String name, long phoneNumber, String email, String companyName) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    // Constructor => With salesRep
    public Lead(String name, long phoneNumber, String email, String companyName, SalesRep salesRep) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.salesRep = salesRep;
    }


    @Override
    public String toString() {
        return "Contact: name = " + getName() + ", phoneNumber = " + getPhoneNumber() +
               ", email = " + getEmail() + ", companyName = " + getCompanyName() + "\n";
    }
}
