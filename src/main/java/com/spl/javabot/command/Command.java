package com.spl.javabot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {

    /**
     * Main method, which is executing command logic.
     */
    void execute(Update update);
}