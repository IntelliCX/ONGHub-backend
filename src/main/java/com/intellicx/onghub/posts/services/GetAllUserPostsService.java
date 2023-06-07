package com.intellicx.onghub.posts.services;

import com.intellicx.onghub.posts.models.PostModel;
import com.intellicx.onghub.posts.repositories.PostsRepository;
import com.intellicx.onghub.shared.generics.GenericResponse;
import com.intellicx.onghub.shared.generics.ResponseData;
import com.intellicx.onghub.users.models.UserModel;
import com.intellicx.onghub.users.models.UsersRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GetAllUserPostsService {

    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;

    public GetAllUserPostsService(PostsRepository postsRepository, UsersRepository usersRepository) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
    }

    public GenericResponse<Object> execute(UUID userId) {
        Optional<UserModel> user =usersRepository.findById(userId);

        if (user.isEmpty()) return new GenericResponse<>(404, new ResponseData<>("User not found!"));

        return new GenericResponse<>(200, new ResponseData<>(postsRepository.findAllUserPosts(userId)));
    }

}
