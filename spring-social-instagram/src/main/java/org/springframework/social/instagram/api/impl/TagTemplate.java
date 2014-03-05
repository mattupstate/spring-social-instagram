package org.springframework.social.instagram.api.impl;

import org.springframework.social.instagram.api.PagedMediaList;
import org.springframework.social.instagram.api.Tag;
import org.springframework.social.instagram.api.TagOperations;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link TagOperations}, providing a binding to Instagram's tag-oriented REST resources.
 */
public class TagTemplate extends AbstractInstagramOperations implements TagOperations {

	public TagTemplate(InstagramTemplate instagram, boolean isAuthorizedForUser) {
		super(instagram, isAuthorizedForUser);
	}
	
	public Tag getTag(String tagName) {
		return get(buildUri(TAGS_ENDPOINT + tagName +"/"), TagContainer.class).getObject();
	}

	public PagedMediaList getRecentMedia(String tagName) {
		return getRecentMedia(tagName, null, null);
	}
	
	public PagedMediaList getRecentMedia(String tagName, String maxId, String minId) {
		Map<String,String> params = new HashMap<String,String>();
		if(maxId != null) params.put("max_id", maxId);
		if(minId != null) params.put("min_id", minId);
		return get(buildUri(TAGS_ENDPOINT + tagName + "/media/recent/", params), PagedMediaList.class);
	}

	public List<Tag> search(String query) {
		return get(buildUri(TAGS_ENDPOINT + "search/", Collections.singletonMap("q", query)), TagList.class).getList();
	}
	
}
