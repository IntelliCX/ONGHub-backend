package com.intellicx.onghub.posts.controllers;

import com.intellicx.onghub.ongs.services.GetAllOngsService;
import com.intellicx.onghub.posts.dtos.CreatePostDto;
import com.intellicx.onghub.posts.models.PostModel;
import com.intellicx.onghub.posts.services.CreatePostService;
import com.intellicx.onghub.posts.services.GetAllONGPostsService;
import com.intellicx.onghub.posts.services.GetAllPostsService;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Posts", description = "Manages Posts")
@GlobalController
@RequestMapping("posts")
public class PostsController {
    private final CreatePostService createPostService;
    private final GetAllPostsService getAllPostsService;

    private final GetAllONGPostsService getAllONGPostsService;

    public PostsController (CreatePostService createPostService, GetAllPostsService getAllPostsService, GetAllONGPostsService getAllONGPostsService) {
        this.createPostService = createPostService;
        this.getAllPostsService = getAllPostsService;
        this.getAllONGPostsService = getAllONGPostsService;
    }

    @Operation(summary = "Lists all posts", description = "Lists all posts")
    @ApiResponse(responseCode = "200", description = "Shared posts", content = @Content(array = @ArraySchema(schema = @Schema(implementation = PostModel.class))))
    @GetMapping()
    ResponseEntity<Object> getPosts(){
        GenericResponse response = getAllPostsService.execute();

        return ResponseEntity.status(response.status()).body(response.data());
    }

    @Operation(summary = "Lists all ONG's posts", description = "Lists all ONG's posts")
    @ApiResponse(responseCode = "200", description = "ONG's shared posts", content = @Content(array = @ArraySchema(schema = @Schema(implementation = PostModel.class))))
    @GetMapping("/{ongId}")
    ResponseEntity<Object> getONGPosts(@PathVariable UUID ongId){
        GenericResponse response = getAllONGPostsService.execute(ongId);

        return ResponseEntity.status(response.status()).body(response.data());
    }

    @Operation(summary = "Shares an ONG post", description = "Shares an ONG post")
    @ApiResponse(responseCode = "201", description = "Post created", content = @Content(schema = @Schema(implementation = PostModel.class)))
    @ApiResponse(responseCode = "400", description = "Invalid image", content = @Content(schema = @Schema(example = "{ \"data\": \"Invalid image!\" }")))
    @ApiResponse(responseCode = "404", description = "ONG not found", content = @Content(schema = @Schema(example = "{ \"data\": \"ONG not found\" }")))
    @PostMapping("/share")
    ResponseEntity<Object> post(@Valid @RequestBody CreatePostDto createPostDto, BindingResult validationResult){
        GenericResponse response = createPostService.execute(createPostDto, validationResult);

        return ResponseEntity.status(response.status()).body(response.data());
    }

}
