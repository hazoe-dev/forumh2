package com.ha.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ha.forum.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

	List<Topic> findByForumId(Long forumId);

	Topic findByIdAndForumId(Long id, Long forumId);
}
