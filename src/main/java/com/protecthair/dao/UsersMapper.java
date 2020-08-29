package com.protecthair.dao;

import com.protecthair.domain.User;

public interface UsersMapper {
    int insert(User record);

    int insertSelective(User record);
}