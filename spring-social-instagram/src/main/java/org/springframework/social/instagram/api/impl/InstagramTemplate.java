package org.springframework.social.instagram.api.impl;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.instagram.api.Instagram;
import org.springframework.social.instagram.api.LocationOperations;
import org.springframework.social.instagram.api.MediaOperations;
import org.springframework.social.instagram.api.TagOperations;
import org.springframework.social.instagram.api.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

/**
 * This is the central class for interacting with Instagram.
 * <p>
 * Not all operations through Instagram require OAuth 2-based authentication. However,
 * to perform authenticated operations, such as commenting and liking, InstagramTemplate 
 * must be constructed with a valid access token.
 * </p>
 * <p>
 * There are quite a few operations that do not require OAuth authentication. In those cases, 
 * you may use a {@link InstagramTemplate} that is created through the default constructor.
 * Attempts to perform secured operations through such an instance, however,
 * will result in {@link IllegalStateException} being thrown.
 * </p>
 */
public class InstagramTemplate extends AbstractOAuth2ApiBinding implements Instagram {
    
	private final String accessToken;
	private final String clientId;
	private final TagOperations tagOperations;
	private final LocationOperations locationOperations;
	private final MediaOperations mediaOperations;
	private final UserOperations userOperations;
	
	/**
	 * Create a new instance of InstagramTemplate.
	 * This constructor creates a new InstagramTemplate able to perform unauthenticated 
	 * operations against Instagram's API. Some operations do not require OAuth authentication. A TwitterTemplate created with this constructor will support those operations.
     * Those operations requiring authentication will throw {@link BadCredentialsException}.
	 * @param clientId
	 */
	public InstagramTemplate(String clientId) {
		this(clientId, null, false);
	}
	
	/**
	 * Create a new instance of InstagramTemplate.
	 * @param clientId the application's client ID
	 * @param accessToken an access token acquired through OAuth authentication with Instagram
	 */
	public InstagramTemplate(String clientId, String accessToken) {
		this(clientId, accessToken, true);
	}
	
	private InstagramTemplate(String clientId, String accessToken, boolean isAuthorizedForUser) {
	    super(accessToken);
		this.clientId = clientId;
		this.accessToken = accessToken;	
		MappingJacksonHttpMessageConverter json = new MappingJacksonHttpMessageConverter();
        json.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "javascript")));
		getRestTemplate().getMessageConverters().add(json);
		registerInstagramJsonModule(getRestTemplate());
		getRestTemplate().setErrorHandler(new InstagramErrorHandler());
		
		tagOperations = new TagTemplate(this, isAuthorizedForUser);
		locationOperations = new LocationTemplate(this, isAuthorizedForUser);
		mediaOperations = new MediaTemplate(this, isAuthorizedForUser);
		userOperations = new UserTemplate(this, isAuthorizedForUser);
	}
	
	private void registerInstagramJsonModule(RestTemplate restTemplate) {
	    List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> converter : converters) {
            if(converter instanceof MappingJacksonHttpMessageConverter) {
                MappingJacksonHttpMessageConverter jsonConverter = (MappingJacksonHttpMessageConverter) converter;
                ObjectMapper objectMapper = new ObjectMapper();             
                objectMapper.registerModule(new InstagramModule());
                jsonConverter.setObjectMapper(objectMapper);
            }
        }
	}
	
	public URIBuilder withAccessToken(String uri) {
		return (accessToken == null) 
			? URIBuilder.fromUri(uri).queryParam("client_id", clientId)
			: URIBuilder.fromUri(uri).queryParam("access_token", accessToken);
	}
	
	public TagOperations tagOperations() {
		return tagOperations;
	}
	
	public LocationOperations locationOperations() {
		return locationOperations;
	}
	
	public MediaOperations mediaOperations() {
		return mediaOperations;
	}
	
	public UserOperations userOperations() {
		return userOperations;
	}
	
}
