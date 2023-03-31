package com.mmol.mongotutor.service.attributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmol.mongotutor.dto.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AttributesSupplier {
    ObjectMapper mapper = new ObjectMapper();


    public <T> T getAttributes(Event sentEvent, final Class<T> eventAttributesClass) {
        T attributes;
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
        String rawAttributes =
            sentEvent
                .getAttributes()
                .substring(1, sentEvent.getAttributes().length() - 1)
                .replaceAll("\\\\", "");

        try {
            attributes = mapper.readValue(rawAttributes, eventAttributesClass);
        } catch (JsonProcessingException e) {
            log.error("Bad attributes in sent event!: " + rawAttributes + e.getMessage());
            throw new RuntimeException("Bad attributes in sent event!: " + rawAttributes);
        }
        return attributes;
    }
}
