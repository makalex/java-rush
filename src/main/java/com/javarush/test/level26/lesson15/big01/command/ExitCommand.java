package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class ExitCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Are you sure? <y,n>");
        String answer = ConsoleHelper.readString();
        if (answer.equalsIgnoreCase("y")) {
            ConsoleHelper.writeMessage("Bye bye");
        }
    }
}
