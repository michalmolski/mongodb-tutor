package com.mmol.mongotutor.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventRemoteStartAttributes implements Serializable {

    @JsonAlias({"prev_latitude"})
    private BigDecimal prevLatitude;

    @JsonAlias({"prev_longitude"})
    private BigDecimal prevLongitude;

    @JsonAlias({"prev_time"})
    private Long prevDate;

    @JsonAlias({"metrics"})
    private List<Metrics> metrics;
}
