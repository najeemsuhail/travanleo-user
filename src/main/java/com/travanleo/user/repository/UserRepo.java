package com.travanleo.user.repository;

import com.travanleo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
