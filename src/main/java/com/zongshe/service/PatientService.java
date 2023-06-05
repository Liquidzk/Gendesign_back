package com.zongshe.service;

import com.zongshe.pojo.Patient;

import java.util.List;

public interface PatientService {
    /**
     * 查询
     * @return
     */
    List<Patient> getPatientList();

    int getPatientCountByPstatus(int Pstatus);

    int getPatientCount(int Pstatus);
}
