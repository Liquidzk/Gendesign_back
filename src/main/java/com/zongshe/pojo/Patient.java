package com.zongshe.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private Integer id;
    private Integer Pstatus;
    private String Paddress;
    private Date Ptime;
    private Double Platitude;
    private Double Plongitude;
}
