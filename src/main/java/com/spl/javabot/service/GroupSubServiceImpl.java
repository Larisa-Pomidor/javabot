package com.spl.javabot.service;

import com.spl.javabot.entity.GroupSub;
import com.spl.javabot.entity.TelegramUser;
import com.spl.javabot.javaclient.GroupDiscussionInfo;
import com.spl.javabot.repository.GroupSubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class GroupSubServiceImpl implements GroupSubService {

    private final GroupSubRepository groupSubRepository;
    private final TelegramUserService telegramUserService;

    @Autowired
    public GroupSubServiceImpl(GroupSubRepository groupSubRepository, TelegramUserService telegramUserService) {
        this.groupSubRepository = groupSubRepository;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo) {
        TelegramUser telegramUser = telegramUserService.findByChatId(chatId).orElseThrow(NotFoundException::new);
        //TODO add exception handling
        GroupSub groupSub;
        Optional<GroupSub> groupSubFromDB = groupSubRepository.findById(groupDiscussionInfo.getId());
        if(groupSubFromDB.isPresent()) {
            groupSub = groupSubFromDB.get();
            Optional<TelegramUser> first = groupSub.getUsers().stream()
                    .filter(it -> it.getChatId().equalsIgnoreCase(chatId))
                    .findFirst();
            if(first.isEmpty()) {
                groupSub.addUser(telegramUser);
            }
        } else {
            groupSub = new GroupSub();
            groupSub.addUser(telegramUser);
            groupSub.setId(groupDiscussionInfo.getId());
            groupSub.setTitle(groupDiscussionInfo.getTitle());
        }
        return groupSubRepository.save(groupSub);
    }

    @Override
    public GroupSub save(GroupSub groupSub) {
        return groupSubRepository.save(groupSub);
    }

    @Override
    public List<GroupSub> findAll() {
        return groupSubRepository.findAll();
    }
}
