package com.protecthair.dao;

import com.protecthair.domain.User;

public interface UsersMapper {

    User selectByUniversityCode(String integer);

    Integer modifyUserMsg(User user);

    Integer setNewPassword(User updatUser);

    Integer selectTeamIdByStuId(String stuId);

}