package com.protecthair.dao;

import com.protecthair.domain.UserRight;

public interface UserRightMapper {
    int insert(UserRight record);

    int insertSelective(UserRight record);

    UserRight selectUserRight(Integer userId);

    int insertUserRightWithUsers (Integer userId);
}