package com.mmol.mongotutor.repository;

import com.mmol.mongotutor.model.SentEventTable;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface SentEventTableRepository extends MongoRepository<SentEventTable, Long> {

    @Query("{ 'eventId' : ?0 }")
    Optional<SentEventTable> findSentEventTableByEventId(Long eventId);

    List<SentEventTable> findByViovodeshipLike(String voivodeship);

    @Query(value = "{ 'attributes.metrics.0.dist': { $gt: ?0 } }")
    List<SentEventTable> findByAttributesMetricsDistGreaterThan(double value);



}
