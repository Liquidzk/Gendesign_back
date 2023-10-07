package com.zongshe.dao;

import com.zongshe.pojo.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientDao {
    /**
     * 查询患者信息
     * @return
     */
    List<Patient> queryPatientList();

    int queryPatientCountByPstatus(int Pstatus);

    int queryPatientCount(int Pstatus);
}
