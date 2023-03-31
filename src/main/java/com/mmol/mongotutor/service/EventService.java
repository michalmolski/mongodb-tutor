package com.mmol.mongotutor.service;

import com.mmol.mongotutor.dto.Event;
import com.mmol.mongotutor.mapper.EventMapper;
import com.mmol.mongotutor.mapper.SentEventMapper;
import com.mmol.mongotutor.model.SentEventTable;
import com.mmol.mongotutor.repository.SentEventTableRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService {
  private final SentEventTableRepository sentEventTableRepository;
  private final EventMapper eventMapper;

  public void saveEvent(Event event) {
    sentEventTableRepository.save(eventMapper.map(event));
  }

  public SentEventTable getEvent(Long eventId) {
    Optional<SentEventTable> persistedEvent =
        sentEventTableRepository.findSentEventTableByEventId(eventId);
    persistedEvent.orElseThrow(RuntimeException::new);
    return persistedEvent.get();
  }
}
