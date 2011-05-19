package org.springframework.social.instagram.api;

import org.springframework.social.SocialException;

@SuppressWarnings("serial")
public class InstagramApiException extends SocialException {

	private int code;
	private String errorType;
	
	public InstagramApiException(int code, String errorType, String message) {
		super(message);
		this.code = code;
		this.errorType = errorType;
	}

	public int getCode() {
		return code;
	}

	public String getErrorType() {
		return errorType;
	}
	
}
