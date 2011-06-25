package org.springframework.social.instagram.api.impl;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.instagram.api.Relationship;

@JsonDeserialize(using=RelationshipContainerDeserializer.class)
public class RelationshipContainer {
    
    private Relationship relationship;
    
    public RelationshipContainer(Relationship relationship) {
        this.relationship = relationship;
    }
    
    public Relationship getRelationship() {
        return relationship;
    }

}
