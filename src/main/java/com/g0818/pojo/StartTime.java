package com.g0818.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartTime {
    private String id;
    private String parkingNumber;
    private String time;
}
