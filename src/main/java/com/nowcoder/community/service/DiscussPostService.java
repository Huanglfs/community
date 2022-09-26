package com.nowcoder.community.service;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DiscussPostService {

    List<DiscussPost> findDiscussPosts(@Param("userID") int userID, @Param("offset") int offset, @Param("limit") int limit);

    int findDiscussPostRows(@Param("userID") int userID);
}
