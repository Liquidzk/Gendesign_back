package com.zongshe.service.impl;

import com.zongshe.dao.ReportDao;
import com.zongshe.pojo.Report;
import com.zongshe.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportDao reportDao;
    @Transactional
    @Override
    public boolean addReport(Report report) {
        try {
            int effectedNum = reportDao.insertReport(report);
            if (effectedNum <=0){
                throw new RuntimeException("提交失败");
            }
        }catch (Exception e){
            throw new RuntimeException("addReport error"+ e.getMessage());
        }
        return true;
    }
}
