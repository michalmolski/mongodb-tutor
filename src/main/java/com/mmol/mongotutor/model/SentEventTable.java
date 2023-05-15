package com.mmol.mongotutor.model;

import com.mongodb.client.model.geojson.Point;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("sentevents")
@Data
public class SentEventTable {
    @Id
    private String eventId;

    private String eventClassId;

    private boolean eventAlarm;

    private LocalDateTime eventDetectTimestamp;

    private EventRemoteStartAttributes attributes;

    private String businessId;

    private String viovodeship;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2D)
    private Point gpsPoint;
}
