package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.instagram.api.InstagramApiException;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.util.Map;

public class InstagramErrorHandler extends DefaultResponseErrorHandler {
	
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {				
	    Map<String, Object> errorDetails = extractErrorDetailsFromResponse(response);
	    int code = Integer.valueOf(String.valueOf(errorDetails.get("code"))).intValue();
        String errorType = String.valueOf(errorDetails.get("error_type"));
        String message = String.valueOf(errorDetails.get("error_message"));
        throw new InstagramApiException(code, errorType, message);		
	}
	
	@SuppressWarnings("unchecked")
    private Map<String, Object> extractErrorDetailsFromResponse(ClientHttpResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        Map<String, Object> responseMap = mapper.<Map<String, Object>>readValue(response.getBody(), new TypeReference<Map<String, Object>>() {});
        if(responseMap.containsKey("meta")) {
            Map<String, Object> meta = (Map<String, Object>) responseMap.get("meta");
            if(Integer.valueOf(String.valueOf(meta.get("code"))).intValue() > 200) {
                return meta;
            }
        }
        return null;
    }
}
