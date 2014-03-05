package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.springframework.social.instagram.api.InstagramProfile;

import java.io.IOException;

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
