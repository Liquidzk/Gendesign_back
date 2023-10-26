package com.zongshe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.xml.bind.DatatypeConverter;
import java.sql.Blob;
import javax.sql.rowset.serial.SerialBlob;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Face {
    private Integer face_id;
    private Integer user_id;
    private Blob data;
    private String phone;
}
