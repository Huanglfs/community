package com.nowcoder.community.service;

public interface LikeService {
    long findEntityLikeCount(int entityType, int entityId);

    int findEntityLikeStatus(int userId, int entityType, int entityId);

    void like(int userId, int entityType, int entityId, int entityUserId);

    int findUserLikeCount(int userId);
}
