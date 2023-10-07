package com.zongshe.dao;

import com.zongshe.pojo.Pass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PassDao {

    List<Pass> queryPass(int uid);

    int addPass(Pass pass);
}
