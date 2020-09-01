package com.protecthair.services.impl;

import com.protecthair.VO.LoginVo;
import com.protecthair.VO.ModifyPasswordVO;
import com.protecthair.VO.ModifyVO;
import com.protecthair.dao.UserRightMapper;
import com.protecthair.dao.UsersMapper;
import com.protecthair.domain.SessionUser;
import com.protecthair.domain.User;
import com.protecthair.domain.UserRight;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Constant;
import com.protecthair.result.Result;
import com.protecthair.services.UserServices;
import com.protecthair.util.AliyunSmsUtils;
import com.protecthair.util.MD5Util;
import com.protecthair.util.SessionUtil;
import com.protecthair.util.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author by liuquan
 * @Classname UserServicesImpl
 * @Description TODO
 * @Date 2020/8/29 14:29
 */
@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    UserRightMapper userRightMapper;

    @Override
    public Result login(LoginVo loginVo) {
        String universityCode = loginVo.getUniversityCode();
        String passWord = loginVo.getUserPassword();
        //通过统一验证码查询用户
        User loginUser = usersMapper.selectByUniversityCode(universityCode);
        if (loginUser == null) {
            //不存在该用户
            return Result.CodeMsg(CodeMsg.USERNAME_NOTEXIST);
        } else {
            //MD5加盐验证
            String dataBaseMD5 = loginUser.getUserPassword();
            String MD5Password = MD5Util.md5(passWord + loginUser.getUserSalt());
            if (!MD5Password.equals(dataBaseMD5)) {
                //密码错误
                return Result.CodeMsg(CodeMsg.PASSWORD_ERROR);
            } else {
                //用户权限和团队id
                UserRight userRight = userRightMapper.selectUserRight(loginUser.getUserId());
                Integer teamId = usersMapper.selectTeamIdByStuId(loginUser.getUniversityCode());
                SessionUser sessionUser = new SessionUser(loginUser, userRight, teamId);
                //登录成功
                return Result.success(sessionUser, CodeMsg.LOGIN_SUCCESS);
            }
        }
    }



    //修改用户信息-修改手机号码
    @Override
    public CodeMsg modifyUser(ModifyVO modifyVO) {
        User userPO = new User();
        userPO.setUserId(modifyVO.getUserId());
        //TODO 这个需要校验一下是否正确
        BeanUtils.copyProperties(modifyVO,userPO);
        if (Constant.DATE_CHANGE_SUCCESS.equals(usersMapper.modifyUserMsg(userPO))) {
            return CodeMsg.MODIFY_SUCCESS;
        }
        //修改用户信息失败
        return CodeMsg.MODIFY_ERROR;
    }




    @Override
    public CodeMsg modifyUserPassword(String universityCode, ModifyPasswordVO modifyPasswordVO, Integer code) {
        Integer message = modifyPasswordVO.getMsgCode();
        //验证码输入正确
        if (code.equals(message)) {
            User user = usersMapper.selectByUniversityCode(universityCode);
            String inputPassword = MD5Util.md5(
                    modifyPasswordVO.getUserPassword() + user.getUserSalt());
            //旧密码输入正确
            if (user.getUserPassword().equals(inputPassword)) {
                String newPassword = MD5Util.md5(
                        modifyPasswordVO.getNewPasswprd() + user.getUserSalt());
                User updateUser = new User();
                updateUser.setUniversityCode(universityCode);
                updateUser.setUserPassword(newPassword);
                usersMapper.setNewPassword(updateUser);
                return CodeMsg.MODIFY_PASSWORD_SUCCESS;
            } else {
                return CodeMsg.MODIFY_PASSWORD_ERROR;
            }
        } else {
            return CodeMsg.MESSAGE_ERROR;
        }
    }
}
