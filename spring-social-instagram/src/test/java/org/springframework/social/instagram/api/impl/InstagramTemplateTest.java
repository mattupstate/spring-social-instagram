package org.springframework.social.instagram.api.impl;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.test.client.MockRestServiceServer;

public class InstagramTemplateTest extends AbstractInstagramApiTest {
	
	@Test(expected=MissingAuthorizationException.class)
	public void noAccessKey() {
		InstagramTemplate template = new InstagramTemplate("CLIENT_ID");
		MockRestServiceServer server = MockRestServiceServer.createServer(template.getRestTemplate());
		
		server.expect(requestTo("https://api.instagram.com/v1/users/self/?client_id=CLIENT_ID"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/error-response.json", getClass()), responseHeaders));
		
		template.userOperations().getUser();
		mockServer.verify();
	}
}
