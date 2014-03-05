package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.springframework.social.instagram.api.InstagramProfile;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class CommentMixin {
    @JsonCreator
    CommentMixin(
            @JsonProperty("id") String id,
            @JsonProperty("created_time") @JsonDeserialize(using=InstagramDateDeserializer.class) Date createdTime,
            @JsonProperty("text") String text,
            @JsonProperty("from") InstagramProfile from) {}
}
