package com.nowcoder.community;

import com.nowcoder.community.util.SensitiveFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class sensitiveTest {
    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void test(){
        System.out.println(sensitiveFilter.filter("嫖娼不犯法"));
    }
}
