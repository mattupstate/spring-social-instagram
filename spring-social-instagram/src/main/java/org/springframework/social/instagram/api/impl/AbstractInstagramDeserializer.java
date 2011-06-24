package org.springframework.social.instagram.api.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonDeserializer;

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
