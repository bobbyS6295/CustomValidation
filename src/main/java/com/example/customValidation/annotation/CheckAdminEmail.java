package com.example.customValidation.annotation;

import com.example.customValidation.dto.User;
import org.springframework.util.StringUtils;

import javax.validation.*;
import java.lang.annotation.*;


@Documented
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckAdminEmail.CheckAdminEmailValidator.class)
public @interface CheckAdminEmail {

    String message() default " Admin Email is Invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



    class CheckAdminEmailValidator implements ConstraintValidator<CheckAdminEmail, User>{


        @Override
        public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {

            if (StringUtils.isEmpty(user.getEmail())){
                return true;
            }

            if (user.isAdmin()){
               return user.getEmail().contains("Bobby");
            }
            return true;
        }
    }

}
