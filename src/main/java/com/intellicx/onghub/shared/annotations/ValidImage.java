package com.intellicx.onghub.shared.annotations;

import com.intellicx.onghub.shared.providers.img.ImageValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ImageValidator.class)
public @interface ValidImage {
    String message() default "Invalid image!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
