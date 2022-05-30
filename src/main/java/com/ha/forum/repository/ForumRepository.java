package com.ha.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ha.forum.model.Forum;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {

}
