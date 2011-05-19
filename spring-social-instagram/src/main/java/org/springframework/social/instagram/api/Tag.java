package org.springframework.social.instagram.api;

public class Tag {
	
	private int mediaCount;
	private String name;
	
	public Tag(String name, int mediaCount) {
		this.name = name;
		this.mediaCount = mediaCount;
	}

	public int getMediaCount() {
		return mediaCount;
	}

	public String getName() {
		return name;
	}

}
