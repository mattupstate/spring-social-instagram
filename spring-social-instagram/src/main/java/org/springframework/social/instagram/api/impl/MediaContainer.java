package org.springframework.social.instagram.api.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.instagram.api.Media;

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
