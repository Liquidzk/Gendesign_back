package com.zongshe.service;

import com.zongshe.pojo.Access;

import java.util.List;

public interface AccessService {
    boolean addAccess(Access access);

    int getAccessCount(int areaId);

    List<Access> getAccessList(int areaId);

    List<Access> getAccessListByPhone(String phone);

//    List<Access> getAccessListByDate(Date startTime,Date endTime);
}
