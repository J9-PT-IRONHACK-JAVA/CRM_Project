package com.example.crm_project.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Contact {

    private String name;
    private long phoneNumber;
    private String email;
    private String companyName;


    @Override
    public String toString() {
        return "Contact: name = " + getName() + ", phoneNumber = " + getPhoneNumber() +
               ", email = " + getEmail() + ", companyName = " + getCompanyName() + "\n";
    }
}
