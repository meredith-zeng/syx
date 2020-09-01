package com.protecthair.dao;

import com.protecthair.domain.Users;

public interface UsersMapper {
    int insert(Users record);

    int insertSelective(Users record);
}