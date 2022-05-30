package com.ha.forum.service;

import java.util.List;

import com.ha.forum.model.ReplyMessage;
import com.ha.forum.model.Topic;

public interface ITopicService {
	public List<Topic> getTopics();
	public Topic getTopic(Long id);
	List<Topic> getTopicsByForum(Long forumId);
	Topic getTopicByIdAndForum(Long id, Long forumId);
	
	ReplyMessage addReplyMessage(ReplyMessage replyMessage);
}
