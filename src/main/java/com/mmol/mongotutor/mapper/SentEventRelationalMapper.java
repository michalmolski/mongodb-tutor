package com.mmol.mongotutor.mapper;

import com.mmol.mongotutor.dto.Event;

import com.mmol.mongotutor.relational.model.SentEventsTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SentEventRelationalMapper {
  SentEventRelationalMapper INSTANCE = Mappers.getMapper(SentEventRelationalMapper.class);

  @Mapping(target = "gpsPoint", ignore = true)
  @Mapping(target = "attributes", ignore = true)
  SentEventsTable map(Event event);

  @Mapping(target = "attributes", ignore = true)
  @Mapping(target = "gpsPoint", ignore = true)
  Event map(SentEventsTable sentEventTable);
}
