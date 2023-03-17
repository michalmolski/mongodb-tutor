package com.mmol.mongotutor.service;

import com.mmol.mongotutor.dto.Event;
import com.mmol.mongotutor.mapper.SentEventMapper;
import com.mmol.mongotutor.repository.SentEventTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService {
private final SentEventTableRepository sentEventTableRepository;
private final SentEventMapper eventMapper;
    public void saveEvent(Event event) {
        sentEventTableRepository.save(eventMapper.map(event));
    }
}
