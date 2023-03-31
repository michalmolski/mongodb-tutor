package com.mmol.mongotutor.mapper;

import com.mmol.mongotutor.dto.Event;
import com.mmol.mongotutor.model.SentEventTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
// TODO: write custom mapper impl to map json attributes
@Mapper
public interface SentEventMapper {
  SentEventMapper INSTANCE = Mappers.getMapper(SentEventMapper.class);

  @Mapping(target = "attributes", ignore = true)
  SentEventTable map(Event event);

  @Mapping(target = "attributes", ignore = true)
  Event map(SentEventTable sentEventTable);
}
