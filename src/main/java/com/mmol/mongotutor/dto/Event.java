package com.mmol.mongotutor.dto;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class Event {
    private Long eventId;

    private String eventClassId;

    private boolean eventAlarm;

    private Timestamp eventDetectTimestamp;

    private String attributes;

    private String businessId;

    private String viovodeship;
}
