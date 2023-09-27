package com.zongshe.web;

import com.zongshe.mapper.UserMapper;
import com.zongshe.pojo.User;
import com.zongshe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    StringRedisTemplate redisTemplate;

    @PostMapping(value = "/adduser")
    private Map<String,Object> addUser(String phoneNumber, String password, String code){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String redisCode = redisTemplate.opsForValue().get("sms:code:"+ phoneNumber);
        if (redisCode == null || redisCode.equals("")){
            modelMap.put("error",1);
        }
        User user = new User();
        user.setPhone(phoneNumber);
        user.setPasswd(password);
        if (!code.equals(redisCode)) {
            modelMap.put("error",1);
            return modelMap;
        }else {
            //如果验证成功就删除验证码
            redisTemplate.delete("sms:code:"+ phoneNumber);
            modelMap.put("success",userService.addUser(user));
            return modelMap;
        }
    }

    @PostMapping(value = "/login")
    private Map<String,Object> login(@RequestBody User user){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String phone = user.getPhone();
        System.out.println(phone);
        User user1 = userService.getUser(phone);
        System.out.println(user1);
        modelMap.put("user",user1);
        modelMap.put("success",userService.login(user));
        return modelMap;
    }

    @PostMapping(value = "/modifyuser")
    private Map<String,Object> modifyUser(@RequestBody User user){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        int qrvaccine = user.getQrvaccine();
        System.out.println(qrvaccine);
        modelMap.put("success",userService.modifyUser(user));
        return modelMap;
    }

    @RequestMapping(value = "/queryuser",method = RequestMethod.GET)
    private Map<String,Object> queryUser(String phone){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        User user = userService.getUser(phone);
        System.out.println(user);
        modelMap.put("user",user);
        return modelMap;
    }

    @PostMapping(value = "/changepwd")
    private Map<String,Object> changePwd(String phone, String newpasswd, String passwd){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        System.out.println(passwd);
        System.out.println(phone);
        System.out.println(newpasswd);
        modelMap.put("success",userService.changePasswd(phone, newpasswd, passwd));
        return modelMap;
    }

    @PostMapping(value = "/qrVaccine")
    private Map<String,Object> qrVaccine(String phone){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        System.out.println(phone);
        modelMap.put("qrVaccine",userService.getQrVaccine(phone));
        return modelMap;
    }

    @GetMapping("/userlist")
    public List<User> userList() {
        return userMapper.findall();
    }

    @GetMapping("/userpage")
    public Map<String, Object> userPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer id) {
        pageNum = (pageNum - 1) * pageSize;
        List<User>data = userMapper.selectPage(pageNum, pageSize, id);
        Integer total =  userMapper.selectTotal();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

}
