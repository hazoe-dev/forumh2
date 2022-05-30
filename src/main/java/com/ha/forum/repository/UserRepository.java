package com.ha.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ha.forum.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsernameAndPassword(String username, String password);

}
