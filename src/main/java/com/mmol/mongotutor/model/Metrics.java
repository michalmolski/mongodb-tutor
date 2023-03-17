package com.mmol.mongotutor.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Metrics {
private String metricName;
private BigDecimal metricValue;
}
