package com.mmol.mongotutor.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@Builder
public class Point implements Serializable {
    private double lattitude;
    private double longitude;
}
