package com.zongshe.web;

import com.zongshe.pojo.Message;
import com.zongshe.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/listmessage",method = RequestMethod.GET)
    public Map<String,Object> listMessage(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Message> messageList = messageService.getMessageList();
        modelMap.put("messageList",messageList);
        return modelMap;
    }

    @RequestMapping(value = "/getmessagebyid",method = RequestMethod.GET)
    public Map<String,Object> getMessageById(Integer id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Message message = messageService.getMessageById(id);
        modelMap.put("message",message);
        return modelMap;
    }
}
