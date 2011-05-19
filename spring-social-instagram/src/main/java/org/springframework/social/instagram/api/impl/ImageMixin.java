package org.springframework.social.instagram.api.impl;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class ImageMixin {
	@JsonCreator
	ImageMixin(
			@JsonProperty("url") String url,
			@JsonProperty("width") int width,
			@JsonProperty("height") int height) {}
	
}
