package org.springframework.social.instagram.api.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.instagram.api.Relationship.IncomingStatus;
import org.springframework.social.instagram.api.Relationship.OutgoingStatus;

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
