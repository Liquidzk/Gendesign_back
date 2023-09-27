package com.zongshe.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String phone;
    @JsonIgnore
    private String passwd;
    private String name;
    private String idNum;
    private Integer accountNum;
    private String address;
    private Integer status;
    private Integer contact;
    private Double temperature;
    private String img;
    private Integer identity; //0为用户 1为管理员 2为超级管理员
    private Integer areaId;
    private Integer qrvaccine;

}
