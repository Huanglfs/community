package com.nowcoder.community.service;

import com.nowcoder.community.entity.LoginTicket;
import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface UserService {
    User findById(int id);

    User findByEmail(String email);

    int insertUser(User user);

    int updateStatus(@Param("id") int id, @Param("status") int status);

    /**
     * 更新用户头像
     *
     * @param id
     * @param headerUrl
     * @return
     */

    int updateHeader(@Param("id") int id, @Param("headerUrl") String headerUrl);

    int updatePassword(@Param("id") int id, @Param("password") String password);

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    Map<String, Object> register(User user);

    /**
     * 实现用户邮箱激活
     *
     * @param userID
     * @param code
     * @return
     */
    int activation(int userID, String code);

    /**
     * 用户注册后登录
     *
     * @param username
     * @param password
     * @param expiredSeconds
     * @return
     */
    Map<String, Object> login(String username, String password, int expiredSeconds);

    /**
     * 退出登录
     * @param ticket
     */
    void logout(String ticket);

    /**
     * 查找登录凭证
     * @param ticket
     * @return
     */
    LoginTicket findLoginTicket(String ticket);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */

    User findUserByName(String username);


}
