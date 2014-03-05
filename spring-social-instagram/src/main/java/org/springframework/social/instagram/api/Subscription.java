package org.springframework.social.instagram.api;

import java.net.URI;

public class Subscription {

    private String id;
    private String type;
    private SubscriptionObject object;
    private String objectId;
    private Aspect aspect;
    private URI callbackUrl;

    public Subscription(String id, String type, SubscriptionObject object, String objectId, Aspect aspect, URI callbackUrl) {
        this.id = id;
        this.type = type;
        this.object = object;
        this.objectId = objectId;
        this.aspect = aspect;
        this.callbackUrl = callbackUrl;
    }
    
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public SubscriptionObject getObject() {
        return object;
    }

    public String getObjectId() {
        return objectId;
    }

    public Aspect getAspect() {
        return aspect;
    }

    public URI getCallbackUrl() {
        return callbackUrl;
    }

}
