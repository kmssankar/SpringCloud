package com.kms.stores.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kms.stores.authservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("Select u from User u where u.userName = :username")
	public Optional<User> getUserByUserName(String username);
}
