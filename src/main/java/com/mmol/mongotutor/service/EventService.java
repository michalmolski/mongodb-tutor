package com.mmol.mongotutor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmol.mongotutor.dto.Event;
import com.mmol.mongotutor.mapper.EventMapper;
import com.mmol.mongotutor.mapper.EventRelationalMapper;
import com.mmol.mongotutor.model.SentEventTable;
import com.mmol.mongotutor.relational.model.SentEventsTable;
import com.mmol.mongotutor.relational.repository.SentEventsTableRepository;
import com.mmol.mongotutor.repository.SentEventTableRepository;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.rmi.server.LogStream.log;

@Service
@AllArgsConstructor
@Slf4j
public class EventService {
  private final SentEventTableRepository sentEventTableMongoRepository;
  private final SentEventsTableRepository sentEventsTablePgRepository;
  private final EventMapper eventMapper;
  private final EventRelationalMapper eventRelationalMapper;
  private final ObjectMapper mapper;

  private static Map<Integer, String> voivodeMap = new HashMap<>();
 static  {
   {{
     voivodeMap.put(0, "mazowieckie");
     voivodeMap.put(1, "zachodniopomorskie");
     voivodeMap.put(2, "podkarpackie");
     voivodeMap.put(3, "podlaskie");
   }};
  }

  public void saveEvent(Event event) {
    sentEventTableMongoRepository.save(eventMapper.map(event));
  }

  public String saveRandomEvents(int numberEventsToSave){
    Random random = new Random();
    Event eventFromSource = new Event();
    try {
      eventFromSource =
          mapper.readValue(
              new File("src\\main\\resources\\data\\exampleJsonToSave.json"), Event.class);
    } catch (IOException e) {
      e.printStackTrace();
    }


    List<SentEventTable> objectsToSave = new ArrayList<>();
    List<SentEventsTable> objectsPgToSave = new ArrayList<>();
    for (int i=0; i<=numberEventsToSave; i++){

      if(i != 0 || (i%100 == 0)){
        sentEventTableMongoRepository.saveAll(objectsToSave);
        sentEventsTablePgRepository.saveAll(objectsPgToSave);
        objectsToSave = new ArrayList<>();
        objectsPgToSave = new ArrayList<>();
      }
      SentEventTable eventToSave = eventMapper.map(eventFromSource);
      SentEventsTable eventsTableObjPg = eventRelationalMapper.map(eventFromSource);
      String viovodeship = voivodeMap.get(random.nextInt(voivodeMap.size()));
      eventToSave.setViovodeship(viovodeship);

      eventToSave.setEventDetectTimestamp(eventToSave.getEventDetectTimestamp().minusHours(1));

      eventsTableObjPg.setViovodeship(viovodeship);

      objectsToSave.add(eventToSave);
      objectsPgToSave.add(eventsTableObjPg);
//      sentEventsTableRepository.save(eventsTableObjPg);
    }
return "Saved: "+ numberEventsToSave + " events";
  }

  public SentEventTable getEvent(Long eventId) {
    Optional<SentEventTable> persistedEvent =
        sentEventTableMongoRepository.findSentEventTableByEventId(eventId);
    persistedEvent.orElseThrow(RuntimeException::new);
    return persistedEvent.get();
  }

  public void getEventByVoivodeMongo(String voivodeship) {
    Instant start = Instant.now();
   List<SentEventTable>
           eventTables = sentEventTableMongoRepository.findByViovodeshipLike(voivodeship);
   int timeDiff = Instant.now().getNano()-start.getNano();
   log.info("Retreiving from mongo {{}} records took: {{}}",eventTables.size(), timeDiff);

  }

  public void getEventByVoivodePg(String voivodeship) {
    Instant start = Instant.now();
    List<SentEventsTable>  eventsTables = sentEventsTablePgRepository.findByViovodeshipLike(voivodeship);
    int timeDiff = Instant.now().getNano()-start.getNano();
    log.info("Retreiving from postgres {{}} records took: {{}}",eventsTables.size(), timeDiff);
  }
}
