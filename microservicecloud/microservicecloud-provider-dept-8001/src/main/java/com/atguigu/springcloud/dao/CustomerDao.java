package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.deptDo;

public interface CustomerDao {
    int insert(deptDo record);

    int insertSelective(deptDo record);
}