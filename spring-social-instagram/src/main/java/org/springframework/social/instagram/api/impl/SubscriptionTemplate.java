package org.springframework.social.instagram.api.impl;

import org.springframework.social.instagram.api.Aspect;
import org.springframework.social.instagram.api.Subscription;
import org.springframework.social.instagram.api.SubscriptionObject;
import org.springframework.social.instagram.api.SubscriptionOperations;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.util.List;

public class SubscriptionTemplate extends AbstractInstagramOperations implements SubscriptionOperations {

    private static final String SUBSCRIPTIONS = "subscriptions";
    private static final String OBJECT_ID = "object_id";
    private static final String OBJECT = "object";

    public SubscriptionTemplate(InstagramTemplate instagramTemplate, boolean isAuthorizedForUser) {
        super(instagramTemplate, isAuthorizedForUser);
    }

    public List<Subscription> createGeographySubscription(Aspect aspect, String verifyToken, URI callbackUri,
                                                          double lat, double lng, int radius) {
        final MultiValueMap<String, String> data = new LinkedMultiValueMap<String, String>();
        data.add(OBJECT, SubscriptionObject.tag.name());
        data.add("lat", Double.toString(lat));
        data.add("lng", Double.toString(lat));
        data.add("radius", Integer.toString(radius));
        data.add("aspect", aspect.name());
        data.add("verify_token", verifyToken);
        data.add("callback_url", callbackUri.toString());
        return post(buildUri(SUBSCRIPTIONS_ENDPOINT + SUBSCRIPTIONS), data, SubscriptionsList.class).getList();
    }

    public List<Subscription> createLocationSubscription(Aspect aspect, String verifyToken, URI callbackUri,
                                                         String objectId) {
        final MultiValueMap<String, String> data = new LinkedMultiValueMap<String, String>();
        data.add(OBJECT, SubscriptionObject.location.name());
        data.add(OBJECT_ID, objectId);
        data.add("aspect", aspect.name());
        data.add("verify_token", verifyToken);
        data.add("callback_url", callbackUri.toString());
        return post(buildUri(SUBSCRIPTIONS_ENDPOINT + SUBSCRIPTIONS), data, SubscriptionsList.class).getList();
    }

    public List<Subscription> createTagSubscription(Aspect aspect, String verifyToken, URI callbackUri, String objectId) {
        final MultiValueMap<String, String> data = new LinkedMultiValueMap<String, String>();
        data.add(OBJECT, SubscriptionObject.tag.name());
        data.add(OBJECT_ID, objectId);
        data.add("aspect", aspect.name());
        data.add("verify_token", verifyToken);
        data.add("callback_url", callbackUri.toString());
        return post(buildUri(SUBSCRIPTIONS_ENDPOINT + SUBSCRIPTIONS), data, SubscriptionsList.class).getList();
    }

    public List<Subscription> createUserSubscription(Aspect aspect, String verifyToken, URI callbackUri) {
        final MultiValueMap<String, String> data = new LinkedMultiValueMap<String, String>();
        data.add(OBJECT, SubscriptionObject.user.name());
        data.add("aspect", aspect.name());
        data.add("verify_token", verifyToken);
        data.add("callback_url", callbackUri.toString());
        return post(buildUri(SUBSCRIPTIONS_ENDPOINT + SUBSCRIPTIONS), data, SubscriptionsList.class).getList();
    }

    public List<Subscription> getSubscriptions() {
        return get(buildUri(SUBSCRIPTIONS_ENDPOINT + SUBSCRIPTIONS), SubscriptionsList.class).getList();
    }

    public void deleteSubscription(String id) {
        final URI uri = URIBuilder.fromUri(buildUri(SUBSCRIPTIONS_ENDPOINT + SUBSCRIPTIONS).toString())
                .queryParam("id", id).build();
        delete(uri);
    }

    public void deleteSubscriptions(SubscriptionObject object) {
        final URI uri = URIBuilder.fromUri(buildUri(SUBSCRIPTIONS_ENDPOINT + SUBSCRIPTIONS).toString())
                .queryParam(OBJECT, object.name()).build();
        delete(uri);
    }

    public void deleteAllSubscriptions() {
        final URI uri = URIBuilder.fromUri(buildUri(SUBSCRIPTIONS_ENDPOINT + SUBSCRIPTIONS).toString())
                .queryParam(OBJECT, "all").build();
        delete(uri);
    }

}
