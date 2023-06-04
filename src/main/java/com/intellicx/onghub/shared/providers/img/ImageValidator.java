package com.intellicx.onghub.shared.providers.img;

import com.intellicx.onghub.shared.annotations.ValidImage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.util.encoders.Base64;

public class ImageValidator implements ConstraintValidator<ValidImage, String> {
    @Override
    public void initialize(ValidImage constraintAnnotation) {
    }

    @Override
    public boolean isValid(String image, ConstraintValidatorContext constraintValidatorContext) {
        if (image.isEmpty()) return true;

        try {
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(Base64.decode(image)));

            return bufferedImage != null;
        } catch (IOException e) {
            return false;
        }
    }
}
