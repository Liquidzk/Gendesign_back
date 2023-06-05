package com.zongshe.dao;

import com.zongshe.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void testsaveUser(){
        User user = new User();
        user.setPhone("1123123154");
        user.setPasswd("12311");
        int num  = userDao.saveUser(user);
        System.out.println(num);
    }
    @Test
    public void testupdateUser(){
        User user = new User();
        user.setId(6);
        user.setName("张三丰");
        user.setAddress("宜昌");
        user.setIdNum("420527199906045318");
        user.setAccountNum(17130273);
        user.setTemperature(37.5);
        user.setContact(0);
        user.setStatus(0);
        user.setQrvaccine(1);
        int num = userDao.updateUser(user);
        System.out.println(num);
    }

    @Test
    public void testqueryUser(){
        String phone = "1123123154";
        User user =  userDao.queryUserInfo(phone);
        System.out.println(user);
    }

    @Test
    public void testchangepwd(){
        int num = userDao.changepwd("12312","1533522323");
        System.out.println(num);
    }

    @Test
    public void testlogin(){
        User user = new User();
        user.setPhone("1533522323");
        user.setPasswd("12312");
        int num = userDao.login(user);
        System.out.println(num);
    }
}