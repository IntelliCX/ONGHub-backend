package com.intellicx.onghub.posts.services;

import com.intellicx.onghub.posts.models.PostModel;
import com.intellicx.onghub.posts.repositories.PostsRepository;
import com.intellicx.onghub.shared.generics.GenericResponse;
import com.intellicx.onghub.shared.generics.ResponseData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPostsService {
    private final PostsRepository postsRepository;

    public GetAllPostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public GenericResponse<List<PostModel>> execute() {
        return new GenericResponse(200, new ResponseData(postsRepository.findAll()));
    }
}
