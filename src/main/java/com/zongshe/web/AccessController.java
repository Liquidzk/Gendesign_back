package com.zongshe.web;

import com.zongshe.pojo.Access;
import com.zongshe.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AccessController {
    @Autowired
    private AccessService accessService;

    @PostMapping(value = "/addaccess")
    private Map<String,Object> addAccess(@RequestBody Access access){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        access.setCreateTime(new Date());
        System.out.println(access);
        modelMap.put("success",accessService.addAccess(access));
        return modelMap;
    }

    @GetMapping(value = "/getaccesscount")
    public Map<String,Object> getAccessCount(int areaId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        int num = accessService.getAccessCount(areaId);
        modelMap.put("success",num);
        return modelMap;
    }

    @GetMapping(value = "/getaccess")
    public Map<String,Object> getAccess(int areaId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Access> accessList = accessService.getAccessList(areaId);
        modelMap.put("accesslist",accessList);
        return modelMap;
    }

    @GetMapping(value = "/getaccessbyphone")
    public Map<String,Object> getAccessbyphone(String phone){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Access> accessList = accessService.getAccessListByPhone(phone);
        modelMap.put("accesslist",accessList);
        return modelMap;
    }
}
