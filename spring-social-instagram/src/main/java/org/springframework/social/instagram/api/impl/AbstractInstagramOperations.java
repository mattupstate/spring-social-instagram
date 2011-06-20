package org.springframework.social.instagram.api.impl;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public abstract class AbstractInstagramOperations {
	
	private final boolean isAuthorized;
	
	protected final InstagramTemplate instagram;
	
	public AbstractInstagramOperations(InstagramTemplate instagram, boolean isAuthorized) {
		this.instagram = instagram;
		this.isAuthorized = isAuthorized;
	}
	
	protected <T> T get(URI uri, Class<T> responseType) {
		return instagram.getRestTemplate().getForObject(uri, responseType);
	}
	
	protected <C> C post(URI uri, MultiValueMap<String,String> data,  Class<C> responseType) {
	    MultiValueMap<String, String> requestData = new LinkedMultiValueMap<String, String>(data);
		return instagram.getRestTemplate().postForObject(uri, requestData, responseType);
	}
	
	protected void delete(URI uri) {
		instagram.getRestTemplate().delete(uri);
	}
	
	protected void requireUserAuthorization() {
		if(!isAuthorized) {
			throw new MissingAuthorizationException();
		}
	}
	
	protected URI buildUri(String path) {
		return buildUri(path, Collections.<String, String>emptyMap());
	}
	
	protected URI buildUri(String path, Map<String, String> params) {
		URIBuilder uriBuilder = instagram.withAccessToken(API_URL_BASE + path);
		for (String paramName : params.keySet()) {
			uriBuilder.queryParam(paramName, String.valueOf(params.get(paramName)));
		}
		URI uri = uriBuilder.build();
		return uri;
	}
	
	private static final String API_URL_BASE = "https://api.instagram.com/v1/";
	
}
