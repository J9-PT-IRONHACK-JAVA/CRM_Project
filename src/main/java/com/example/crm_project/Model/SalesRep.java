package com.example.crm_project.Model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Data
@AllArgsConstructor

@Entity
@Table( name = "salesReps")
public class SalesRep {

    @Id
    //@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "rep_name")
    private String name;

    @OneToMany(mappedBy = "salesRep")
    private List<Lead> leads;

    @OneToMany(mappedBy = "salesRep")
    private List<Opportunity> opportunities;

    private String password;

    // Constructor => Save a SalesRep with leads list and opportunities list
    public SalesRep() {
        this.leads = new ArrayList<>();
        this.opportunities = new ArrayList<>();

    }

    public SalesRep(String name) {
        this.name = name;
    }

    // Constructor => Save a SalesRep with X name with leads list and opportunities list
    public SalesRep(String name, String password) {
        this.name = name;
        this.leads = new ArrayList<>();
        this.opportunities = new ArrayList<>();
        this.password = password;
    }

    // Constructor => Save a SalesRep with X name, X leads list, X opportunities list
    public SalesRep(String name, List<Lead> leads, List<Opportunity> opportunities, String password) {
        this.name = name;
        this.leads = leads;
        this.opportunities = opportunities;
        this.password = password;
    }



}
