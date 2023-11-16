package com.company.validationdemo.entity;

import com.company.validationdemo.validation.ReferralCode;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "has to be more or equal to 0")
    @Max(value = 10, message = "has to be less or equal to 10")
    private Integer passes;

    @Pattern(regexp = "^[0-9a-zA-Z]{5}", message = "only 5 chars/digits")
    private String postNumber;

    @ReferralCode
    private String referralCode;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Integer passes, String postNumber, String referralCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passes = passes;
        this.postNumber = postNumber;
        this.referralCode = referralCode;
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

    public Integer getPasses() {
        return passes;
    }

    public void setPasses(Integer passes) {
        this.passes = passes;
    }

    public String getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(String postNumber) {
        this.postNumber = postNumber;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }
}
