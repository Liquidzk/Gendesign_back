package com.zongshe.web;

import com.zongshe.pojo.Pass;
import com.zongshe.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PassController {
    @Autowired
    private PassService passService;

    @RequestMapping(value = "/queryPass" ,method = RequestMethod.GET)
    public Map<String,Object> queryPass(Integer uid){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Pass> passList = passService.getPass(uid);
        modelMap.put("passList",passList);
        return modelMap;
    }

    @PostMapping(value = "/addPass")
    private Map<String,Object> addPass(@RequestBody Pass pass){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",passService.addPass(pass));
        return modelMap;
    }
}
