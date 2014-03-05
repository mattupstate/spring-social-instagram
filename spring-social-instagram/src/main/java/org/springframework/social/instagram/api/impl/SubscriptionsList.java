package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.social.instagram.api.Subscription;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SubscriptionsList {

    private List<Subscription> list;
    
    @JsonCreator
    public SubscriptionsList(@JsonProperty("data") List<Subscription> list) {
        this.list = list;
    }
    
    public List<Subscription> getList() {
        return list;
    }
}
