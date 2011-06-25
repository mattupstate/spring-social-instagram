package org.springframework.social.instagram.api.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.instagram.api.InstagramProfile;
import org.springframework.social.instagram.api.PagedMediaList;
import org.springframework.social.instagram.api.Relationship;
import org.springframework.social.instagram.api.UserOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

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

	public InstagramProfile getUser(long userId) {
		return get(buildUri(USERS_ENDPOINT + Long.toString(userId) + "/"), InstagramProfileContainer.class).getObject();
	}

	public PagedMediaList getFeed() {
		return getFeed(0, 0);
	}
	
	public PagedMediaList getFeed(long maxId, long minId) {
		requireUserAuthorization();
		Map<String,String> params = new HashMap<String, String>();
		if(maxId > 0) params.put("max_id", Long.toString(maxId));
		if(minId > 0) params.put("min_id", Long.toString(minId));
		return get(buildUri(USERS_ENDPOINT + "self/feed/", params), PagedMediaList.class);
	}

	public PagedMediaList getRecentMedia(long userId) {
		return getRecentMedia(userId, 0, 0, 0, 0);
	}

	public PagedMediaList getRecentMedia(long userId, long maxId, long minId, long minTimestamp, long maxTimestamp) {
		Map<String,String> params = new HashMap<String, String>();
		if(maxId > 0) params.put("max_id", Long.toString(maxId));
		if(maxId > 0) params.put("max_id", Long.toString(maxId));
		if(minTimestamp > 0) params.put("min_timestamp", Long.toString(minTimestamp));
		if(maxTimestamp > 0) params.put("max_timestamp", Long.toString(maxTimestamp));
		return get(buildUri(USERS_ENDPOINT + Long.toString(userId) + "/media/recent/", params), PagedMediaList.class);
	}

	public List<InstagramProfile> search(String query) {
		return get(buildUri(USERS_ENDPOINT + "search/", Collections.singletonMap("q", query)), InstagramProfileList.class).getList();
	}

	public List<InstagramProfile> getFollows(long userId) {
		return get(buildUri(USERS_ENDPOINT + Long.toString(userId) + "/follows/"), InstagramProfileList.class).getList();
	}

	public List<InstagramProfile> getFollowedBy(long userId) {
		return get(buildUri(USERS_ENDPOINT + Long.toString(userId) + "/followed-by/"), InstagramProfileList.class).getList();
	}

	public List<InstagramProfile> getRequestedBy() {
		requireUserAuthorization();
		return get(buildUri(USERS_ENDPOINT + "self/requested-by/"), InstagramProfileList.class).getList();
	}

	public Relationship getRelationship(long userId) {
		requireUserAuthorization();
		return get(buildUri(USERS_ENDPOINT + Long.toString(userId) + "/relationship/"), RelationshipContainer.class).getObject();
	}

	public void followUser(long userId) {
		modifyRelationship(userId, "follow");
	}

	public void unfollowUser(long userId) {
		modifyRelationship(userId, "unfollow");
	}

	public void blockUser(long userId) {
		modifyRelationship(userId, "block");
	}

	public void unblockUser(long userId) {
		modifyRelationship(userId, "unblock");
	}

	public void approveUser(long userId) {
		modifyRelationship(userId, "approve");
	}

	public void denyUser(long userId) {
		modifyRelationship(userId, "deny");
	}
	
	private void modifyRelationship(long userId, String action) {
		requireUserAuthorization();
		MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>();
		params.add("action", action);
		post(buildUri(USERS_ENDPOINT + Long.toString(userId) + "/relationship/"), params, Map.class);
	}
	
	
	
}
