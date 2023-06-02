package com.spl.javabot.service;

import com.spl.javabot.entity.GroupSub;
import com.spl.javabot.javaclient.GroupDiscussionInfo;

import java.util.List;

public interface GroupSubService {
    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
    GroupSub save(GroupSub sub);

    List<GroupSub> findAll();
}
