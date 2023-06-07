package com.intellicx.onghub.posts.dtos;

import com.intellicx.onghub.shared.annotations.ValidImage;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class CreatePostDto {
    @Schema(implementation = UUID.class)
    private UUID ongId;

    @Schema(example = "post caption")
    @Size(max = 255)
    private String caption;

    @ValidImage
    private String picture;
}
