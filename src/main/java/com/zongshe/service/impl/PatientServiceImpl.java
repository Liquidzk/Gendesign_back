package com.zongshe.service.impl;

import com.zongshe.dao.PatientDao;
import com.zongshe.pojo.Patient;
import com.zongshe.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;
    @Override
    public List<Patient> getPatientList() {
        List<Patient> patientList = patientDao.queryPatientList();
        return patientList;
    }

    @Override
    public int getPatientCountByPstatus(int Pstatus) {
        int num = patientDao.queryPatientCountByPstatus(Pstatus);
        return num;
    }

    @Override
    public int getPatientCount(int Pstatus) {
        int num1 = patientDao.queryPatientCount(Pstatus);
        return num1;
    }
}
