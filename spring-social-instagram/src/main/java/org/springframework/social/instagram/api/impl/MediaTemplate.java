package org.springframework.social.instagram.api.impl;

import org.springframework.social.instagram.api.Comment;
import org.springframework.social.instagram.api.InstagramProfile;
import org.springframework.social.instagram.api.Media;
import org.springframework.social.instagram.api.MediaOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link MediaOperations}, providing a binding to Instagram's media-oriented REST resources.
 */
public class MediaTemplate extends AbstractInstagramOperations implements MediaOperations {

	
	public MediaTemplate(InstagramTemplate instagram, boolean isAuthorizedForUser) {
		super(instagram, isAuthorizedForUser);
	}
	
	public void addComment(String mediaId, String text) {
		requireUserAuthorization();
		MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>();
        params.add("text", text);
		post(buildUri(MEDIA_ENDPOINT + mediaId + "/comments/"), params, Map.class);
	}

	public void addLike(String mediaId) {
		requireUserAuthorization();
		post(buildUri(MEDIA_ENDPOINT + mediaId + "/likes/"), new LinkedMultiValueMap<String, String>(), Map.class);
	}

	public void deleteComment(String mediaId, String commentId) {
		requireUserAuthorization();
		delete(buildUri(MEDIA_ENDPOINT + mediaId + "/comments/" + commentId + "/"));
	}

	public void deleteLike(String mediaId) {
		requireUserAuthorization();
		delete(buildUri(MEDIA_ENDPOINT + mediaId + "/likes/"));
	}

	public List<Comment> getComments(String mediaId) {
		return get(buildUri(MEDIA_ENDPOINT + mediaId + "/comments/"), CommentList.class).getList();
	}

	public List<InstagramProfile> getLikes(String mediaId) {
		return get(buildUri(MEDIA_ENDPOINT + mediaId + "/likes/"), InstagramProfileList.class).getList();
	}

	public Media getMedia(String mediaId) {
		return get(buildUri(MEDIA_ENDPOINT + mediaId+ "/"), MediaContainer.class).getObject();
	}

	public List<Media> getPopular() {
		return get(buildUri(MEDIA_ENDPOINT + "popular/"), MediaList.class).getList();
	}

	public List<Media> search(double latitude, double longitude) {
		return search(latitude, longitude, 0, 0, 0);
	}

	public List<Media> search(double latitude, double longitude, int distance) {
		return search(latitude, longitude, 0, 0, distance);
	}

	public List<Media> search(double latitude, double longitude, long maxTimeStamp, long minTimeStamp, int distance) {
		Map<String,String> params = new HashMap<String, String>();
		params.put("lat", Double.toString(latitude));
		params.put("lng", Double.toString(longitude));
		if(maxTimeStamp > 0) params.put("max_timestamp", Long.toString(maxTimeStamp));
		if(minTimeStamp > 0) params.put("min_timestamp", Long.toString(minTimeStamp));
		if(distance > 0) params.put("distance", Integer.toString(distance));
		return get(buildUri(MEDIA_ENDPOINT + "search/", params), MediaList.class).getList();
	}

}
