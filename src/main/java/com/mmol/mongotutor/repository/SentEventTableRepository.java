package com.mmol.mongotutor.repository;

import com.mmol.mongotutor.model.SentEventTable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface SentEventTableRepository extends MongoRepository<SentEventTable, Long> {

    @Query("{eventId:'?0'}")
    SentEventTable findSentEventTableByEventId(Long eventId);

}
