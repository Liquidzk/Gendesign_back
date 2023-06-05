package com.zongshe.dao;

import com.zongshe.pojo.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest
class MessageDaoTest {

    @Autowired
    private MessageDao messageDao;

    @Test
    public void queryMessage(){
        Message message = new Message();
        List<Message> messageList = messageDao.queryMessage();
        assertEquals(2,messageList.size());
    }
    @Test
    public void queryMessageById(){
        Message message = messageDao.queryMessageById(1);
        System.out.println(message.getInfoSource());
    }
}