package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TagMixin {
    @JsonCreator
    TagMixin(
            @JsonProperty("name") String name,
            @JsonProperty("media_count") int mediaCount) {
    }
}
