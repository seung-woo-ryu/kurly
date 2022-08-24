package com.kurly.demo.user.repository;

import com.kurly.demo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
