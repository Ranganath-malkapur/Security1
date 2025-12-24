package com.Unique.SpringSecurityApp3.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Unique.SpringSecurityApp3.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
