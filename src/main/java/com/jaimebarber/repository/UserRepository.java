package com.jaimebarber.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimebarber.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findOneByEmail(String email);
}
