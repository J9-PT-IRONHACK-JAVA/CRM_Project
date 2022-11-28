package com.example.crm_project.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@Component
public class Validate {

    public static final Pattern VALID_PHONENUMBER_REGEX =
            Pattern.compile("\\A[0-9]{3}[0-9]{3}[0-9]{3}\\z", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    public boolean isValidIntInput(String input) {
        return input.matches("^\\d+$");
    }

    public static boolean validatePhone(String phoneStr) {
        Matcher matcher = VALID_PHONENUMBER_REGEX.matcher(phoneStr);
        return matcher.find();
    }

    public static boolean validateEmailAddress(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }


    public boolean leadIdExists(String id) {
//        TODO method that checks if lead id exists in current database
        return true;
    }
}
