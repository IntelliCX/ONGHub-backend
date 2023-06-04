package com.intellicx.onghub.ongs.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CreateOrUpdateOngDto {
    @Schema(example = "ONG name")
    @NotNull(message = "ONG name is mandatory!")
    @Size(max = 255)
    private String name;

    @Schema(example = "ONG email")
    @NotNull(message = "ONG email is mandatory!")
    @Size(max = 255)
    private String email;

    @Schema(example = "ONG pix key")
    @NotNull(message = "ONG pix key is mandatory!")
    @Size(max = 255)
    private String pix;

    @Schema(example = "ONG website url")
    @NotNull(message = "ONG website url is mandatory!")
    @Size(max = 255)
    private String siteUrl;
}
