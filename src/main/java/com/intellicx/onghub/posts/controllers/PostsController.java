package com.intellicx.onghub.posts.controllers;

import com.intellicx.onghub.posts.dtos.CreatePostDto;
import com.intellicx.onghub.posts.models.PostModel;
import com.intellicx.onghub.posts.services.CreatePostService;
import com.intellicx.onghub.posts.services.GetAllPostsService;
import com.intellicx.onghub.shared.annotations.GlobalController;
import com.intellicx.onghub.shared.generics.GenericResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@GlobalController
@RequestMapping("posts")
public class PostsController {
    private final CreatePostService createPostService;
    private final GetAllPostsService getAllPostsService;

    public PostsController (CreatePostService createPostService, GetAllPostsService getAllPostsService) {
        this.createPostService = createPostService;
        this.getAllPostsService = getAllPostsService;
    }

    @Operation(summary = "Creates an ONG", description = "Creates an ONG")
    @ApiResponse(responseCode = "201", description = "Post created", content = @Content(schema = @Schema(implementation = PostModel.class)))
    @ApiResponse(responseCode = "400", description = "Invalid image", content = @Content(schema = @Schema(example = "{ \"data\": \"Invalid image!\" }")))
    @ApiResponse(responseCode = "404", description = "ONG not found", content = @Content(schema = @Schema(example = "{ \"data\": \"ONG not found\" }")))
    @PostMapping("/share")
    ResponseEntity<Object> post(@Valid @RequestBody CreatePostDto createPostDto, BindingResult validationResult){
        GenericResponse response = createPostService.execute(createPostDto, validationResult);

        return ResponseEntity.status(response.status()).body(response.data());
    }

    @Operation(summary = "Creates an ONG", description = "Creates an ONG")
    @ApiResponse(responseCode = "200", description = "Shared posts", content = @Content(array = @ArraySchema(schema = @Schema(implementation = PostModel.class))))
    @GetMapping()
    ResponseEntity<Object> getPosts(){
        GenericResponse response = getAllPostsService.execute();

        return ResponseEntity.status(response.status()).body(response.data());
    }
}
