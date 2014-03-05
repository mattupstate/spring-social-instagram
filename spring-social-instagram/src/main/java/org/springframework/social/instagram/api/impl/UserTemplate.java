package org.springframework.social.instagram.api.impl;

import org.springframework.social.instagram.api.InstagramProfile;
import org.springframework.social.instagram.api.PagedMediaList;
import org.springframework.social.instagram.api.Relationship;
import org.springframework.social.instagram.api.UserOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link UserOperations}, providing a binding to Instagram's user-oriented REST resources.
 */
public class UserTemplate extends AbstractInstagramOperations implements UserOperations {
	
	public UserTemplate(InstagramTemplate instagram, boolean isAuthorizedForUser) {
		super(instagram, isAuthorizedForUser);
	}

	public InstagramProfile getUser() {
		requireUserAuthorization();
		return get(buildUri(USERS_ENDPOINT + "self/"), InstagramProfileContainer.class).getObject();
	}

	public InstagramProfile getUser(String userId) {
		return get(buildUri(USERS_ENDPOINT + userId + "/"), InstagramProfileContainer.class).getObject();
	}

	public PagedMediaList getFeed() {
		return getFeed(null, null);
	}
	
	public PagedMediaList getFeed(String maxId, String minId) {
		requireUserAuthorization();
		Map<String,String> params = new HashMap<String, String>();
		if(maxId != null) params.put("max_id", maxId);
		if(minId != null) params.put("min_id", minId);
		return get(buildUri(USERS_ENDPOINT + "self/feed/", params), PagedMediaList.class);
	}

	public PagedMediaList getRecentMedia(String userId) {
		return getRecentMedia(userId, null, null, 0, 0);
	}

	public PagedMediaList getRecentMedia(String userId, String maxId, String minId, long minTimestamp, long maxTimestamp) {
		Map<String,String> params = new HashMap<String, String>();
		if(maxId != null) params.put("max_id", maxId);
		if(maxId != null) params.put("max_id", maxId);
		if(minTimestamp > 0) params.put("min_timestamp", Long.toString(minTimestamp));
		if(maxTimestamp > 0) params.put("max_timestamp", Long.toString(maxTimestamp));
		return get(buildUri(USERS_ENDPOINT + userId + "/media/recent/", params), PagedMediaList.class);
	}

	public List<InstagramProfile> search(String query) {
		return get(buildUri(USERS_ENDPOINT + "search/", Collections.singletonMap("q", query)), InstagramProfileList.class).getList();
	}

	public List<InstagramProfile> getFollows(String userId) {
		return get(buildUri(USERS_ENDPOINT + userId + "/follows/"), InstagramProfileList.class).getList();
	}

	public List<InstagramProfile> getFollowedBy(String userId) {
		return get(buildUri(USERS_ENDPOINT + userId + "/followed-by/"), InstagramProfileList.class).getList();
	}

	public List<InstagramProfile> getRequestedBy() {
		requireUserAuthorization();
		return get(buildUri(USERS_ENDPOINT + "self/requested-by/"), InstagramProfileList.class).getList();
	}

	public Relationship getRelationship(String userId) {
		requireUserAuthorization();
		return get(buildUri(USERS_ENDPOINT + userId + "/relationship/"), RelationshipContainer.class).getObject();
	}

	public void followUser(String userId) {
		modifyRelationship(userId, "follow");
	}

	public void unfollowUser(String userId) {
		modifyRelationship(userId, "unfollow");
	}

	public void blockUser(String userId) {
		modifyRelationship(userId, "block");
	}

	public void unblockUser(String userId) {
		modifyRelationship(userId, "unblock");
	}

	public void approveUser(String userId) {
		modifyRelationship(userId, "approve");
	}

	public void denyUser(String userId) {
		modifyRelationship(userId, "deny");
	}
	
	private void modifyRelationship(String userId, String action) {
		requireUserAuthorization();
		MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>();
		params.add("action", action);
		post(buildUri(USERS_ENDPOINT + userId + "/relationship/"), params, Map.class);
	}
	
	
	
}
