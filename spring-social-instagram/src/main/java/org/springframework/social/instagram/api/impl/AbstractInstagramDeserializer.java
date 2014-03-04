package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

abstract class AbstractInstagramDeserializer<T> extends JsonDeserializer<T> {
    
	public <C> C deserializeResponseObject(JsonParser jp, Class<C> container, Class<?> containee)
            throws IOException, JsonProcessingException {
	    
	    while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jp.getCurrentName();
            jp.nextToken();
            if("meta".equals(fieldname)) {
                jp.clearCurrentToken(); // we can ignore this for now
                jp.nextToken();
            } else if("data".equals(fieldname)) {
                try {
                    return container.getConstructor(containee).newInstance(jp.readValueAs(containee));
                } catch (Exception e) {
                    
                    return null;
                }
            }
        }
        return null;
	}
	
}
