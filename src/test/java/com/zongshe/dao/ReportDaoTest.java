package com.zongshe.dao;

import com.zongshe.pojo.Report;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReportDaoTest {
    @Autowired
    private ReportDao reportDao;
    @Test
    public void insertReport(){
        Report report = new Report();
        report.setContent("先帝创业未半而中道崩殂，今天下三分，益州疲弊，此诚危急存亡之秋也。然侍卫之臣不懈于内，忠志之士忘身于外者，盖追先帝之殊遇，欲报之于陛下也。诚宜开张圣听，以光先帝遗德，恢弘志士之气，不宜妄自菲薄，引喻失义，以塞忠谏之路也。 ");
        report.setRepTime(new Date());
        int effectedNum = reportDao.insertReport(report);
        assertEquals(1,effectedNum);
    }
}