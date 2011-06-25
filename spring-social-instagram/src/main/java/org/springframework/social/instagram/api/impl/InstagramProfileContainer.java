package org.springframework.social.instagram.api.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.instagram.api.InstagramProfile;

@JsonDeserialize(using=InstagramProfileContainer.InstagramProfileContainerDeserializer.class)
public class InstagramProfileContainer extends AbstractInstagramResponseContainer<InstagramProfile>{
	
	public InstagramProfileContainer(InstagramProfile profile) {
		super(profile);
	}
	
	public static class InstagramProfileContainerDeserializer extends AbstractInstagramDeserializer<InstagramProfileContainer> {

	    @Override
	    public InstagramProfileContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
	            throws IOException, JsonProcessingException {
	        return deserializeResponseObject(jp, InstagramProfileContainer.class, InstagramProfile.class);
	    }

	}
}
