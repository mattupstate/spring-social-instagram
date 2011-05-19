package org.springframework.social.instagram.api.impl;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class LocationMixin {
    @JsonCreator
    LocationMixin(
            @JsonProperty("id") long id,
            @JsonProperty("name") String name,
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude) {}

}
