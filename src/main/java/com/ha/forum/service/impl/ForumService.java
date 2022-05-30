package com.ha.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.forum.model.Forum;
import com.ha.forum.model.Topic;
import com.ha.forum.repository.ForumRepository;
import com.ha.forum.repository.TopicRepository;
import com.ha.forum.service.IForumService;

@Service
public class ForumService implements IForumService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private ForumRepository forumRepository;
	
	@Override
	public Topic addTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	@Override
	public Forum getForum(Long id) {
		return forumRepository.findById(id).orElseThrow(()->new RuntimeException("Forum not found by id = "+id));
	}

	@Override
	public List<Forum> getForums() {
		return forumRepository.findAll();
	}

}
