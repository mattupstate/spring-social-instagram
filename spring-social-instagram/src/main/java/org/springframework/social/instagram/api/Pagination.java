package org.springframework.social.instagram.api;

public class Pagination {
	
	private String nextUrl;
	private long nextMaxId;
	private long nextMinId;
	
	public Pagination(String nextUrl, long nextMaxId, long nextMinId) {
		this.nextUrl = nextUrl;
		this.nextMaxId = nextMaxId;
		this.nextMinId = nextMinId;
	}
	
	public String getNextUrl() {
		return nextUrl;
	}

	public long getNextMaxId() {
		return nextMaxId;
	}

	public long getNextMinId() {
		return nextMinId;
	}

}
