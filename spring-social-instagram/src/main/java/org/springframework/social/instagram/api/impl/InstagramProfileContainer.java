package org.springframework.social.instagram.api.impl;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.instagram.api.InstagramProfile;

@JsonDeserialize(using=InstagramProfileContainerDeserializer.class)
public class InstagramProfileContainer {
	
	private InstagramProfile profile;
	
	public InstagramProfileContainer(InstagramProfile profile) {
		this.profile = profile;
	}
	
	public InstagramProfile getProfile() {
		return profile;
	}
}
