package org.springframework.social.instagram.api.impl;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.instagram.api.InstagramProfile;

@JsonDeserialize(using=InstagramProfileContainerDeserializer.class)
public class InstagramProfileContainer extends AbstractInstagramResponseContainer<InstagramProfile>{
	
	public InstagramProfileContainer(InstagramProfile profile) {
		super(profile);
	}
	
}
