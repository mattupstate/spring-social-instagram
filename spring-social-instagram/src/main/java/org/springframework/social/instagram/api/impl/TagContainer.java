package org.springframework.social.instagram.api.impl;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.instagram.api.Tag;

@JsonDeserialize(using=TagContainerDeserializer.class)
public class TagContainer extends AbstractInstagramResponseContainer<Tag> {

    public TagContainer(Tag tag) {
        super(tag);
    }
    
}
