package com.mmol.mongotutor.model;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("sentevents")
@Data
public class SentEventTable {
    @Id
    private Long eventId;

    private String eventClassId;

    private boolean eventAlarm;

    private LocalDateTime eventDetectTimestamp;

    private EventRemoteStartAttributes attributes;

    private String businessId;

    private String viovodeship;
}
