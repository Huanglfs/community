package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(@Param("userID") int userID, @Param("offset") int offset, @Param("limit") int limit);

    int selectDiscussPostRows(@Param("userID") int userID);
    int insertDiscussPosts(DiscussPost discussPost);
    DiscussPost selectDiscussPostById(int Id);
    int updateCommentCount(@Param("id") int id,@Param("commentCount") int commentCount);
}
