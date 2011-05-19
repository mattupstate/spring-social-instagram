package org.springframework.social.instagram.api.impl;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.instagram.api.InstagramProfile;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class LikesInfoMixin {
	
	@JsonCreator
	LikesInfoMixin(
			@JsonProperty("count") int total,
			@JsonProperty("data") List<InstagramProfile> list) {}

}
