package com.intellicx.onghub.posts.repositories;

import com.intellicx.onghub.ongs.models.ONGModel;
import com.intellicx.onghub.posts.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PostsRepository extends JpaRepository<PostModel, UUID> {

    @Override
    @Query("select e from ONGModel e where e.deletedAt=null")
    List<PostModel> findAll();

    @Query("update PostModel e set e.deletedAt=CURRENT_DATE where e.id=?1")
    @Modifying
    PostModel softDelete(UUID id);
}
