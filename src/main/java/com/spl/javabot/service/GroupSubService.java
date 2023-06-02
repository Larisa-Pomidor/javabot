package com.spl.javabot.service;

import com.spl.javabot.entity.GroupSub;
import com.spl.javabot.javaclient.GroupDiscussionInfo;

public interface GroupSubService {
    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}
