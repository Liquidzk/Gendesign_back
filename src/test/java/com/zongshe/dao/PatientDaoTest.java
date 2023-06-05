package com.zongshe.dao;

import com.zongshe.pojo.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PatientDaoTest {
    @Autowired
    private PatientDao patientDao;
    @Test
    public void testQueryPatientList(){
        Patient patient = new Patient();
        List<Patient> patientList = patientDao.queryPatientList();
        assertEquals(4,patientList.size());
    }
    @Test
    public void testQueryPatientCountByPstatus(){
        int num = patientDao.queryPatientCountByPstatus(1);
        System.out.println(num);
    }
    @Test
    public void testQueryPatientCount(){
        int num = patientDao.queryPatientCount(3);
        System.out.println(num);
    }
}