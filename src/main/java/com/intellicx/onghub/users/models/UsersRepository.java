package com.intellicx.onghub.users.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<UserModel, UUID> {
}
