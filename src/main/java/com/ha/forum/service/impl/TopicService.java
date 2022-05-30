package com.ha.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.forum.model.ReplyMessage;
import com.ha.forum.model.Topic;
import com.ha.forum.repository.ReplyMessageRepository;
import com.ha.forum.repository.TopicRepository;
import com.ha.forum.service.ITopicService;

@Service
public class TopicService implements ITopicService {
	@Autowired 
	private TopicRepository topicRepository;
	@Autowired 
	private ReplyMessageRepository replyMessageRepository;
	
	@Override
	public List<Topic> getTopics() {
		return topicRepository.findAll();
	}

	@Override
	public Topic getTopic(Long id) {
		return topicRepository.findById(id).orElseThrow(()-> new RuntimeException("Topic not found by id = "+id));
	}
	
	@Override
	public Topic getTopicByIdAndForum(Long id,Long forumId) {
		return topicRepository.findByIdAndForumId(id, forumId);
	}

	@Override
	public List<Topic> getTopicsByForum(Long forumId) {
		return topicRepository.findByForumId(forumId);
	}

	@Override
	public ReplyMessage addReplyMessage(ReplyMessage replyMessage) {
		return replyMessageRepository.save(replyMessage);
	}
}
