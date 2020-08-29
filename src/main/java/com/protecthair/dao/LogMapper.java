package com.protecthair.dao;

import com.protecthair.domain.Log;

import java.util.List;

public interface LogMapper {
    //<!--  如果有值为空，采用默认值的插入-->
    int insertSelective(Log record);
    //<!--按照log_code主键查询-->
    Log selectByPrimaryKey(Integer logCode);
    //  <!--  传入不为空的时候才更改，其他时候保留原有的默认值-->
    int updateByPrimaryKeySelective(Log record);
    //查询指定团队所有日志
    List<Log> queryTeamLog(int TeamId);


    int deleteByPrimaryKey(Integer logCode);
    int insert(Log record);
    int updateByPrimaryKeyWithBLOBs(Log record);
    int updateByPrimaryKey(Log record);
}