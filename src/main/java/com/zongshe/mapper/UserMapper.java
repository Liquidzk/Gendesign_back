package com.zongshe.mapper;

import com.zongshe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from jat_user")
    List<User> findall();

    @Select("select * from jat_user where id={id} limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize, Integer id);

    @Select("select count(*) from jat_user where id={id}")
    Integer selectTotal();
}
