package org.springframework.social.instagram.api;

/**
 * Interface specifying a basic set of operations for interacting with Instagram.
 * Implemented by InstagramTemplate. Not often used directly, but a useful option
 * to enhance testability, as it can easily be mocked or stubbed.
 */
public interface Instagram {
	
	/**
	 * Returns the portion of the Instagram API that handles tag operations
	 */
	TagOperations tagOperations();
	
	/**
	 * Returns the portion of the Instagram API that handles location operations
	 */
	LocationOperations locationOperations();
	
	/**
	 * Returns the portion of the Instagram API that handles media operations
	 */
	MediaOperations mediaOperations();
	
	/**
	 * Returns the portion of the Instagram API that handles user operations
	 */
	UserOperations userOperations();
	
}
