package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.springframework.social.instagram.api.Media;

import java.io.IOException;

@JsonDeserialize(using=MediaContainer.MediaContainerDeserializer.class)
public class MediaContainer extends AbstractInstagramResponseContainer<Media> {
	
	public MediaContainer(Media media) {
		super(media);
	}

    public static class MediaContainerDeserializer extends AbstractInstagramDeserializer<MediaContainer> {
        @Override
        public MediaContainer deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            // TODO Auto-generated method stub
            return deserializeResponseObject(jp, MediaContainer.class, Media.class);
        }
    }
    
}
