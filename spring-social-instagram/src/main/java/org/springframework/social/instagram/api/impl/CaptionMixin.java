package org.springframework.social.instagram.api.impl;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.instagram.api.InstagramProfile;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class CaptionMixin {
    @JsonCreator
    CaptionMixin(
            @JsonProperty("id") long id,
            @JsonProperty("created_time") @JsonDeserialize(using=InstagramDateDeserializer.class) Date createdTime,
            @JsonProperty("text") String text,
            @JsonProperty("from") InstagramProfile from) {}
}
