package com.nowcoder.community.service;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface UserService {
    User findById(int id);
    User findByName(String username);
    User findByEmail(String email);
    int insertUser(User user);
    int updateStatus(@Param("id")int id, @Param("status") int status);
    //更新用户头像
    int updateHeader(@Param("id") int id, @Param("headerUrl") String headerUrl);
    int updatePassword(@Param("id") int id,@Param("password") String password);
}
