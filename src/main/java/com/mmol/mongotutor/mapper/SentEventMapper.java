package com.mmol.mongotutor.mapper;

import com.mmol.mongotutor.dto.Event;
import com.mmol.mongotutor.model.SentEventTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
//TODO: write custom mapper impl to map json attributes
@Mapper
public interface SentEventMapper {
    SentEventMapper INSTANCE = Mappers.getMapper(SentEventMapper.class);

    SentEventTable map(Event event);

    Event map(SentEventTable sentEventTable);
}
