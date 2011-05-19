package org.springframework.social.instagram.api.impl;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.instagram.api.Media;
import org.springframework.social.instagram.api.Pagination;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class PagedMediaListMixin {
    @JsonCreator
    PagedMediaListMixin(
            @JsonProperty("data") List<Media> media,
            @JsonProperty("pagination") Pagination pagination){}
}
