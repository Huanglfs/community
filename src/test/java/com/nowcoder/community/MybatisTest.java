package com.nowcoder.community;

import com.nowcoder.community.dao.CommentMapper;
import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.LoginTicketMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.Comment;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.LoginTicket;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class MybatisTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper ;

    @Autowired
    private CommentMapper commentMapper;
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
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, 1, 10);
        for (DiscussPost discussPost:discussPosts) {
            System.out.println(discussPost);
        }
    }
    @Test
    public void selectDiscussPostRows(){
        int rows = discussPostMapper.selectDiscussPostRows(101);
        System.out.println(rows);
    }
    @Test
    public void insertLoginTicket(){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(1);
        loginTicket.setTicket("10086");
        loginTicket.setExpired(new Date());
        loginTicket.setStatus(0);
        loginTicketMapper.insertLoginTicket(loginTicket);
    }
    @Test
    public void selectByTicket(){
        LoginTicket result = loginTicketMapper.selectByTicket("10086");
        System.out.println(result.toString());
    }
    @Test
    public void updateTicketStatus(){
        int result = loginTicketMapper.updateStatus("10086",1);
        System.out.println(result);

    }
    @Test
    public void selectCommentByEntity(){
        List<Comment> commentList = commentMapper.selectCommentByEntity(1, 228, 1, 5);
        for (Comment comment:commentList) {
            System.out.println(comment);
        }
    }

}
