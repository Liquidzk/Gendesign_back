package com.zongshe.dao;

import com.zongshe.pojo.Report;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReportDao {
    /**
     * 提交匿名举报
     * @param report
     * @return
     */
    int insertReport(Report report);
}
