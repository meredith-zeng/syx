package com.protecthair.dao;

import com.protecthair.domain.User;
import com.protecthair.domain.Users;

public interface UsersMapper {

    User selectByUniversityCode(String integer);

    Integer modifyUserMsg(User user);

    Integer setNewPassword(User updatUser);

    Integer selectTeamIdByStuId(String stuId);

}