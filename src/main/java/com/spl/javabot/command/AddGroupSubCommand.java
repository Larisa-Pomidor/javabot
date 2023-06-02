package com.spl.javabot.command;

import com.spl.javabot.entity.GroupSub;
import com.spl.javabot.javaclient.GroupDiscussionInfo;
import com.spl.javabot.javaclient.GroupRequestArgs;
import com.spl.javabot.javaclient.JavaGroupClient;
import com.spl.javabot.service.GroupSubService;
import com.spl.javabot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.stream.Collectors;

import static com.spl.javabot.command.CommandName.ADD_GROUP_SUB;
import static com.spl.javabot.command.CommandUtils.getChatId;
import static com.spl.javabot.command.CommandUtils.getMessage;
import static java.util.Objects.isNull;
import static javax.xml.stream.XMLStreamConstants.SPACE;
import static org.apache.commons.lang3.StringUtils.isNumeric;

public class AddGroupSubCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final JavaGroupClient javaGroupClient;
    private final GroupSubService groupSubService;

    public AddGroupSubCommand(SendBotMessageService sendBotMessageService, JavaGroupClient javaGroupClient,
                              GroupSubService groupSubService) {
        this.sendBotMessageService = sendBotMessageService;
        this.javaGroupClient = javaGroupClient;
        this.groupSubService = groupSubService;
    }

    @Override
    public void execute(Update update) {
        if (getMessage(update).equalsIgnoreCase(ADD_GROUP_SUB.getCommandName())) {
            sendGroupIdList(String.valueOf(getChatId(update)));
            return;
        }
        String groupId = getMessage(update).split(" ")[1];
        String chatId = String.valueOf(getChatId(update));
        if (isNumeric(groupId)) {
            GroupDiscussionInfo groupById = javaGroupClient.getGroupById(Integer.parseInt(groupId));
            if (isNull(groupById.getId())) {
                sendGroupNotFound(chatId, groupId);
            }
            GroupSub savedGroupSub = groupSubService.save(chatId, groupById);
            sendBotMessageService.sendMessage(chatId, "Подписал на группу " + savedGroupSub.getTitle());
        } else {
            sendGroupNotFound(chatId, groupId);
        }
    }

    private void sendGroupNotFound(String chatId, String groupId) {
        String groupNotFoundMessage = "Нет группы с ID = \"%s\"";
        sendBotMessageService.sendMessage(chatId, String.format(groupNotFoundMessage, groupId));
    }

    private void sendGroupIdList(String chatId) {
        String groupIds = javaGroupClient.getGroupList(GroupRequestArgs.builder().build()).stream()
                .map(group -> String.format("%s - %s \n", group.getTitle(), group.getId()))
                .collect(Collectors.joining());

        String message = "Чтобы подписаться на группу - передай комадну вместе с ID группы. \n" +
                "Например: /addGroupSub 16. \n\n" +
                "я подготовил список всех групп - выбирай какую хочешь :) \n\n" +
                "имя группы - ID группы \n\n" +
                "%s";

        sendBotMessageService.sendMessage(chatId, String.format(message, groupIds));
    }
}