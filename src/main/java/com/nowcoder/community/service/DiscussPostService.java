package com.nowcoder.community.service;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DiscussPostService {
    /**
     * 获取讨论列表
     * @param userID
     * @param offset
     * @param limit
     * @return
     */
    List<DiscussPost> findDiscussPosts(@Param("userID") int userID, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 获取总讨论行数
     * @param userID
     * @return
     */
    int findDiscussPostRows(@Param("userID") int userID);

    /**
     * 增加讨论
     * @param discussPost
     * @return
     */
    int addDiscussPosts(DiscussPost discussPost);

    /**
     * 查询帖子
     * @param Id
     * @return
     */
    DiscussPost findDiscussPostById(int Id);

    /**
     * 更新帖子数量
     * @param id
     * @param commentCount
     * @return
     */
    int updateCommentCount(@Param("id") int id,@Param("commentCount") int commentCount);
}
