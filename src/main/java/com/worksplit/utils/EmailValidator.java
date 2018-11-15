package com.worksplit.utils;

import com.sun.deploy.security.ValidationState;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidatorMain.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValidator {
    String message() default "Invalid Email Id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
