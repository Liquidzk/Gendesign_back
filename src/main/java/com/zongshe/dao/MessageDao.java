package com.zongshe.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.zongshe.pojo.Message;

import java.util.List;


@Repository
public interface MessageDao {

    /**
     * 列出所有通知
     * @return
     */
    List<Message> queryMessage();

    /**
     * 根据Id查询信息
     * @param id
     * @return
     */
    Message queryMessageById(int id);
}
