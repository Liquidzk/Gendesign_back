package com.zongshe.service.impl;

import com.zongshe.dao.MessageDao;
import com.zongshe.pojo.Message;
import com.zongshe.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public List<Message> getMessageList() {
        return messageDao.queryMessage();
    }

    @Override
    public Message getMessageById(int id) {
        return messageDao.queryMessageById(id);
    }
}
