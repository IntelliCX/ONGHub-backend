package com.intellicx.onghub.ongs.repositories;

import com.intellicx.onghub.ongs.models.ONGModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OngsRepository extends JpaRepository<ONGModel, UUID> {
    @Query("select e from ONGModel e where e.email=?1")
    Optional<ONGModel> findByemail(String email);

    @Override
    @Query("select e from ONGModel e where e.deletedAt=null")
    public List<ONGModel> findAll();

    @Query("update #{#entityName} e set e.deletedAt=CURRENT_DATE where e.id=?1")
    @Modifying
    public ONGModel softDelete(UUID id);
}
