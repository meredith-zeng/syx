package com.protecthair.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by liuquan
 * @Classname RedisUser
 * @Description TODO
 * @Date 2020/8/19 22:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionUser {
    private User user;
    private UserRight userRight;
}
