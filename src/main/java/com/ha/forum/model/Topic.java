package com.ha.forum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_topic") 
public class Topic extends AMessage {
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User creator;
	@OneToMany(mappedBy = "topic", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ReplyMessage> replyMessages = new ArrayList<ReplyMessage>();
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "forum_id", nullable = false)
	private Forum forum;

	public Topic() {
		super();
	}

	public Topic(Long id, String title, Date createdTime, String content, User creator, Forum forum) {
		super(id, title, createdTime, content);
		this.forum = forum;
		this.creator = creator;
	}

	public Topic(String title, Date createdTime, String content, User creator, Forum forum) {
		super(title, createdTime, content);
		this.forum = forum;
		this.creator = creator;

	}

	public List<ReplyMessage> getReplyMessages() {
		return replyMessages;
	}

	public void setReplyMessages(List<ReplyMessage> replyMessages) {
		this.replyMessages = replyMessages;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

}
