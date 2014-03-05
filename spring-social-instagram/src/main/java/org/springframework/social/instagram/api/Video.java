package org.springframework.social.instagram.api;

public class Video {

	public static final String LOW_RESOLUTION = "low_resolution";
	public static final String STANDARD_RESOLUTION = "standard_resolution";
	
	private String url;
	private int width;
	private int height;
	
	public Video(String url, int width, int height) {
		this.url = url;
		this.width = width;
		this.height = height;
	}
	
	public String getUrl() {
		return url;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
