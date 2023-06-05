package com.zongshe.service.impl;

import com.zongshe.dao.PassDao;
import com.zongshe.pojo.Pass;
import com.zongshe.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassServiceImpl implements PassService {

    @Autowired
    private PassDao passDao;
    @Override
    public List<Pass> getPass(int uid) {
        return passDao.queryPass(uid);
    }

    @Override
    public boolean addPass(Pass pass) {
        try {
            int effectedNum = passDao.addPass(pass);
            if (effectedNum <=0){
                throw new RuntimeException("提交失败");
            }
        }catch (Exception e){
            throw new RuntimeException("addPass error"+ e.getMessage());
        }
        return true;
    }
}
