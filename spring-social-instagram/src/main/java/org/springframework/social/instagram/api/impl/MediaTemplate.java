package org.springframework.social.instagram.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.instagram.api.Comment;
import org.springframework.social.instagram.api.InstagramProfile;
import org.springframework.social.instagram.api.Media;
import org.springframework.social.instagram.api.MediaOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Implementation of {@link MediaOperations}, providing a binding to Instagram's media-oriented REST resources.
 */
public class MediaTemplate extends AbstractInstagramOperations implements MediaOperations {

	
	public MediaTemplate(InstagramTemplate instagram, boolean isAuthorizedForUser) {
		super(instagram, isAuthorizedForUser);
	}
	
	public void addComment(long mediaId, String text) {
		requireUserAuthorization();
		MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>();
        params.add("text", text);
		post(buildUri(MEDIA_ENDPOINT + Long.toString(mediaId) + "/comments/"), params, Map.class);
	}

	public void addLike(long mediaId) {
		requireUserAuthorization();
		post(buildUri(MEDIA_ENDPOINT + Long.toString(mediaId) + "/likes/"), new LinkedMultiValueMap<String, String>(), Map.class);
	}

	public void deleteComment(long mediaId, long commentId) {
		requireUserAuthorization();
		delete(buildUri(MEDIA_ENDPOINT + Long.toString(mediaId) + "/comments/" + Long.toString(commentId) + "/"));
	}

	public void deleteLike(long mediaId) {
		requireUserAuthorization();
		delete(buildUri(MEDIA_ENDPOINT + Long.toString(mediaId) + "/likes/"));
	}

	public List<Comment> getComments(long mediaId) {
		return get(buildUri(MEDIA_ENDPOINT + Long.toString(mediaId) + "/comments/"), CommentList.class).getList();
	}

	public List<InstagramProfile> getLikes(long mediaId) {
		return get(buildUri(MEDIA_ENDPOINT + Long.toString(mediaId) + "/likes/"), InstagramProfileList.class).getList();
	}

	public Media getMedia(long mediaId) {
		return get(buildUri(MEDIA_ENDPOINT + Long.toString(mediaId)+ "/"), MediaContainer.class).getObject();
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
