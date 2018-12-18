package pl.kamiljurczak.registration.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kamiljurczak.registration.services.PatientService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselValidator implements ConstraintValidator<IsPeselValid, String> {

    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public void initialize(IsPeselValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(String pesel, ConstraintValidatorContext constraintValidatorContext) {
        if (!isPeselValid(pesel)) return false;
//        if (!isPeselUnique(pesel)) return false;
        return true;
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

    private boolean isPeselUnique(String pesel) {
        return !patientService.getPatientByPesel(pesel).isPresent();
    }
}
