package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.social.instagram.api.Media;
import org.springframework.social.instagram.api.Pagination;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class PagedMediaListMixin {
    @JsonCreator
    PagedMediaListMixin(
            @JsonProperty("data") List<Media> media,
            @JsonProperty("pagination") Pagination pagination){}
}
