package pl.kamiljurczak.registration.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorrectPeselValidator implements ConstraintValidator<CorrectPesel, String> {

    private ApplicationContext applicationContext;

    private FieldValueExists service;
    private String fieldName;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void initialize(CorrectPesel correctPesel) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            return isPeselValid(s);
    }

    private boolean isPeselValid(String pesel) {
        int size = pesel.length();
        if (size != 11) {
            return false;
        }
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int j;
        int sum = 0;
        int controlSum;
        int checkSum = Integer.valueOf(pesel.substring(size - 1));
        for (int i = 0; i < size - 1; i++) {
            char c = pesel.charAt(i);
            j = Integer.valueOf(String.valueOf(c));
            sum += j * weights[i];
        }
        controlSum = 10 - (sum % 10);
        if (controlSum == 10) {
            controlSum = 0;
        }
        return (controlSum == checkSum);
    }
}
