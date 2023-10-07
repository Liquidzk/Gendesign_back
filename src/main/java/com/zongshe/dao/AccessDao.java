package com.zongshe.dao;

import com.zongshe.pojo.Access;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface AccessDao {
    int queryAccessCount(int areaId);

    int insertAccess(Access access);

    List<Access> queryAccess(int areaId);

    List<Access> queryAccessByDate(Date startTime,Date endTime);

    List<Access> queryAccessByphone(String phone);
}
