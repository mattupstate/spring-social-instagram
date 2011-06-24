package org.springframework.social.instagram.api;

import java.util.Map;

public class InstagramProfile {
	
	private final long id;
	private final String profilePictureUrl;
	private final String username;
	private final Map<String,Integer> counts;
	private final String fullName;
	private String bio;
	private String website;
	private String firstName;
	private String lastName;
	
	public InstagramProfile(long id, String username, String fullName, String profilePictureUrl, Map<String,Integer> counts) {
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.profilePictureUrl = profilePictureUrl;
		this.counts = counts;
	}
	
	public long getId() {
		return id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}
	
	public String getUsername() {
		return username;
	}

	public Map<String,Integer> getCounts() {
		return counts;
	}	
	
	public int getMediaCount() {
	    return counts.get("media");
	}
	
	public int getFollowsCount() {
	    return counts.get("follows");
	}
	
    public int getFollowedBy() {
        return counts.get("followed_by");
    }

	public String getBio() {
		return bio;
	}

	public String getWebsite() {
		return website;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
