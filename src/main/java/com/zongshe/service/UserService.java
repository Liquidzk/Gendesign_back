package com.zongshe.service;


import com.zongshe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {

    User getUser(String phone);

    boolean addUser(User user);

    boolean login(User user);

    boolean modifyUser(User user);

    boolean changePasswd(String phone,String newpasswd,String passwd);

    Integer getQrVaccine(String phone);


}
