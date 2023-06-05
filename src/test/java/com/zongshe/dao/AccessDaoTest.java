package com.zongshe.dao;

import com.zongshe.pojo.Access;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest
class AccessDaoTest {
    @Autowired
    private AccessDao accessDao;

    @Test
    public void testqueryAccess(){
        Access access = new Access();
        List<Access> accessList = accessDao.queryAccess(2);
        assertEquals(3,accessList.size());
    }

    @Test
    public void testqueryAccessCount(){
        int num = accessDao.queryAccessCount(1);
        System.out.println(num);
    }

    @Test
    public void testinsertAccess(){
        Access access = new Access();
        access.setName("张三丰");
        access.setPhone("1533522323");
        access.setAreaId(3);
        access.setCreateTime(new Date());
        access.setHealthy(1);
        int num = accessDao.insertAccess(access);
        System.out.println(access);
    }

}