package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;

import org.springframework.social.instagram.api.Relationship;

import java.io.IOException;

public class RelationshipContainerDeserializer extends AbstractInstagramDeserializer<RelationshipContainer> {
    
    @Override public RelationshipContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
            throws IOException, JsonProcessingException {
        return deserializeResponseObject(jp, RelationshipContainer.class, Relationship.class);
    }
}
