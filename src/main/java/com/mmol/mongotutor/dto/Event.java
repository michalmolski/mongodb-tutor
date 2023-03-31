package com.mmol.mongotutor.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Event {
    private Long eventId;

    private String eventClassId;

    private boolean eventAlarm;

    private LocalDateTime eventDetectTimestamp;

    private String attributes;

    private String businessId;

    private String viovodeship;
}
