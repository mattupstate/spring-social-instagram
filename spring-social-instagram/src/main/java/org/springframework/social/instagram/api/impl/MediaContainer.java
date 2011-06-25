package org.springframework.social.instagram.api.impl;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.instagram.api.Media;

@JsonDeserialize(using=MediaContainerDeserializer.class)
public class MediaContainer extends AbstractInstagramResponseContainer<Media> {
	
	public MediaContainer(Media media) {
		super(media);
	}
	
}
