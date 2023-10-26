package com.zongshe.dao;

import com.zongshe.pojo.Face;
import com.zongshe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.List;

@Repository
@Mapper
public interface FaceDao {
    @Select("insert into jat_face values (#{user_id}, #{data}, #{phone}) ")
    List<Face> insert_face(Integer user_id , Blob data,String phone);
}
