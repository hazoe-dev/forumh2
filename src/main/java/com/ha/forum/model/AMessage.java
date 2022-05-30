package com.ha.forum.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@MappedSuperclass
public class AMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	@Temporal(TemporalType.DATE)
	@Column(name = "created_time")
	private Date createdTime;
	private String content;

	

	public AMessage() {
	}

	public AMessage(Long id, String title, Date createdTime, String content) {
		super();
		this.id = id;
		this.title = title;
		this.createdTime = createdTime;
		this.content = content;
	}

	public AMessage(String title, Date createdTime, String content) {
		this.title = title;
		this.createdTime = createdTime;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		AMessage other = (AMessage) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AMessage [id=" + id + ", title=" + title + ", createdTime=" + createdTime + ", content=" + content
				 + "]";
	}

}
