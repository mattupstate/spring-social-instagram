package org.springframework.social.instagram.api.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.instagram.api.Tag;

@JsonDeserialize(using=TagContainer.TagContainerDeserializer.class)
public class TagContainer extends AbstractInstagramResponseContainer<Tag> {

    public TagContainer(Tag tag) {
        super(tag);
    }
    
    public static class TagContainerDeserializer extends AbstractInstagramDeserializer<TagContainer> {

        @Override 
        public TagContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
                throws IOException, JsonProcessingException {
            return deserializeResponseObject(jp, TagContainer.class, Tag.class);
        }
        
    }
    
}
