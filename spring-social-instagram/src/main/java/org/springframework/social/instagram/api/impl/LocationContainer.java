package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.springframework.social.instagram.api.Location;

import java.io.IOException;

@JsonDeserialize(using=LocationContainer.LocationContainerDeseriazlier.class)
public class LocationContainer extends AbstractInstagramResponseContainer<Location> {

    public static class LocationContainerDeseriazlier extends AbstractInstagramDeserializer<LocationContainer> {
        @Override 
        public LocationContainer deserialize(JsonParser jp, DeserializationContext ctxt) 
                throws IOException, JsonProcessingException {
            return deserializeResponseObject(jp, LocationContainer.class, Location.class);
        }
    }
    
    public LocationContainer(Location location) {
        super(location);
    }
}
