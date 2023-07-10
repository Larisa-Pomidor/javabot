package com.spl.javabot.command;

import com.spl.javabot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.spl.javabot.command.CommandName.*;

public class HelpCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("✨<b>Available commands:</b>✨\n\n"

                    + "<b>Start/Stop working with the bot:</b>\n"
                    + "%s - start working with bot\n"
                    + "%s - pause working with bot\n\n"
                    + "%s - get assistance\n"
                    + "%s - view statistics\n"
                    + "%s - subscribe to a group\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName(),
            STAT.getCommandName(), ADD_GROUP_SUB.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
