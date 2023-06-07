package com.intellicx.onghub.ongs.controllers;

import com.intellicx.onghub.ongs.dtos.CreateOrUpdateOngDto;
import com.intellicx.onghub.ongs.models.ONGModel;
import com.intellicx.onghub.ongs.services.*;
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
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "ONGs", description = "Manages ONGs")
@GlobalController
@RequestMapping("/ongs")
public class OngsController {

    private final GetAllOngsService getAllOngsService;

    private final CreateOngService createOngService;

    private final UpdateOngService updateOngService;

    private final DeleteOngService deleteOngService;

    public OngsController(GetAllOngsService getAllOngsService, CreateOngService createOngService, UpdateOngService updateOngService, DeleteOngService deleteOngService) {
        this.getAllOngsService = getAllOngsService;
        this.createOngService = createOngService;
        this.updateOngService = updateOngService;
        this.deleteOngService = deleteOngService;
    }

    @Operation(summary = "Lists all ONGs", description = "Lists all ONGs")
    @ApiResponse(responseCode = "200", description = "Registred ONGs", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ONGModel.class))))
    @GetMapping()
    ResponseEntity<Object> getAllOngs() {
        GenericResponse response = this.getAllOngsService.execute();

        return ResponseEntity.status(response.status()).body(response.data());
    }

    @Operation(summary = "Creates an ONG", description = "Creates an ONG")
    @ApiResponse(responseCode = "201", description = "ONG created", content = @Content(schema = @Schema(implementation = ONGModel.class)))
    @ApiResponse(responseCode = "409", description = "ONG's email already registred", content = @Content(schema = @Schema(example = "{ \"data\": \"This email is already registred\" }")))
    @PostMapping("/create")
    ResponseEntity<Object> createOng(@Valid @RequestBody CreateOrUpdateOngDto createOrUpdateOngDto) {
        GenericResponse response = this.createOngService.execute(createOrUpdateOngDto);

        return ResponseEntity.status(response.status()).body(response.data());
    }

    @Operation(summary = "Updates ONG data", description = "Updates ONG data")
    @ApiResponse(responseCode = "200", description = "ONG updated", content = @Content(schema = @Schema(implementation = ONGModel.class)))
    @ApiResponse(responseCode = "404", description = "ONG not found", content = @Content(schema = @Schema(example = "{ \"data\": \"ONG not found\" }")))
    @PutMapping("/update/{id}")
    ResponseEntity<Object> updateOng(@PathVariable UUID id, @Valid @RequestBody CreateOrUpdateOngDto createOrUpdateOngDto) {
        GenericResponse response = this.updateOngService.execute(id, createOrUpdateOngDto);

        return ResponseEntity.status(response.status()).body(response.data());
    }

    @Operation(summary = "Deletes an ONG", description = "Deletes an ONG")
    @ApiResponse(responseCode = "200", description = "ONG deleted", content = @Content(schema = @Schema(implementation = ONGModel.class)))
    @ApiResponse(responseCode = "404", description = "ONG not found", content = @Content(schema = @Schema(example = "{ \"data\": \"ONG not found\" }")))
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Object> deleteOng(@PathVariable UUID id) {
        GenericResponse response = this.deleteOngService.execute(id);

        return ResponseEntity.status(response.status()).body(response.data());
    }
}
