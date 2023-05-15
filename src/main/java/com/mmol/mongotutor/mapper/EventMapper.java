package com.mmol.mongotutor.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmol.mongotutor.dto.Event;
import com.mmol.mongotutor.model.EventRemoteStartAttributes;
import com.mmol.mongotutor.model.SentEventTable;
import com.mmol.mongotutor.service.attributes.AttributesSupplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventMapper {
    private final AttributesSupplier attributesSupplier;

    private final ObjectMapper objectMapper;


    public SentEventTable map(Event event){
        EventRemoteStartAttributes attributes = attributesSupplier.getAttributes(event, EventRemoteStartAttributes.class);
        SentEventTable sentEvent = SentEventMapper.INSTANCE.map(event);
        sentEvent.setAttributes(attributes);
        sentEvent.setGpsPoint(event.getGpsPoint());
        return sentEvent;
    }


    public Event map(SentEventTable sentEventTable){
        String attributes = sentEventTable.getAttributes().toString();
        Event event = SentEventMapper.INSTANCE.map(sentEventTable);
        event.setAttributes(attributes);
        return event;
    }

}
