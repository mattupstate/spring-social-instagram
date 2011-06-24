package org.springframework.social.instagram.api.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.social.instagram.api.Media;

public class MediaContainerDeserializer extends AbstractInstagramDeserializer<MediaContainer> {

	@Override
	public MediaContainer deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return deserializeResponseObject(jp, MediaContainer.class, Media.class);
	}
	
}
