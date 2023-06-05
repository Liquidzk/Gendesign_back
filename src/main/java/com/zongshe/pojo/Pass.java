package com.zongshe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pass {

    private Integer id;
    private Integer uid;
    private String phone;
    private String name;
    private String idnum;
    private Integer vaccine;
    private Double temperature;
    private Integer contact;
    private Integer status;

}
