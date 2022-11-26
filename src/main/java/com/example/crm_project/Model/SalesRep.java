package com.example.crm_project.Model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor

@Entity
public class SalesRep {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "salesRepId")
    private List<Lead> leads;

    @OneToMany(mappedBy = "salesRepId")
    private List<Opportunity> opportunities;

    // Constructor => Save a SalesRep with leads list and opportunities list
    public SalesRep() {
        this.leads = new ArrayList<>();
        this.opportunities = new ArrayList<>();
    }

    // Constructor => Save a SalesRep with X name with leads list and opportunities list
    public SalesRep(String name) {
        this.name = name;
        this.leads = new ArrayList<>();
        this.opportunities = new ArrayList<>();
    }

    // Constructor => Save a SalesRep with X name, X leads list, X opportunities list
    public SalesRep(String name, List<Lead> leads, List<Opportunity> opportunities) {
        this.name = name;
        this.leads = leads;
        this.opportunities = opportunities;
    }

}
