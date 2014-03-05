package org.springframework.social.instagram.api;

import org.springframework.social.ApiBinding;

/**
 * Interface specifying a basic set of operations for interacting with Instagram.
 * Implemented by InstagramTemplate. Not often used directly, but a useful option
 * to enhance testability, as it can easily be mocked or stubbed.
 */
public interface Instagram extends ApiBinding {
	
    public static final String PROVIDER_ID = "instagram";
    
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
	 * Returns the portion of the Instagram API that handles subscription operations
	 * @return
	 */
	SubscriptionOperations subscriptionOperations();
	
	/**
	 * Returns the portion of the Instagram API that handles user operations
	 */
	UserOperations userOperations();
	
}
