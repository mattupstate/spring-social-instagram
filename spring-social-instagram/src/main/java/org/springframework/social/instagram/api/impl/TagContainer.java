package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.springframework.social.instagram.api.Tag;

import java.io.IOException;

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
