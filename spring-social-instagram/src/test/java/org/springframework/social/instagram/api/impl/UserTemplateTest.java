package org.springframework.social.instagram.api.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.body;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.util.List;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.social.instagram.api.InstagramProfile;
import org.springframework.social.instagram.api.PagedMediaList;
import org.springframework.social.instagram.api.Relationship;

@SuppressWarnings("unused")
public class UserTemplateTest extends AbstractInstagramApiTest {

	@Test
	public void getUser() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/self/?access_token=ACCESS_TOKEN"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/user-profile.json", getClass()), responseHeaders));
		
		InstagramProfile user = instagram.userOperations().getUser();
		assertEquals("tomharman", user.getUsername());
		mockServer.verify();
	}
	
	@Test
	public void getSpecificUser() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/12345/?access_token=ACCESS_TOKEN"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/user-profile.json", getClass()), responseHeaders));
		
		InstagramProfile user = instagram.userOperations().getUser(12345);
		assertEquals("tomharman", user.getUsername());
		mockServer.verify();
	}
	
	@Test
	public void getFeed() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/self/feed/?access_token=ACCESS_TOKEN"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/recent-media.json", getClass()), responseHeaders));
		
		PagedMediaList media = instagram.userOperations().getFeed();
		assertPagedResults(media);
		mockServer.verify();
	}
	
	@Test
	public void getRecentMedia() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/12345/media/recent/?access_token=ACCESS_TOKEN"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/recent-media.json", getClass()), responseHeaders));
	
		PagedMediaList media = instagram.userOperations().getRecentMedia(12345);
		assertPagedResults(media);
		mockServer.verify();
	}
	
	@Test
	public void getFollowedBy() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/12345/followed-by/?access_token=ACCESS_TOKEN"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/user-list.json", getClass()), responseHeaders));
		
		List<InstagramProfile> follows = instagram.userOperations().getFollowedBy(12345);
		mockServer.verify();
	}
	
	@Test
	public void getFollows() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/12345/follows/?access_token=ACCESS_TOKEN"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/user-list.json", getClass()), responseHeaders));
		
		List<InstagramProfile> follows = instagram.userOperations().getFollows(12345);
		mockServer.verify();
	}
	
	@Test
	public void getRequestedBy() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/self/requested-by/?access_token=ACCESS_TOKEN"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/user-list.json", getClass()), responseHeaders));
		
		List<InstagramProfile> follows = instagram.userOperations().getRequestedBy();
		mockServer.verify();
	}
	
	@Test
	public void getRelationship() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/12345/relationship/?access_token=ACCESS_TOKEN"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/relationship.json", getClass()), responseHeaders));
	
		Relationship relationship = instagram.userOperations().getRelationship(12345);
		mockServer.verify();
	}
	
	@Test
	public void followUser() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/12345/relationship/?access_token=ACCESS_TOKEN"))
			.andExpect(method(POST))
			.andExpect(body("action=follow"))
			.andRespond(withResponse(new ClassPathResource("testdata/media-list.json", getClass()), responseHeaders));
		
		instagram.userOperations().followUser(12345);
		mockServer.verify();
	}
	
	@Test
	public void unfollowUser() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/12345/relationship/?access_token=ACCESS_TOKEN"))
			.andExpect(method(POST))
			.andExpect(body("action=unfollow"))
			.andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));

		instagram.userOperations().unfollowUser(12345);
		mockServer.verify();
	}
	
	@Test
	public void blockUser() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/12345/relationship/?access_token=ACCESS_TOKEN"))
			.andExpect(method(POST))
			.andExpect(body("action=block"))
			.andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));
		
		instagram.userOperations().blockUser(12345);
		mockServer.verify();
	}
	
	@Test
	public void unblockUser() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/12345/relationship/?access_token=ACCESS_TOKEN"))
			.andExpect(method(POST))
			.andExpect(body("action=unblock"))
			.andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));

		instagram.userOperations().unblockUser(12345);
		mockServer.verify();
	}
	
	@Test
	public void approveUser() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/12345/relationship/?access_token=ACCESS_TOKEN"))
			.andExpect(method(POST))
			.andExpect(body("action=approve"))
			.andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));

		instagram.userOperations().approveUser(12345);
		mockServer.verify();
	}
	
	@Test
	public void denyUser() {
		mockServer.expect(requestTo("https://api.instagram.com/v1/users/12345/relationship/?access_token=ACCESS_TOKEN"))
			.andExpect(method(POST))
			.andExpect(body("action=deny"))
			.andRespond(withResponse(new ClassPathResource("testdata/ok-response.json", getClass()), responseHeaders));

		instagram.userOperations().denyUser(12345);
		mockServer.verify();
	}
}
