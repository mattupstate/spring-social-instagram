package org.springframework.social.instagram.api;

import java.util.Date;

public class Caption {
	
	private String id;
	private Date createdTime;
	private String text;
	private InstagramProfile from;
	
	public Caption(String id, Date createdTime, String text, InstagramProfile from) {
		this.id = id;
		this.createdTime = createdTime;
		this.text = text;
		this.from = from;
	}

	public String getId() {
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
