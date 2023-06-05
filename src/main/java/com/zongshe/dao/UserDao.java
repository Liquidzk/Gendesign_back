package com.zongshe.dao;

import com.zongshe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
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
}
