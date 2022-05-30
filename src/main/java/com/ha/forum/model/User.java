package com.ha.forum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_user") 
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(name = "join_date")
	private Date joinDate;
	@OneToMany(mappedBy="creator")	
	private List<ReplyMessage> replyMessages = new ArrayList<>();
	
	@OneToMany(mappedBy="creator")	
	private List<Topic> topics = new ArrayList<>();
	
	public User() {
	}

	public User(String username, String password, String email, Date joinDate) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.joinDate = joinDate;
	}

	public User(Long id, String username, String password, String email, Date joinDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.joinDate = joinDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}


	public List<ReplyMessage> getReplyMessages() {
		return replyMessages;
	}

	public void setReplyMessages(List<ReplyMessage> replyMessages) {
		this.replyMessages = replyMessages;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", joinDate=" + joinDate + ", messages="  + "]";
	}

}
