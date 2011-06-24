package org.springframework.social.instagram.api.impl;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.instagram.api.Media;

@JsonDeserialize(using=MediaContainerDeserializer.class)
public class MediaContainer {
	
	private Media media;
	
	public MediaContainer(Media media) {
		this.media = media;
	}
	
	public Media getMedia() {
		return media;
	}
}
