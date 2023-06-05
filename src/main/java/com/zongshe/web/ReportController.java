package com.zongshe.web;

import com.zongshe.pojo.Report;
import com.zongshe.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @PostMapping(value = "/addreport")
    private Map<String,Object>addReport(@RequestBody Report report){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",reportService.addReport(report));
        return modelMap;
    }

}
