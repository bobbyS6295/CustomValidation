package com.example.customValidation.annotation;


import org.springframework.util.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckCase.CheckCaseValidator.class)
public @interface CheckCase {


    String message() default "{javax.validation.constraints.NotNull.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    CheckNode node() default CheckNode.UPPER;


    enum CheckNode {
        UPPER ,LOWER
    }


     class CheckCaseValidator implements ConstraintValidator<CheckCase,String> {

        CheckNode node;

        @Override
        public void initialize(CheckCase constraintAnnotation) {
            this.node = constraintAnnotation.node();
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            if(StringUtils.isEmpty(s)){
                return true;
            }
            if (CheckNode.UPPER.equals(node)){
                return  s.toUpperCase().equals(s);
            }else{
                return  s.toLowerCase().equals(s);
            }
        }
    }



}
