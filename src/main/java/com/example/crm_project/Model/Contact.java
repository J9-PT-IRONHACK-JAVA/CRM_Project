package com.example.crm_project.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.StringReader;


@Data
@NoArgsConstructor
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    public Contact(String name, String phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Contact: name = " + getName() + ", phoneNumber = " + getPhoneNumber() +
               ", email = " + getEmail() + ", companyName = " + getCompanyName() + "\n";
    }
}
