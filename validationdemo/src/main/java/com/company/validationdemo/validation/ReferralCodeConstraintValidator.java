package com.company.validationdemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ReferralCodeConstraintValidator implements ConstraintValidator<ReferralCode, String> {

    private String referralPrefix;

    @Override
    public void initialize(ReferralCode referralCode) {
        referralPrefix = referralCode.value();
    }

    @Override
    public boolean isValid(String refCode, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        if(refCode != null) {
            result = refCode.startsWith(referralPrefix);
        } else {
            result = true;
        }
        return result;
    }
}
