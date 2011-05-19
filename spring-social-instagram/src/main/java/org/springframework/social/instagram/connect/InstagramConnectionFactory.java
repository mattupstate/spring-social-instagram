package org.springframework.social.instagram.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.instagram.api.Instagram;

public class InstagramConnectionFactory extends OAuth2ConnectionFactory<Instagram> {

	public InstagramConnectionFactory(String consumerKey, String consumerSecret) {
		super("instagram", new InstagramServiceProvider(consumerKey, consumerSecret), new InstagramAdapter());
	}
	
}
