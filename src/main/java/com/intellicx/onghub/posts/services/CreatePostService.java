package com.intellicx.onghub.posts.services;

import com.intellicx.onghub.posts.dtos.CreatePostDto;
import com.intellicx.onghub.posts.models.PostModel;
import com.intellicx.onghub.posts.repositories.PostsRepository;
import com.intellicx.onghub.shared.generics.GenericResponse;
import com.intellicx.onghub.shared.generics.ResponseData;
import com.intellicx.onghub.shared.providers.img.ImageToBinary;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class CreatePostService {
    private final PostsRepository postsRepository;
    private SerialBlob parsedImg = null;
    public CreatePostService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public GenericResponse<PostModel> execute(CreatePostDto createPostDto, BindingResult validationResult) {
        if(validationResult.hasErrors()) return new GenericResponse(400, new ResponseData(validationResult.getAllErrors()));

        Optional<PostModel> ong = postsRepository.findById(createPostDto.getOngId());

        if (ong.isEmpty()) return new GenericResponse(404, new ResponseData("ONG not found!"));

        String picture = createPostDto.getPicture();

        if (!picture.isEmpty())
            try {
                parsedImg = ImageToBinary.execute(picture);
            } catch (SQLException e) {
                return new GenericResponse(500, new ResponseData("There was an error while parsing image!"));
            }

        PostModel post = new PostModel();
        BeanUtils.copyProperties(createPostDto, post);
        post.setPicture(parsedImg);

        PostModel createdPost = postsRepository.saveAndFlush(post);

        return new GenericResponse(201, new ResponseData(createdPost));
    }
}
