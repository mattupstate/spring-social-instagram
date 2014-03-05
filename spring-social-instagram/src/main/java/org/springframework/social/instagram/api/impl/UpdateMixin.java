package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.social.instagram.api.Aspect;
import org.springframework.social.instagram.api.SubscriptionObject;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class UpdateMixin {

    @JsonCreator
    public UpdateMixin(
            @JsonProperty("subscription_id") String subscriptionId,
            @JsonProperty("object") SubscriptionObject object,
            @JsonProperty("object_id") String objectId,
            @JsonProperty("changed_aspect") Aspect changedAspect,
            @JsonProperty("time") long time) {}
    
}


