package com.spl.javabot.command;

import com.spl.javabot.javaclient.JavaGroupClient;
import com.spl.javabot.service.GroupSubService;
import com.spl.javabot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;
import com.spl.javabot.service.TelegramUserService;

import static com.spl.javabot.command.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService,
                            JavaGroupClient javaGroupClient,
                            GroupSubService groupSubService) {

        commandMap =   new ImmutableMap.Builder<String, Command>()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .put(STAT.getCommandName(), new StatCommand(sendBotMessageService, telegramUserService))
                .put(ADD_GROUP_SUB.getCommandName(), new AddGroupSubCommand(sendBotMessageService, javaGroupClient, groupSubService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }

}
