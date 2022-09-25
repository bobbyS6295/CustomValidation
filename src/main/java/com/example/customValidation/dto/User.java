package com.example.customValidation.dto;

import com.example.customValidation.annotation.CheckAdminEmail;
import com.example.customValidation.annotation.CheckCase;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Email;


@CheckAdminEmail
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {


    @CheckCase(node = CheckCase.CheckNode.UPPER,message = "{value} should be in upper case")
    private String firstName;

    @CheckCase(node = CheckCase.CheckNode.LOWER,message = "lastName case should be in lower case")
    private String lastName;

    @Email
    private String email;
    private boolean isAdmin;

    private String mobileNo;


    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
