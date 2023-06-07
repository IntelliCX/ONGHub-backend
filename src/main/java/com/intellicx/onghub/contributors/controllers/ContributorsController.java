package com.intellicx.onghub.contributors.controllers;

import com.intellicx.onghub.contributors.dtos.CreateOrUpdateContributorDto;
import com.intellicx.onghub.contributors.models.ContributorModel;
import com.intellicx.onghub.contributors.services.CreateContributorService;
import com.intellicx.onghub.contributors.services.GetAllContributorsService;
import com.intellicx.onghub.ongs.models.ONGModel;
import com.intellicx.onghub.shared.annotations.GlobalController;
import com.intellicx.onghub.shared.generics.GenericResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Contributors", description = "Manages Contributors")
@GlobalController
@RequestMapping("contributors")
public class ContributorsController {
    private final CreateContributorService createContributorService;
    private final GetAllContributorsService getAllContributorsService;

    public ContributorsController (CreateContributorService createContributorService, GetAllContributorsService getAllContributorsService) {
        this.createContributorService = createContributorService;
        this.getAllContributorsService = getAllContributorsService;
    }


    @Operation(summary = "Lists all contributors", description = "Lists all contributors")
    @ApiResponse(responseCode = "200", description = "Registred contributors", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ONGModel.class))))
    @GetMapping()
    ResponseEntity<Object> getAllContributors() {
        GenericResponse response = this.getAllContributorsService.execute();

        return ResponseEntity.status(response.status()).body(response.data());
    }

    @Operation(summary = "Creates an contributor", description = "Creates an contributor")
    @ApiResponse(responseCode = "201", description = "Contributor created", content = @Content(schema = @Schema(implementation = ContributorModel.class)))
    @ApiResponse(responseCode = "409", description = "Contributor's email already registred", content = @Content(schema = @Schema(example = "{ \"data\": \"This email is already registred\" }")))
    @PostMapping("/create")
    ResponseEntity<Object> createContributor(@Valid @RequestBody CreateOrUpdateContributorDto createOrUpdateContributorDto){
        GenericResponse response = this.createContributorService.execute(createOrUpdateContributorDto);

        return ResponseEntity.status(response.status()).body(response.data());
    }

}
