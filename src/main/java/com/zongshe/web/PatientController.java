package com.zongshe.web;

import com.zongshe.dto.PatientExecution;
import com.zongshe.pojo.Patient;
import com.zongshe.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/listpatient",method = RequestMethod.GET)
    public Map<String,Object> listPatient(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Patient> patientList = patientService.getPatientList();
        modelMap.put("patientList",patientList);
        return modelMap;
    }

    @GetMapping(value = "/getpatientcountbystatus")
    public Map<String,Object> getPatientCountByStatus(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        int Qnum = patientService.getPatientCountByPstatus(0);
        int Wnum = patientService.getPatientCountByPstatus(1);
        int Ynum = patientService.getPatientCountByPstatus(2);
        int Mnum = patientService.getPatientCountByPstatus(3);
        PatientExecution patientExecution = new PatientExecution();
        patientExecution.setQnum(Qnum);
        patientExecution.setWnum(Wnum);
        patientExecution.setYnum(Ynum);
        patientExecution.setMnum(Mnum);
        modelMap.put("patientExecution",patientExecution);
        return modelMap;
    }

    @GetMapping(value = "getpatientcount")
    public Map<String,Object> getPatientCount(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        int qnum = patientService.getPatientCount(0);
        int wnum = patientService.getPatientCount(1);
        int ynum = patientService.getPatientCount(2);
        int mnum = patientService.getPatientCount(3);
        PatientExecution pe = new PatientExecution();
        pe.setQnum(qnum);
        pe.setWnum(wnum);
        pe.setYnum(ynum);
        pe.setMnum(mnum);
        modelMap.put("pe",pe);
        return modelMap;
    }

}
