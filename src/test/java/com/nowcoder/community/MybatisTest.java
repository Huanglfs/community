package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@SpringBootTest
public class MybatisTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper ;
    @Test
    public void selectById(){
        User user =  userMapper.selectById(101);
        System.out.println(user);
    }
    @Test
    public void selectByUsername(){
        User user = userMapper.selectByName("aaa");
        System.out.println(user);
    }
    @Test
    public void selectByEmail(){
        User user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }
    @Test
    public void updateStatus(){
        int result = userMapper.updateStatus(101, 0);
        System.out.println(result);
    }

    @Test
    public void updatePassword(){
        int result = userMapper.updatePassword(101, "12345678");
        System.out.println(result);
    }

    @Test
    public void selectDiscussPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(101, 1, 2);
        for (DiscussPost discussPost:discussPosts) {
            System.out.println(discussPost);
        }
    }
    @Test
    public void selectDiscussPostRows(){
        int rows = discussPostMapper.selectDiscussPostRows(101);
        System.out.println(rows);
    }

}
