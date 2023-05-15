package com.mmol.mongotutor.repository;

import com.mmol.mongotutor.model.SentEventTable;
import com.mmol.mongotutor.relational.model.SentEventsTable;
import com.mmol.mongotutor.relational.repository.SentEventsTableRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.List;

@SpringBootTest
@Slf4j
public class SentEventsTableRepositoryIT {
  @Autowired SentEventsTableRepository sentEventsTablePgRepository;
  @Autowired  SentEventTableRepository sentEventTableMongoRepository;

  @Test
  public void firstTest() {
    Instant start = Instant.now();
    List<SentEventsTable> eventsTables =
        sentEventsTablePgRepository.findByAttributes_Metrics_DistGreaterThan(5.0);
    long timeDiff = Instant.now().getNano() - start.getNano();
    log.info("Retreiving from postgres {{}} records took: {{}}", eventsTables.size(), timeDiff);
  }
    @Test
    public void secondTest() {
        Instant start = Instant.now();
        List<SentEventTable> eventsTables =
                sentEventTableMongoRepository.findByAttributesMetricsDistGreaterThan(5.0);
        long timeDiff = Instant.now().getNano() - start.getNano();
        log.info("Retreiving from mongo {{}} records took: {{}}", eventsTables.size(), timeDiff);
    }
}
