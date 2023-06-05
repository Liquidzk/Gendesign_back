package com.zongshe.dao;

import com.zongshe.pojo.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest
class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea(){
        Area area = new Area();
        List<Area> areaList = areaDao.queryArea();
        assertEquals(8,areaList.size());
    }

    @Test
    public void queryAreaById(){
        Area area = areaDao.queryAreaById(1);
        assertEquals("东区食堂",area.getAreaName());
    }
}