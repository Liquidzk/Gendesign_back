package com.zongshe.service.impl;

import com.zongshe.dao.UserDao;
import com.zongshe.pojo.User;
import com.zongshe.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao
            ;
    @Transactional
    @Override
    public boolean addUser(User user) {
        try {
            int effectedNum = userDao.saveUser(user);
            if (effectedNum <=0){
                throw new RuntimeException("提交失败");
            }
        }catch (Exception e){
            throw new RuntimeException("addUser error"+ e.getMessage());
        }
        return true;
    }

    @Transactional
    @Override
    public boolean login(User user) {
        int userId = userDao.login(user);
        try{
            if (userId <= 0){
                throw new RuntimeException("用户账号密码不正确");
            }
        }catch (Exception e){
            throw new RuntimeException("login error"+e.getMessage());
        }
        return true;
    }

    @Override
    public boolean modifyUser(User user) {
        if (user != null){
            try{
                int num = userDao.updateUser(user);
                if (num <= 0){
                    throw new RuntimeException("更新信息失败");
                }
                return true;
            }catch (Exception e){
                throw new RuntimeException("更新信息失败"+e.toString());
            }
        }else {
            return false;
        }
    }

    @Override
    public User getUser(String phone) {
        return userDao.queryUserInfo(phone);
    }

    @Override
    public boolean changePasswd(String phone, String newpasswd, String passwd) {
        User user = new User();
        user.setPhone(phone);
        user.setPasswd(passwd);
        int user1= userDao.login(user);
        if (user1<=0){
            return false;
        }else{
            if (newpasswd !=null){
                userDao.changepwd(newpasswd,phone);
                return true;
            }
            return false;
        }
    }

    @Override
    public Integer getQrVaccine(String phone) {
        return userDao.getQrVaccine(phone);

    }


}
