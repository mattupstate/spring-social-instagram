package org.springframework.social.instagram.api.impl;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.instagram.api.Comment;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class CommentsInfoMixin {
    @JsonCreator
    CommentsInfoMixin(
            @JsonProperty("count") int total,
            @JsonProperty("data") List<Comment> list) {}
    

}
