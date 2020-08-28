package com.protecthair.dao;

import com.protecthair.domain.Log;

public interface LogMapper {
    int deleteByPrimaryKey(Integer logCode);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer logCode);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKeyWithBLOBs(Log record);

    int updateByPrimaryKey(Log record);
}