package com.zongshe.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zongshe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserDao extends BaseMapper<User> {
    /**
     * 查看个人信息
     * @param phone
     * @return
     */
    User queryUserInfo(String phone);

    int saveUser(User user);

    int login(User user);

    int updateUser(User user);

    int changepwd(String passwd,String phone);

    int getQrVaccine(String phone);

    @Select("select * from jat_user")
    List<User> findall();

    @Select("select * from jat_user limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize);

    @Select("select * from jat_user where id=#{id} limit #{pageNum}, #{pageSize}")
    List<User> selectPage_id(Integer pageNum, Integer pageSize, Integer id);

    @Select("select count(*) from jat_user")
    Integer selectTotal();

    @Select("select count(*) from jat_user where id=#{id}")
    Integer selectTotal_id(Integer id);
}
