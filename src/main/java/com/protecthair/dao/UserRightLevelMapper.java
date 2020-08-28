package com.protecthair.dao;

import com.protecthair.domain.UserRightLevel;

public interface UserRightLevelMapper {
    int deleteByPrimaryKey(String rightLevel);

    int insert(UserRightLevel record);

    int insertSelective(UserRightLevel record);

    UserRightLevel selectByPrimaryKey(String rightLevel);

    int updateByPrimaryKeySelective(UserRightLevel record);

    int updateByPrimaryKey(UserRightLevel record);
}