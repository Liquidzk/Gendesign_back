package com.zongshe.service.impl;

import com.zongshe.dao.AccessDao;
import com.zongshe.pojo.Access;
import com.zongshe.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessServiceImpl implements AccessService {
    @Autowired
    private AccessDao accessDao;
    @Override
    public boolean addAccess(Access access) {
        try{
            int effectedNum = accessDao.insertAccess(access);
            if (effectedNum <=0){
                throw new RuntimeException("提交失败");
            }
        }catch (Exception e){
            throw new RuntimeException("addAccess error"+ e.getMessage());
        }
        return true;
    }

    @Override
    public int getAccessCount(int areaId) {
        int num = accessDao.queryAccessCount(areaId);
        return num;
    }

    @Override
    public List<Access> getAccessList(int areaId) {
        return accessDao.queryAccess(areaId);
    }

    @Override
    public List<Access> getAccessListByPhone(String phone) {
        return accessDao.queryAccessByphone(phone);
    }
}
