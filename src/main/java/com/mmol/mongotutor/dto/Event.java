package com.mmol.mongotutor.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import com.mongodb.client.model.geojson.Point;

@Data
public class Event implements Serializable {
    private String eventId;

    private String eventClassId;

    private boolean eventAlarm;

    private LocalDateTime eventDetectTimestamp;

    private String attributes;

    private String businessId;

    private String viovodeship;

    private Point gpsPoint;
}
