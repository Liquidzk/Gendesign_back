package com.zongshe.service;

import com.zongshe.pojo.Report;

public interface ReportService {
    /**
     * 添加匿名举报信息
     * @param report
     * @return
     */
    boolean addReport(Report report);
}
