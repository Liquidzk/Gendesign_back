package com.zongshe.service;

import com.zongshe.pojo.Message;

import java.util.List;

public interface MessageService {
    /**
     * 查询所有区域
     * @return
     */
    List<Message> getMessageList();

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    Message getMessageById(int id);
}
