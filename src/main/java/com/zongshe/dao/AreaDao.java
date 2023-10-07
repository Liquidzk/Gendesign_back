package com.zongshe.dao;

import com.zongshe.pojo.Area;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AreaDao {
    /**
     * 列出区域列表
     * @return
     */
    List<Area> queryArea();

    /**
     * 根据Id查询区域
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);
}
