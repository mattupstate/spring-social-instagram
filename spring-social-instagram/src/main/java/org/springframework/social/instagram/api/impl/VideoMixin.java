package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class VideoMixin {
	@JsonCreator
	VideoMixin(
			@JsonProperty("url") String url,
			@JsonProperty("width") int width,
			@JsonProperty("height") int height) {}
	
}
