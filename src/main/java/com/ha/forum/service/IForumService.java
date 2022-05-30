package com.ha.forum.service;

import java.util.List;

import com.ha.forum.model.Forum;
import com.ha.forum.model.Topic;

public interface IForumService {
	public Topic addTopic(Topic topic);
	public Forum getForum(Long id);
	public List<Forum> getForums();
}
