package org.springframework.social.instagram.api;

import java.util.List;


public interface TagOperations {

	/**
	 * Get information about a tag
	 * @param tagName	Tag name
	 * @return	A tag definition
	 */
	Tag getTag(String tagName);
	
	/**
	 * Get recent media for a specific tag
	 * @param tagName	Tag name
	 * @return	A list of media
	 */
	PagedMediaList getRecentMedia(String tagName);
	
	/**
	 * Get recent media for a specific tag
	 * @param tagName	Tag name
	 * @param maxId		Will return media after this ID
	 * @param minId		Will return media before this ID
	 * @return	A list of media
	 */
	PagedMediaList getRecentMedia(String tagName, long maxId, long minId);

	/**
	 * Search for tags by name - results are ordered first as an exact match, then by popularity.
	 * @param query	valid tag name without a leading #
	 * @return	A list of tags matching the query
	 */
	List<Tag> search(String query);
	
	
	public static final String TAGS_ENDPOINT = "tags/";
}
