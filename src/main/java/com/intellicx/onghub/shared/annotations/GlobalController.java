    package com.intellicx.onghub.shared.annotations;

    import org.springframework.web.bind.annotation.CrossOrigin;
    import org.springframework.web.bind.annotation.RestController;

    import java.lang.annotation.*;

    @Documented
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @RestController
    @CrossOrigin(origins = "*", maxAge = 3600)
    public @interface GlobalController {
    }
