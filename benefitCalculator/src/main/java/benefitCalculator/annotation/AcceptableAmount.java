package benefitCalculator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import benefitCalculator.validation.AcceptableAmountValidator;

@Target( { ElementType.METHOD, ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AcceptableAmountValidator.class)
/**
Validates the amount and the frequency of the benefit instalments being correctly given 
**/
public @interface AcceptableAmount {

  String message() default "";
  
  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
