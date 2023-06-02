package com.spl.javabot.command;

public enum CommandName {
    START("/start"),
    STOP("/stop"),
    NO("/no"),
    STAT("/stat"),
    ADD_GROUP_SUB("/addgroupsub"),
    HELP("/help");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
