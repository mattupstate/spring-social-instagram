package org.springframework.social.instagram.api.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.instagram.api.Relationship;

@JsonDeserialize(using=RelationshipContainer.RelationshipContainerDeserializer.class)
public class RelationshipContainer extends AbstractInstagramResponseContainer<Relationship> {
    
    public RelationshipContainer(Relationship relationship) {
        super(relationship);
    }

    public static class RelationshipContainerDeserializer extends AbstractInstagramDeserializer<RelationshipContainer> {
        
        @Override public RelationshipContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
                throws IOException, JsonProcessingException {
            return deserializeResponseObject(jp, RelationshipContainer.class, Relationship.class);
        }
    }
    
}
