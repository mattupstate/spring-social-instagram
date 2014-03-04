package org.springframework.social.instagram.api;

import java.util.List;


/**
 * Interface defining the operations for retrieving information about Instagram users and
 * managing relationships amongst the authenticated user.
 */
public interface UserOperations {
	
	/**
	 * Get basic information about the authenticated user
	 * @return Instagram profile
	 */
	InstagramProfile getUser();
	
	/**
	 * Get basic information about a specific user
	 * @param userId
	 * @return	Instagram profile
	 */
	InstagramProfile getUser(String userId);
	
	/**
	 * Get the first page of the authenticated user's feed
	 * @return List of media
	 */
	PagedMediaList getFeed();
	
	/**
     * Get a range of media from the authenticated user's feed
     * @param maxId Get media before this ID
     * @param minId Get media after this ID
     * @return List of media
     */
	PagedMediaList getFeed(String maxId, String minId);
	
	/**
	 * Get recent media of a specific user
	 * @param userId
	 * @return	List of media
	 */
	 PagedMediaList getRecentMedia(String userId);
	
	/**
     * Get a range of recent media of a specific user
     * @param userId
     * @param maxId Get media before this ID
     * @param minId Get media after this ID
     * @param minTimestamp Get media after this Unix timestamp
     * @param manTimestamp Get media before this Unix timestamp
     * @return  List of media
     */
	 PagedMediaList getRecentMedia(String userId, String maxId, String minId, long minTimestamp, long maxTimestamp);
	
	/**
	 * Search for users
	 * @param query
	 * @return List of profiles
	 */
	List<InstagramProfile> search(String query);
	
	/**
	 * Get the list of users the specified user follows
	 * @param userId
	 * @return	List of profiles
	 */
	List<InstagramProfile> getFollows(String userId);
	
	/**
	 * Get the list of users the specified user is followed by
	 * @param userId
	 * @return	List of profiles
	 */
	List<InstagramProfile> getFollowedBy(String userId);
	
	/**
	 * List the users who have requested the authenticated user's permission to follow
	 * @return	List of profiles
	 */
	List<InstagramProfile> getRequestedBy();
	
	/**
	 * Get information about the authenticated user's relationship (follow/following/etc) to another user
	 * @param userId
	 * @return User relationship
	 */
	Relationship getRelationship(String userId);
	
	/**
	 * Send a request to follow the specified user
	 * @param userId
	 */
	void followUser(String userId);
	
	/**
	 * Stop following the specified user
	 * @param userId
	 */
	void unfollowUser(String userId);
	
	/**
	 * Block the specified user
	 * @param userId
	 */
	void blockUser(String userId);
	
	/**
	 * Unblock the specified user
	 * @param userId
	 */
	void unblockUser(String userId);
	
	/**
	 * Approve a user's request to follow the authenticated user
	 * @param userId
	 */
	void approveUser(String userId);
	
	/**
	 * Deny a user's request to follow the authenticated user
	 * @param user
	 */
	void denyUser(String user);
	
	public static final String USERS_ENDPOINT = "users/";
}
