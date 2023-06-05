package com.zongshe.service;

import com.zongshe.pojo.Pass;

import java.util.List;

public interface PassService {
    List<Pass> getPass(int uid);

    boolean addPass(Pass pass);
}
