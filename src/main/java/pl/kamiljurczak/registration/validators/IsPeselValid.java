package pl.kamiljurczak.registration.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PeselValidator.class)
public @interface IsPeselValid {

    String message() default "Błędny numer PESEL";
    String notUnique() default "PESEL już istnieje w bazie";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
