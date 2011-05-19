package org.springframework.social.instagram.connect;

import org.springframework.social.instagram.api.Instagram;
import org.springframework.social.instagram.api.impl.InstagramTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

public class InstagramServiceProvider extends AbstractOAuth2ServiceProvider<Instagram> {
	
	private final String clientId;
	
	public InstagramServiceProvider(String clientId, String clientSecret) {
		super(new InstagramOAuth2Template(clientId, clientSecret));
		this.clientId = clientId;
	}
	
	public Instagram getApi(String accessToken) {
		return new InstagramTemplate(clientId, accessToken);
	}

}
