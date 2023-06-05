package com.zongshe.service;

import com.zongshe.pojo.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAreaList();
    /**
     * 根据areaId查询区域
     * @param areaId
     * @return
     */
    Area getAreaById(int areaId);
}
