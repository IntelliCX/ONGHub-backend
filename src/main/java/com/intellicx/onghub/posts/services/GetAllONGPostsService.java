package com.intellicx.onghub.posts.services;

import com.intellicx.onghub.posts.models.PostModel;
import com.intellicx.onghub.posts.repositories.PostsRepository;
import com.intellicx.onghub.shared.generics.GenericResponse;
import com.intellicx.onghub.shared.generics.ResponseData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetAllONGPostsService {

    private final PostsRepository postsRepository;

    public GetAllONGPostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public GenericResponse<List<PostModel>> execute(UUID ongId) {
        return new GenericResponse(200, new ResponseData(postsRepository.findAllUserPosts(ongId)));
    }

}
