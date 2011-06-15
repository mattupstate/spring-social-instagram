package org.springframework.social.instagram.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.instagram.api.Instagram;
import org.springframework.social.instagram.api.InstagramProfile;

/**
 * Instagram ApiAdapter implementation.
 */
public class InstagramAdapter implements ApiAdapter<Instagram> {

	public boolean test(Instagram instagram) {
		try {
			instagram.userOperations().getUser();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	public void setConnectionValues(Instagram instagram, ConnectionValues values) {
		InstagramProfile profile = instagram.userOperations().getUser();
		values.setProviderUserId(Long.toString(profile.getId()));
		values.setDisplayName(profile.getUsername());
		values.setImageUrl(profile.getProfilePictureUrl());
	}

	public UserProfile fetchUserProfile(Instagram instagram) {
		InstagramProfile profile = instagram.userOperations().getUser();
		return new UserProfileBuilder().setName(profile.getFullName()).setUsername(profile.getUsername()).build();
	}

	public void updateStatus(Instagram instagram, String message) {
		// 
	}

}