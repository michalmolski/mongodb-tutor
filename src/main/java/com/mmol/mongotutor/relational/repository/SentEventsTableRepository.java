package com.mmol.mongotutor.relational.repository;

import com.mmol.mongotutor.relational.model.SentEventsTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentEventsTableRepository extends JpaRepository<SentEventsTable, Long> {
List<SentEventsTable> findByViovodeshipLike(String voivodeship);


    @Query(value = "SELECT * FROM public.sent_events_table WHERE cast(attributes->'metrics'-> 0 ->>'dist' as numeric) > :value ", nativeQuery = true)
    List<SentEventsTable> findByAttributes_Metrics_DistGreaterThan(double value);
}
