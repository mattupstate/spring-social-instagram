package org.springframework.social.instagram.api.impl;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Mixin class for adding Jackson annotations to InstagramProfile.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class InstagramProfileMixin {
    @JsonCreator
    InstagramProfileMixin(
            @JsonProperty("id") long id, 
            @JsonProperty("username") String username, 
            @JsonProperty("full_name") String fullName, 
            @JsonProperty("profile_picture") String profilePictureUrl, 
            @JsonProperty("counts") Map<String,Integer> counts) {}
    
    @JsonProperty("bio")
    String bio;
    
    @JsonProperty("website")
    String website;
    
    @JsonProperty("first_name")
    String firstName;
    
    @JsonProperty("last_name")
    String lastName;
}
