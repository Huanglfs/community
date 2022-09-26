package com.nowcoder.community.service;

import com.nowcoder.community.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {

    List<Comment> findCommentsByEntity(@Param("entityType") int entityType, @Param("entityId") int entityId, @Param("offset") int offset, @Param("limit") int limit);

    int findCommentCount(@Param("entityType") int entityType, @Param("entityId") int entityId);

    int addComment(Comment comment);

    Comment findCommentById(int id);
}
