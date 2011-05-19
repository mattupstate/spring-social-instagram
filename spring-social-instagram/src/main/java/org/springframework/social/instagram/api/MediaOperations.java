package org.springframework.social.instagram.api;

import java.util.List;


public interface MediaOperations {
	
	/**
	 * Create a comment on a media.
	 * @param mediaId
	 * @param text
	 */
	void addComment(long mediaId, String text);
	
	/**
	 * Set a like on this media by the currently authenticated user.
	 * @param mediaId
	 */
	void addLike(long mediaId);
	
	/**
	 * Remove a comment either on the authenticated user's media or authored by the authenticated user.
	 * @param mediaId
	 * @param commentId
	 */
	void deleteComment(long mediaId, long commentId);
	
	/**
	 * Remove a like on this media by the currently authenticated user.
	 * @param mediaId
	 */
	void deleteLike(long mediaId);
	
	/**
	 * Get a full list of comments on a media.
	 * @param mediaId
	 * @return A list of comments
	 */
	List<Comment> getComments(long mediaId);
	
	/**
	 * Get a list of users who have liked this media.
	 * @param mediaId
	 * @return A list of users
	 */
	List<InstagramProfile> getLikes(long mediaId);
	
	/**
	 * Get information about a media object.
	 * @param mediaId
	 * @return Media information
	 */
	Media getMedia(long mediaId);
	
	/**
	 * Get a list of what media is most popular at the moment.
	 * @return A list of media
	 */
	List<Media> getPopular();
	
	/**
	 * Search for media in a given area.
	 * @param latitude
	 * @param longitude
	 * @return A list of media
	 */
	List<Media> search(double latitude, double longitude);
	
	/**
	 * Search for media in a given area.
	 * @param latitude
	 * @param longitude
	 * @param distance
	 * @return A list of media
	 */
	List<Media> search(double latitude, double longitude, int distance);
	
	/**
	 * Search for media in a given area.
	 * @param latitude
	 * @param longitude
	 * @param maxTimeStamp
	 * @param minTimeStamp
	 * @param distance
	 * @return A list of media
	 */
	List<Media> search(double latitude, double longitude, long maxTimeStamp, long minTimeStamp, int distance);
	
	public static final String MEDIA_ENDPOINT = "media/";
}
