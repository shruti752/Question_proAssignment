package com.HackerNewsApplication.HackerNewsApplication.jpa;

import com.HackerNewsApplication.HackerNewsApplication.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
