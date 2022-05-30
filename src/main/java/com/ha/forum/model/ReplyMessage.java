package com.ha.forum.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_replymessage") 
public class ReplyMessage extends AMessage {
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User creator;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "topic_id", nullable = false)
	private Topic topic;

	public ReplyMessage() {
		super();
	}

	public ReplyMessage(Long id, String title, Date createdTime, String content, User creator, Topic topic) {
		super(id, title, createdTime, content);
		this.topic = topic;
		this.creator = creator;
	}

	public ReplyMessage(String title, Date createdTime, String content, User creator, Topic topic) {
		super(title, createdTime, content);
		this.topic = topic;
		this.creator = creator;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	
}
