package org.springframework.social.instagram.api.impl;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TagMixin {
    @JsonCreator
    TagMixin(
            @JsonProperty("name") String name,
            @JsonProperty("media_count") int mediaCount) {
    }
}
