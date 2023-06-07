package com.intellicx.onghub.contributors.repositories;

import com.intellicx.onghub.contributors.models.ContributorModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ContributorsRepository extends JpaRepository<ContributorModel, UUID> {

    @Query("select e from ContributorModel e where e.email=?1")
    Optional<ContributorModel> findByemail(String email);

    @Override
    @Query("select e from ContributorModel e where e.deletedAt=null")
    List<ContributorModel> findAll();

    @Transactional
    @Query("update ContributorModel e set e.deletedAt=CURRENT_DATE where e.id=?1")
    @Modifying
    ContributorModel softDelete(UUID id);
}
