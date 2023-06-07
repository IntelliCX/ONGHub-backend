package com.intellicx.onghub.posts.controllers;

import com.intellicx.onghub.posts.dtos.CreatePostDto;
import com.intellicx.onghub.posts.models.PostModel;
import com.intellicx.onghub.posts.services.CreatePostService;
import com.intellicx.onghub.posts.services.GetAllUserPostsService;
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

    private final GetAllUserPostsService getAllUserPostsService;

    public PostsController (CreatePostService createPostService, GetAllPostsService getAllPostsService, GetAllUserPostsService getAllUserPostsService) {
        this.createPostService = createPostService;
        this.getAllPostsService = getAllPostsService;
        this.getAllUserPostsService = getAllUserPostsService;
    }

    @Operation(summary = "Lists all posts", description = "Lists all posts")
    @ApiResponse(responseCode = "200", description = "Shared posts", content = @Content(array = @ArraySchema(schema = @Schema(implementation = PostModel.class))))
    @GetMapping()
    ResponseEntity<Object> getPosts(){
        GenericResponse response = getAllPostsService.execute();

        return ResponseEntity.status(response.status()).body(response.data());
    }

    @Operation(summary = "Lists all user's posts", description = "Lists all user's posts")
    @ApiResponse(responseCode = "200", description = "User's shared posts", content = @Content(array = @ArraySchema(schema = @Schema(implementation = PostModel.class))))
    @GetMapping("/{userId}")
    ResponseEntity<Object> getONGPosts(@PathVariable UUID userId){
        GenericResponse response = getAllUserPostsService.execute(userId);

        return ResponseEntity.status(response.status()).body(response.data());
    }

    @Operation(summary = "Shares an user's post", description = "Shares an user's post")
    @ApiResponse(responseCode = "201", description = "Post created", content = @Content(schema = @Schema(implementation = PostModel.class)))
    @ApiResponse(responseCode = "400", description = "Invalid image", content = @Content(schema = @Schema(example = "{ \"data\": \"Invalid image!\" }")))
    @ApiResponse(responseCode = "404", description = "User not found", content = @Content(schema = @Schema(example = "{ \"data\": \"User not found\" }")))
    @PostMapping("/share")
    ResponseEntity<Object> post(@Valid @RequestBody CreatePostDto createPostDto, BindingResult validationResult){
        GenericResponse response = createPostService.execute(createPostDto, validationResult);

        return ResponseEntity.status(response.status()).body(response.data());
    }

}
