package com.nowcoder.community.service.Impl;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.util.SensitiveFilter;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class DiscussPostServiceImpl implements DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Override
    public List<DiscussPost> findDiscussPosts(int userID, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userID,offset,limit);
    }

    @Override
    public int findDiscussPostRows(int userID) {
        return discussPostMapper.selectDiscussPostRows(userID);
    }

    @Override
    public int addDiscussPosts(DiscussPost discussPost) {
        if (discussPost==null){
            throw new IllegalArgumentException("参数不能为空");
        }
        //转义HTML标记
        discussPost.setTitle(HtmlUtils.htmlEscape(discussPost.getTitle()));
        discussPost.setContent(HtmlUtils.htmlEscape(discussPost.getContent()));
        //过滤敏感词
        discussPost.setTitle(sensitiveFilter.filter(discussPost.getTitle()));
        discussPost.setContent(sensitiveFilter.filter(discussPost.getContent()));
        return discussPostMapper.insertDiscussPosts(discussPost);
    }

    @Override
    public DiscussPost findDiscussPostById(int Id) {
        return discussPostMapper.selectDiscussPostById(Id);
    }

    @Override
    public int updateCommentCount(@Param("id") int id, @Param("commentCount") int commentCount) {
        return discussPostMapper.updateCommentCount(id,commentCount);
    }
}
