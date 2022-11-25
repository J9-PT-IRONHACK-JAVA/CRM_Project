package com.example.crm_project.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Validate {

    public boolean isValidIntInput(String input) {

        return input.matches("^\\d+$");
    }


}
