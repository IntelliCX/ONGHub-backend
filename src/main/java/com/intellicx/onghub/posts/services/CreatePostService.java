package com.intellicx.onghub.posts.services;

import com.intellicx.onghub.posts.dtos.CreatePostDto;
import com.intellicx.onghub.posts.models.PostModel;
import com.intellicx.onghub.posts.repositories.PostsRepository;
import com.intellicx.onghub.shared.generics.GenericResponse;
import com.intellicx.onghub.shared.generics.ResponseData;
import com.intellicx.onghub.shared.providers.img.ImageToBinary;
import com.intellicx.onghub.users.models.UserModel;
import com.intellicx.onghub.users.models.UsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class CreatePostService {
    private final PostsRepository postsRepository;

    private final UsersRepository usersRepository;
    private SerialBlob parsedImg = null;
    public CreatePostService(PostsRepository postsRepository, UsersRepository usersRepository) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
    }

    public GenericResponse<Object> execute(CreatePostDto createPostDto, BindingResult validationResult) {
        if(validationResult.hasErrors()) return new GenericResponse<>(400, new ResponseData<>(validationResult.getAllErrors()));

        Optional<UserModel> user = usersRepository.findById(createPostDto.getUserId());

        if (user.isEmpty()) return new GenericResponse<>(404, new ResponseData<>("User not found!"));

        String picture = createPostDto.getPicture();

        PostModel post = new PostModel();
        BeanUtils.copyProperties(createPostDto, post);
        post.setUser(user.get());

        if (!picture.isBlank())
            try {
                parsedImg = ImageToBinary.execute(picture);
                post.setPicture(parsedImg);
            } catch (SQLException e) {
                return new GenericResponse<>(500, new ResponseData<>("There was an error while parsing image!"));
            }

        PostModel createdPost = postsRepository.saveAndFlush(post);

        return new GenericResponse<>(201, new ResponseData<>(createdPost));
    }
}
