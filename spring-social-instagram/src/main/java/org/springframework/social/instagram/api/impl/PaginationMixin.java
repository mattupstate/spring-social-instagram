package org.springframework.social.instagram.api.impl;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class PaginationMixin {
	@JsonCreator
	PaginationMixin(
			@JsonProperty("next_url") String nextUrl,
			@JsonProperty("next_max_id") String nextMaxId,
			@JsonProperty("next_min_id") String nextMinId) {}
}
