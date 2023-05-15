package com.mmol.mongotutor.relational.model;


import com.mmol.mongotutor.dto.Point;
import com.mmol.mongotutor.model.EventRemoteStartAttributes;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@TypeDefs({
    @TypeDef(name = "json", typeClass = JsonStringType.class),
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Table(name = "sent_events_table")
public class SentEventsTable {

    @Id
    @GeneratedValue
    @Column(name = "event_id")
    private long eventId;

    @Column(name = "event_class")
    private String eventClassId;

    @Column(name = "event_alarm")
    private boolean eventAlarm;

    @Column(name = "gps_point", columnDefinition = "jsonb")
    @Type(type="jsonb")
    private Point gpsPoint;

    @Column(name = "event_detect_timestamp")
    private LocalDateTime eventDetectTimestamp;

    @Column(name = "attributes", columnDefinition = "jsonb")
    @Type(type="jsonb")
    private EventRemoteStartAttributes attributes;

    @Column(name = "business_id")
    private String businessId;

    @Column(name = "wojewodeship")
    private String viovodeship;

}
