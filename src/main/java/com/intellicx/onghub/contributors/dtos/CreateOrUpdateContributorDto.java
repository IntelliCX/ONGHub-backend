package com.intellicx.onghub.contributors.dtos;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CreateOrUpdateContributorDto {
    @ArraySchema(schema = @Schema(implementation = UUID.class))
    private List<UUID> ongsIds;

    @Schema(example = "Contributor name")
    @Size(max = 255)
    @NotNull(message = "Contributor name is mandatory!")
    private String name;

    @Schema(example = "Contributor email")
    @Size(max = 255)
    @NotNull(message = "Contributor email is mandatory!")
    private String email;

    @Schema(example = "Contributor email")
    @Size(max = 11)
    private String cellphone;
}
