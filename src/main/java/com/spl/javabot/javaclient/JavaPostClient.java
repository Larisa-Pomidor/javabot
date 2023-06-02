package com.spl.javabot.javaclient;

import java.util.List;

public interface JavaPostClient {
    List<PostInfo> findNewPosts(Integer groupId, Integer lastPostId);
}
