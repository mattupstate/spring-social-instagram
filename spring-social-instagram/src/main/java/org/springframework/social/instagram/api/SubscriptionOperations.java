package org.springframework.social.instagram.api;

import java.net.URI;
import java.util.List;

public interface SubscriptionOperations {

    List<Subscription> createGeographySubscription(Aspect aspect, String verifyToken, URI callbackUri, double lat,
                                                   double lng, int radius);

    List<Subscription> createLocationSubscription(Aspect aspect, String verifyToken, URI callbackUri, String objectId);

    List<Subscription> createTagSubscription(Aspect aspect, String verifyToken, URI callbackUri, String objectId);

    List<Subscription> createUserSubscription(Aspect aspect, String verifyToken, URI callbackUri);

    List<Subscription> getSubscriptions();

    void deleteSubscription(String id);

    void deleteSubscriptions(SubscriptionObject object);

    void deleteAllSubscriptions();

    public static final String SUBSCRIPTIONS_ENDPOINT = "subscriptions/";

}
