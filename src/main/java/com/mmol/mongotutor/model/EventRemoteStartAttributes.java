package com.mmol.mongotutor.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventRemoteStartAttributes {

    @JsonAlias({"prev_latitude"})
    private BigDecimal prevLatitude;

    @JsonAlias({"prev_longitude"})
    private BigDecimal prevLongitude;

    @JsonAlias({"prev_time"})
    private Long prevDate;

    @JsonAlias({"metrics"})
    private List<Metrics> metrics;
}
