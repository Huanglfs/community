package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageMapper {
    //查询当前用户所拥有的对话列表，针对每个会话返回最新私信
    List<Message> findConversations(@Param("userId") int userId, @Param("offset") int offset, @Param("limit") int limit);

    //查询用户的会话数量
    int findConversationCount(int userId);

    //查询某个对话所包含的私信列表
    List<Message> findLetters(@Param("conversationId") String conversationId, @Param("offset") int offset, @Param("limit") int limit);

    //查询某个会话包含的私信数量
    int findLetterCount(String conversationId);

    //查询未读
    int findLetterUnreadCount(@Param("userId") int userId, @Param("conversationId") String conversationId);

    // 新增消息
    int insertMessage(Message message);

    // 修改消息的状态
    int updateStatus(@Param("ids") List<Integer> ids, @Param("status") int status);

    // 查询某个主题下最新的通知
    Message selectLatestNotice(@Param("userId") int userId, @Param("topic") String topic);

    // 查询某个主题所包含的通知数量
    int selectNoticeCount(@Param("userId") int userId, @Param("topic") String topic);

    // 查询未读的通知的数量
    int selectNoticeUnreadCount(@Param("userId") int userId, @Param("topic") String topic);

    //查询某个主题所包含的通知列表
    List<Message> selectNotices(@Param("userId") int userId,@Param("topic") String topic,@Param("offset") int offset,@Param("limit") int limit);

}
