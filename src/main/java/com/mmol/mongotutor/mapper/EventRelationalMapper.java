package com.mmol.mongotutor.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmol.mongotutor.dto.Event;
import com.mmol.mongotutor.dto.Point;
import com.mmol.mongotutor.model.EventRemoteStartAttributes;
import com.mmol.mongotutor.model.SentEventTable;
import com.mmol.mongotutor.relational.model.SentEventsTable;
import com.mmol.mongotutor.service.attributes.AttributesSupplier;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.io.ByteOrderValues;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventRelationalMapper {
    private final AttributesSupplier attributesSupplier;
    private final ObjectMapper objectMapper;
    private GeometryFactory geometryFactory = new GeometryFactory();

  public SentEventsTable map(Event event) {
    SentEventsTable sentEvent = SentEventRelationalMapper.INSTANCE.map(event);

    EventRemoteStartAttributes attributes = attributesSupplier.getAttributes(event, EventRemoteStartAttributes.class);
//      Point point = geometryFactory.createPoint(
//              new Coordinate(
//                      event.getGpsPoint().getCoordinates().getValues().get(0),
//                      event.getGpsPoint().getCoordinates().getValues().get(1)));
//      point.setSRID(4326);
//      point.setUserData(ByteOrderValues.BIG_ENDIAN);
      Point point = Point.builder().lattitude(event.getGpsPoint().getCoordinates().getValues().get(0))
              .longitude(event.getGpsPoint().getCoordinates().getValues().get(1)).build();
    sentEvent.setGpsPoint(point);
    sentEvent.setAttributes(attributes);
    return sentEvent;
  }

    public Event map(SentEventTable sentEventTable){
        String attributes = sentEventTable.getAttributes().toString();
        Event event = SentEventMapper.INSTANCE.map(sentEventTable);
        event.setAttributes(attributes);
        return event;
    }

}
