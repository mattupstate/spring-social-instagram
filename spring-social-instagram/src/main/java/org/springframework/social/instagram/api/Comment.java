package org.springframework.social.instagram.api;

import java.util.Date;

public class Comment {
	
	private long id;
	private Date createdTime;
	private String text;
	private InstagramProfile from;
	
	public Comment(long id, Date createdTime, String text, InstagramProfile from) {
		this.id = id;
		this.createdTime = createdTime;
		this.text = text;
		this.from = from;
	}
	
	public long getId() {
		return id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public String getText() {
		return text;
	}

	public InstagramProfile getFrom() {
		return from;
	}

}
