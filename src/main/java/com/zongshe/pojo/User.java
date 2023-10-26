package com.zongshe.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "jat_user")
public class User {

    @TableId("id")
    private Integer id;
    private String phone;
    private String passwd;
    @JsonIgnore
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
