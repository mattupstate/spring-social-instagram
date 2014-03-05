package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.springframework.social.instagram.api.Relationship.IncomingStatus;
import org.springframework.social.instagram.api.Relationship.OutgoingStatus;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RelationshipMixin {
    @JsonCreator
    RelationshipMixin(
            @JsonProperty("outgoing_status") @JsonDeserialize(using=OutgoingDeserializer.class) OutgoingStatus outgoingStatus,
            @JsonProperty("incoming_status") @JsonDeserialize(using=IncomingDeserializer.class) IncomingStatus incomingStatus) {}
    
    private static class OutgoingDeserializer extends JsonDeserializer<OutgoingStatus> {
        @Override
        public OutgoingStatus deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            return OutgoingStatus.valueOf(jp.getText().toUpperCase());
        }   
    }
    
    private static class IncomingDeserializer extends JsonDeserializer<IncomingStatus> {
        @Override
        public IncomingStatus deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            return IncomingStatus.valueOf(jp.getText().toUpperCase());
        }   
    }
}
