package com.mmol.mongotutor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metrics {
private BigDecimal dist;
private BigDecimal timediff;
}
