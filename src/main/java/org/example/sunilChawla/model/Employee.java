package org.example.sunilChawla.model;


import org.example.sunilChawla.customException.InvalidInputException;

import java.util.regex.Pattern;

public class Employee {

    private final String name;
    private final String email;


    public Employee(String email) throws InvalidInputException {
        // regex =>  "^(.+)@(\\S+)$"  OR "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$  OR  simple below implemented
        boolean isValidEmail = Pattern
                                      .compile("^[A-Za-z0-9+_.-]+@(.+)$", Pattern.CASE_INSENSITIVE)
                                      .matcher((email))
                                      .matches();
        if (isValidEmail) {
            this.email = email;
            this.name = this.email.substring(0, this.email.indexOf('@'));
        } else {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
