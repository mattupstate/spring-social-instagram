package org.springframework.social.instagram.api.impl;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.test.web.client.MockRestServiceServer;

public class InstagramTemplateTest extends AbstractInstagramApiTest {
	
	@Test(expected=MissingAuthorizationException.class)
	public void noAccessKey() {
		InstagramTemplate template = new InstagramTemplate("CLIENT_ID");
		MockRestServiceServer server = MockRestServiceServer.createServer(template.getRestTemplate());
		
		server.expect(requestTo("https://api.instagram.com/v1/users/self/?client_id=CLIENT_ID"))
			.andExpect(method(GET))
			.andRespond(withSuccess().body(new ClassPathResource("testdata/error-response.json", getClass())).headers(responseHeaders));
		
		template.userOperations().getUser();
		mockServer.verify();
	}
}
