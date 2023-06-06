package com.intellicx.onghub.users.repositories;

import com.intellicx.onghub.users.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<UserModel, UUID> {
}
