package org.springframework.social.instagram.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.instagram.api.Instagram;

public class InstagramConnectionFactory extends OAuth2ConnectionFactory<Instagram> {

	public InstagramConnectionFactory(String clientId, String clientSecret) {
		super("instagram", new InstagramServiceProvider(clientId, clientSecret), new InstagramAdapter());
	}
	
}
