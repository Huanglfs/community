package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailTest {
    @Autowired
    private MailClient mailClient;

    @Test
    public void test(){
        mailClient.sendMail("huanglfs@163.com","test","welcome");
    }
}
