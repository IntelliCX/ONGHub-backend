package com.intellicx.onghub.ongs.repositories;

import com.intellicx.onghub.ongs.models.ONGModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OngsRepository extends JpaRepository<ONGModel, UUID> {
    Optional<ONGModel> findByemail(String email);
}
