package org.springframework.social.instagram.api.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.instagram.api.InstagramProfile;

public class InstagramProfileContainerDeserializer extends AbstractInstagramDeserializer<InstagramProfileContainer> {

	@Override
	public InstagramProfileContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {
		return deserializeResponseObject(jp, InstagramProfileContainer.class, InstagramProfile.class);
	}

}
