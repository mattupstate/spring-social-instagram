package org.springframework.social.instagram.api;

import java.io.Serializable;

public class Update implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subscriptionId;
    private SubscriptionObject object;
    private String objectId;
    private Aspect changedAspect;
    private long time;

    public Update(String subscriptionId, SubscriptionObject object, String objectId, Aspect changedAspect, long time) {
        this.subscriptionId = subscriptionId;
        this.object = object;
        this.objectId = objectId;
        this.changedAspect = changedAspect;
        this.time = time;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public SubscriptionObject getObject() {
        return object;
    }

    public String getObjectId() {
        return objectId;
    }

    public Aspect getChangedAspect() {
        return changedAspect;
    }

    public long getTime() {
        return time;
    }

}
