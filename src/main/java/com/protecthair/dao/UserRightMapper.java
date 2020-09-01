package com.protecthair.dao;

import com.protecthair.domain.UserRight;

import java.util.List;

public interface UserRightMapper {
    int insert(UserRight record);

    int insertSelective(UserRight record);

    List<UserRight> queryUserRight();

    UserRight selectUserRight(int userId);
}